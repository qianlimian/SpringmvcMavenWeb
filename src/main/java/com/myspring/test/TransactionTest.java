package com.myspring.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myspring.dao.TransactionExample;

public class TransactionTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springmvc.xml");
		TransactionExample transactionExample = (TransactionExample) ctx.getBean("transactionExample");
		transactionExample.transactionOperation();
		System.out.println("Finished...");

	}

}
