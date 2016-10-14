package com.latewind.intercepter.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.latewind.common.tools.NetUtil;
import com.latewind.pojo.web.NavTabs;
import com.latewind.service.web.IWebConfigService;

public class WebConfigIntercepter extends HandlerInterceptorAdapter {
	Logger logger = Logger.getLogger(WebConfigIntercepter.class);
	@Resource
	private IWebConfigService webConfigService;
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

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String clientIp=request.getRemoteAddr();
		List<NavTabs> tabs=webConfigService.listNavTabs();
		// 顶部导航栏配置
		HashMap<String, String> navMap=new HashMap<String,String>();
//		navMap.put("index", "1");
//		设置导航
		request.setAttribute("navTabs", tabs);
//		Request.CurrentExecutionFilePath
		String url=request.getRequestURI();
		logger.info(url+"网站配置拦截---webConfig 客户IP Address"+NetUtil.getRemoteHost(request));
		
				return super.preHandle(request, response, handler);
	}

}
