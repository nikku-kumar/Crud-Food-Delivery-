package com.tap.daoI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.Dao.dao;
import com.tap.model.User;

public class UserDaoI implements dao{
	
	final static String INSERT_QUERY="INSERT into `students` (`name`, `email`, `age`) values (?, ?, ?)";
	final static String SELECT_QUERY ="SELECT * from `students` where `id`= ?";
	final static String SELECT_ALL_QUERY="SELECT * from `students`";
	final static String UPDATE_QUERY="UPDATE `students` SET `name`=?, `email`=?, `age`=? WHERE `id`=?";
	final static String DELETE_QUERY="DELETE from `students` where `id`= ?";
	String url = "jdbc:mysql://localhost:3306/student_db";
	String username = "root";
	String password = "root";
	Connection connection=null;
	
	public UserDaoI() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void AddStudent(User user) {
		PreparedStatement prepstmt = null;
		
		try {
			prepstmt=connection.prepareStatement(INSERT_QUERY);
			
			prepstmt.setString(1, user.getName());
			prepstmt.setString(2, user.getEmail());
			prepstmt.setInt(3, user.getAge());
			
			prepstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		
		
	}

	@Override
	public User getStudent(int id) {
		PreparedStatement prepstmt=null;
		ResultSet res = null;
		
		User user=null;
		try {
			prepstmt = connection.prepareStatement(SELECT_QUERY);
			
			prepstmt.setInt(1, id);
			res =prepstmt.executeQuery();
			
			while(res.next()) {
				String name =res.getString("name");
				String email=res.getString("email");
				int age = res.getInt("age");
				
				user = new User(id,name,email,age);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAllStudent() {
		Statement statment =null;
		ResultSet res = null;
		User user=null;
		
		ArrayList<User> userList = new ArrayList<User>();
		
		try {
			statment = connection.createStatement();
			res =statment.executeQuery(SELECT_ALL_QUERY);
			while(res.next()) {
				int id = res.getInt("id");
				String name =res.getString("name");
				String email=res.getString("email");
				int age = res.getInt("age");
				
				user = new User(id,name,email,age);
				userList.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		
		return userList;
	}

	@Override
	public void updateStudent(User user) {
          PreparedStatement prepstmt=null;
		
		try {
			prepstmt = connection.prepareStatement(UPDATE_QUERY);
			
			prepstmt.setString(1, user.getName());
			prepstmt.setString(2, user.getEmail());
			prepstmt.setInt(3, user.getAge());
			prepstmt.setInt(4,user.getId());
			
			prepstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (NumberFormatException e) {
		    e.printStackTrace();
		}
	}

	@Override
	public void deleteStudent(int id) {
		PreparedStatement prepstmt=null;
		try {
			
			prepstmt = connection.prepareStatement(DELETE_QUERY);
			prepstmt.setInt(1,id);
			prepstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		
	}
	
	

}
