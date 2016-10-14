package com.latewind.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.midi.MidiDevice.Info;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.latewind.common.tools.ValidateLogin;
import com.latewind.pojo.notice.Headline;
import com.latewind.pojo.user.LoginInfo;
import com.latewind.pojo.user.LoginMessage;
import com.latewind.service.notice.INoticeService;
import com.latewind.service.user.IUserInfoService;

@Controller
public class UserManController {
@Resource
private IUserInfoService userInfoService;
Logger logger = Logger.getLogger(UserManController.class);

@Resource
private INoticeService noticeService=null;


/**
 * 用户登录Action 连接到登录界面25
 * @param request
 * @param model
 * @return
 */
@RequestMapping("/front/user/login.html")
	public String UserLoginLink(HttpServletRequest request,Model model){
	//获取当前的头条 
	Headline headline =noticeService.getHeadLine();
	model.addAttribute("headline", headline);
		logger.info("ServletPath"+request.getServletPath());
		logger.info("referer"+request.getHeader("referer"));
		model.addAttribute("origPage", request.getHeader("referer"));
		return "front/user/login";
	}
/**
 * 小窗口登录
 * @param request
 * @param model
 * @param session
 * @param userName
 * @param password
 * @param autoLogin
 * @param origPage
 * @return
 */
@ResponseBody	 
@RequestMapping(value="/front/user/loginAction",method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
public String UserLoginAction(HttpServletRequest request,Model model,HttpSession session,String userName,String password,String autoLogin,String origPage){
	LoginInfo loginInfo=userInfoService.verifyUserName(userName, password);
	//登录不成功
	if(!loginInfo.getSuccess()){
	//设置提示错误信息
		model.addAttribute("alertMsg", loginInfo.getAlertMsg());
		model.addAttribute("origPage", origPage);
		//返回登录页面		
		return "<p>"+loginInfo.getAlertMsg()+"</p>";
	}	
	logger.info(userName+password+autoLogin+origPage);
	logger.info("referer in Action"+request.getHeader("referer"));
	//将用户信息存放到
	ValidateLogin.setLoginInfo(request, loginInfo);
	//返回原来页面
	return "<p>success</p>";
}


@ResponseBody	 
@RequestMapping(value="/front/user/signUpAction",method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
public String UserSignUpAction(HttpServletRequest request,Model model,HttpSession session,
		String userName,String oncePassword,String twicePassword){

	//TODO 添加验证
	userInfoService.addUser(userName, oncePassword);

	logger.info(userName+oncePassword+twicePassword);
	//返回原来页面
	return "<p>success</p>";
}

@RequestMapping("/front/user/logout")
public String UserLogoutAction(HttpServletRequest request){
	
	ValidateLogin.setLoginInfo(request, null);
	return "redirect:/index";
}
@RequestMapping("/front/user/loginPageAction")
public String UserLoginAction2(HttpServletRequest request,Model model,HttpSession session,String userName,String password,String autoLogin,String origPage){
	
	
	String referer=request.getHeader("referer");
	LoginInfo loginInfo=userInfoService.verifyUserName(userName, password);
	//登录不成功
	if(!loginInfo.getSuccess()){
	//设置提示错误信息
		model.addAttribute("alertMsg", loginInfo.getAlertMsg());
		model.addAttribute("origPage", origPage);
		//返回登录页面		
		return "redirect:"+referer;
	}	
	logger.info(userName+password+autoLogin+origPage);
	logger.info("referer in Action"+request.getHeader("referer"));
	//将用户信息存放到
	ValidateLogin.setLoginInfo(request, loginInfo);
	// 将路径名HTTP port SSM 分离出来
	String contextPath=request.getContextPath();
	System.out.println("contextPath:"+contextPath);
	// 取头+length=index
	
	if (origPage==null) {
		return "redirect:/index";
	}
	String aimPath=null;
//	aimPath.toLowerCase();
	try {
		aimPath=origPage.substring(origPage.indexOf(contextPath)+contextPath.length());
		
	} catch (Exception e) {
		
		System.out.println("error");
		// TODO: handle exception
		return "redirect:/index";
	}
//	System.out.println(aimPath);
	//返回原来页面
	//
	return "redirect:"+aimPath;
}
	
}
