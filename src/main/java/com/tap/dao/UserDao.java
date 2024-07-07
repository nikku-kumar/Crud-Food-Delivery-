package com.tap.dao;

import java.util.List;


import com.tap.model.User;

public interface UserDao {
	void addUser(User user);
	int registerUser(User user);

	User getUser(int userId);

	List<User> getAllUser();

	void updateUser(User user);

	void deleteUser(int userId);
	String getPassword(String userName);
}
