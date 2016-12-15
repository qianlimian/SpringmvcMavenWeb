package com.myspring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myspring.dao.UserDao;
import com.myspring.entity.User;

public class UserTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("springmvc.xml");
		UserDao userDao = (UserDao) ctx.getBean("userDao");
		/*����һ���û�
		 * User user = new User();
		user.setAge(30);
		user.setName("yujiaojiao");
		user.setSex("female");
		System.out.println("begin...");
		userDao.insertUser(user);
		System.out.println("end...");*/
		//����id���в���
		User user = userDao.findOne(1);
		System.out.println(user);
		//jdbcģ�����user
		User userAdd = new User(10,"mark",23,"male");
		userDao.addUser(userAdd);

	}

}
