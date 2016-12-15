package com.myspring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myspring.dao.AutoJpaUserRepository;
import com.myspring.entity.User;

public class AutoJpaTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springmvc.xml");
		AutoJpaUserRepository obj=(AutoJpaUserRepository) ctx.getBean("autoJpaUserRepository");
		User user = obj.findOne(4);
		System.out.println(user);
		User newUser = new User(14,"dony",55,"male");
		obj.save(newUser);
		for(User reuser : obj.findAll()){
			System.out.println(reuser);
		}
		System.out.println("findByName:...");
		System.out.println(obj.findByName("10k"));
		System.out.println("查找年龄大于某个值的用户：");
		List<User> userList = obj.findByAgeGreaterThan(25);
		for(User userTemp : userList){
			System.out.println(userTemp);
		}
		System.out.println("自定义方法：");
		System.out.println(obj.findSomeSpecial("10k"));
	}

}
