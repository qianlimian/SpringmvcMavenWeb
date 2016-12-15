package com.myspring.dao;

import com.myspring.entity.User;

public interface UserRepository {
	public void addUser(User user);
	public User getUserById(Integer id);
	public void saveUser(User user);
}
