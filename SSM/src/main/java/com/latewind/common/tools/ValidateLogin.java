package com.latewind.common.tools;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.latewind.common.constants.CommonConstants;
import com.latewind.pojo.admin.user.SysmLoginInfo;
import com.latewind.pojo.user.LoginInfo;

public class ValidateLogin {

	public static LoginInfo getLoginInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();

		LoginInfo loginInfo = (LoginInfo) session.getAttribute(CommonConstants.LOGIN_INFO);

		return loginInfo;
	}

	public static void setLoginInfo(HttpServletRequest request, LoginInfo loginInfo) {
		HttpSession session = request.getSession();
		session.setAttribute(CommonConstants.LOGIN_INFO, loginInfo);
	}
	
	

	public static void setSysmLoginInfo(HttpServletRequest request, SysmLoginInfo loginInfo) {
		HttpSession session = request.getSession();
		session.setAttribute(CommonConstants.SYSTEM_LOGIN_INFO, loginInfo);
	}

	public static SysmLoginInfo getSysmLoginInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();

		SysmLoginInfo loginInfo = (SysmLoginInfo) session.getAttribute(CommonConstants.SYSTEM_LOGIN_INFO);

		return loginInfo;
		
		
	}
	

}
