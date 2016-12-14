package com.myspring.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myspring.entity.Score;
import com.myspring.repo.JDBC;

public class JdbcTest {
	public static void main(String[] args) throws SQLException{
		Score score = new Score();
		score.setSNO("wanghaidong");
		score.setCNO("lucifer");
		score.setDEGREE(1.9f);
		System.out.println("begin SQL...");
		ApplicationContext context = new ClassPathXmlApplicationContext("springmvc.xml");
		JDBC jdbc = (JDBC)context.getBean("jdbc");
		jdbc.addScore(score);
		System.out.println("end SQL...");
	}
}
