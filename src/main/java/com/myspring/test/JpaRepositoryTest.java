package com.myspring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myspring.dao.JpaUserRepository;
import com.myspring.entity.User;

public class JpaRepositoryTest {
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springmvc.xml");
		JpaUserRepository jpaUserRepository = (JpaUserRepository) ctx.getBean("jpaUserRepository");
		//≤È—Øuser
		User user = jpaUserRepository.getUserById(3);
		System.out.println(user);
		//ÃÌº”user
		User newUser = new User();
		newUser.setId(10);
		newUser.setAge(20);
		newUser.setName("10k");
		newUser.setSex("female");
		jpaUserRepository.addUser(newUser);
		
		
	}
}
