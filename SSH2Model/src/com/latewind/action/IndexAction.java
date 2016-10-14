/**
 * 
 */
package com.latewind.action;

import java.util.Map;

import org.apache.log4j.Logger;

import com.latewind.bean.UserInfo;
import com.latewind.service.UserInfoService;
import com.latewind.tools.CookieUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class IndexAction extends ActionSupport {
static Logger logger=Logger.getLogger(IndexAction.class);
private  UserInfoService userInfoService;
	public String execute(){
		
		//监测Cookie中是否存储
		String userName=CookieUtil.getCookie("userInfo");
		if(userName!=null){
			
			Map<String , Object>session= ActionContext.getContext().getSession();
			//session中存储用户名
			UserInfo userInfo=userInfoService.findByAccount(userName);
			session.put("userInfo",userInfo);
			logger.info("取出cookie放入");
			
			return SUCCESS;	
		}else{
			return LOGIN;
		}
	}
	public UserInfoService getUserInfoService() {
		return userInfoService;
	}
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	
	

}
