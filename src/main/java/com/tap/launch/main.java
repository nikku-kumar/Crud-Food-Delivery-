package com.tap.launch;

import com.tap.daoI.UserDaoI;
import com.tap.model.User;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User u = new User("shubham","shubham@gmail.com",23);
		UserDaoI ur = new UserDaoI();
		ur.AddStudent(u);
		
		

	}

}
