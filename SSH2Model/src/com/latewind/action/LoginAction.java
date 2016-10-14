package com.latewind.action;

import java.util.Map;

import org.apache.log4j.Logger;

import com.latewind.bean.UserInfo;
import com.latewind.dao.OrdersDAO;
import com.latewind.dao.UserInfoDAO;
import com.latewind.service.UserInfoService;
import com.latewind.tools.CookieUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String userName;
	private String password;
	private String identifyCode;
	private String  alertMsg;
	private String keeplog="un";
	private UserInfoService userInfoService;
	private OrdersDAO ordersDAO;
	private UserInfoDAO userInfoDAO;
	 static Logger logger=Logger.getLogger(LoginAction.class);
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public String getAlertMsg() {
		return alertMsg;
	}

	public void setAlertMsg(String alertMsg) {
		this.alertMsg = alertMsg;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentifyCode() {
		return identifyCode;
	}

	public void setIdentifyCode(String identifyCode) {
		this.identifyCode = identifyCode;
	}
	
	/**
	 * 注销 退出用户
	 * @return
	 */
	public String logout(){
		
		Map<String , Object>session= ActionContext.getContext().getSession();
		session.put("userInfo",null);
		CookieUtil.delCookie("userInfo");
		System.out.println("logout");
		return LOGIN;
	}

	public String login(){
		
		
		
		//验证账号   密码
		//获取session里面储存的验证码
//	System.out.println(userInfoService.isRight("admin", "admin"));
	Map<String , Object>session= ActionContext.getContext().getSession();
      String  code=(String) session.get("IdentifyCode");
//      System.out.println(session.get("userInfo")+"session");
	 
      if(logger.isInfoEnabled()){
		  
		  logger.info("用户尝试登陆");
	  }
	  
      if(session.get("userInfo")!=""&&session.get("userInfo")!=null){
    	  

    	  return SUCCESS;
      }
       
       if(!code.equals(identifyCode)){//验证码不一样
    	   alertMsg="验证码有误";
    	   return LOGIN;
    	 
       }
 
       UserInfo uInfo=userInfoService.findByAccount(userName);
       
       if (uInfo==null) {//验证账号是否存在
    	   alertMsg="账号不存在";
    	   return LOGIN;		  	   
	}else if (!uInfo.getPassword().equals(password)) {//验证密码是否正确
		alertMsg="密码不正确";
		return LOGIN;
		
	}else{
		uInfo.setPassword("com.latewind");//密码隐藏
		session.put("userInfo", uInfo);
		//如果是记住登录，将用户放入Cookie中；
		if(keeplog.equals("keep")){			
			logger.info("保持登录，放入cookie中");
		//	CookieUtil cu=new CookieUtil();
			
			CookieUtil.addCookie("userInfo",uInfo.getUserName());
		}
		
		return SUCCESS;
	}
       		
	}

	/**
	 * @return the ordersDAO
	 */
	public OrdersDAO getOrdersDAO() {
		return ordersDAO;
	}

	/**
	 * @param ordersDAO the ordersDAO to set
	 */
	public void setOrdersDAO(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}

	/**
	 * @return the userInfoDAO
	 */
	public UserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

	/**
	 * @param userInfoDAO the userInfoDAO to set
	 */
	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	/**
	 * @return the keeplog
	 */
	public String getKeeplog() {
		return keeplog;
	}

	/**
	 * @param keeplog the keeplog to set
	 */
	public void setKeeplog(String keeplog) {
		this.keeplog = keeplog;
	}

}
