package com.crud.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FirstInterceptor implements HandlerInterceptor{
	/**
	 * 调用目标方法之前调用
	 * 可以用于权限管理，日志
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle!");
		return true;
	}
	/**
	 * 调用目标方法之后，渲染视图之前
	 * 可以用于修改视图
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle!!");
		
	}
	/**
	 * 渲染视图之后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion!!!");
		
	}

}
