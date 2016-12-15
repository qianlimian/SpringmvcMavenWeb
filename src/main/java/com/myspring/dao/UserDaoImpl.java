package com.myspring.dao;

import com.myspring.entity.User;

public interface UserDaoImpl {
	public void insertUser(User user);
	public User findOne(Integer id);
	public void addUser(User user);
}
