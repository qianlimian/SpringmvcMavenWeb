package com.myspring.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myspring.perform.Performance;

public class TestSpring {
	public static void main(String[] args){
		ApplicationContext context = new ClassPathXmlApplicationContext("springmvc.xml");
		Performance prformance = (Performance)context.getBean("dance");
		prformance.perform();
	}
}
