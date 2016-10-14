package com.latewind.intercepter.common;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.latewind.common.tools.ValidateLogin;
import com.latewind.pojo.admin.user.SysmLoginInfo;
import com.latewind.service.sysm.ISystemManService;

public class AdminIntercepter extends HandlerInterceptorAdapter {
	
	
	@Resource
	private ISystemManService systemManService;
	

	Logger logger = Logger.getLogger(AdminIntercepter.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		SysmLoginInfo loginInfo=ValidateLogin.getSysmLoginInfo(request);
		
		if(loginInfo==null){
			String sc = request.getServletContext().getContextPath();

			String requestType = request.getHeader("X-Requested-With");// 识别ajax的响应头
			if (requestType != null && requestType.equals("XMLHttpRequest")) {// 如果是ajax类型，响应logout给前台
				response.getWriter().print("<p>logout</p>");
				
			} else {
				response.sendRedirect(sc + "/admin/login.html");// 跳转登录页面
				logger.info("后台登录拦截：跳转登录界面");
			}
			return false;
		}
		
		Integer roleId =loginInfo.getRoleId();
		String servpath = request.getServletPath();
		logger.info("servlet path"+servpath);
		logger.info(systemManService.hasFunction(servpath, roleId));		
//		----------------------------------登录拦截------------------------------------------- //
		if(systemManService.hasFunction(servpath, roleId)){
			
			return super.preHandle(request, response, handler);
		}else{
			String sc = request.getServletContext().getContextPath();

			response.sendRedirect(sc + "/system/error/not.html");// 跳转登录页面
			logger.info("no have function");
				return false;
			
		}	
	
			}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
				super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
				super.afterConcurrentHandlingStarted(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
				super.postHandle(request, response, handler, modelAndView);
	}


}
