package com.tap.Dao;

import java.util.List;

import com.tap.model.User;

public interface dao {
	
	void AddStudent(User user);
	User getStudent(int id);
	List<User>getAllStudent();
	void updateStudent(User user);
	void deleteStudent(int id);

}
