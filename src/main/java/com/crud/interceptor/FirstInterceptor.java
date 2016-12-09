package com.crud.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FirstInterceptor implements HandlerInterceptor{
	/**
	 * ����Ŀ�귽��֮ǰ����
	 * ��������Ȩ�޹�����־
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle!");
		return true;
	}
	/**
	 * ����Ŀ�귽��֮����Ⱦ��ͼ֮ǰ
	 * ���������޸���ͼ
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle!!");
		
	}
	/**
	 * ��Ⱦ��ͼ֮�����
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion!!!");
		
	}

}
