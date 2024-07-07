package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDao;
import com.tap.model.User;

public class UserDaoI implements UserDao {

	static final String INSERT_QUERY = "INSERT INTO `user`(`name`,`email`,`phoneNo`,`address`,`userName`,`password`,`role`) values(?,?,?,?,?,?,?)";
	static final String REGISTER_QUERY = "INSERT INTO `user`(`name`,`email`,`phoneNo`,`userName`,`password`) values(?,?,?,?,?)";
	static final String SELECT_QUERY = "SELECT * FROM `user` Where `userId`=?";
	static final String SELECT_PASS_QUERY = "SELECT `password` FROM `user` Where `userName`=?";
	static final String SELECT_NAME_QUERY = "SELECT `name` FROM `user` Where `userName`=?";
	static final String SELECT_USER_ID_QUERY = "SELECT `userId` FROM `user` Where `userName`=?";
	static final String SELECT_ALL_QUERY = "SELECT * FROM `user`";
	static final String UPDATE_QUERY = "UDATE `user` SET `name`=? ,`email`=? ,`phoneNo`=?, `address`=?, `userName`=?,`password`=?,`role`=? WHERE `userId`=? ";
	static final String DELETE_QUERY = "DELETE FROM `user` WHERE `userId`=?";

	private Connection connection;

	public UserDaoI() {
		String url = "jdbc:mysql://localhost:3306/tapfoods";
		String username = "root";
		String password = "123456";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("class is loaded");
			connection=DriverManager.getConnection(url, username, password);
//			System.out.println("connection established");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addUser(User user) {
		try {
			PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);

			
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setLong(3, user.getPhoneNo());
			statement.setString(4, user.getAddress());
			statement.setString(5, user.getUserName());
			statement.setString(6, user.getPassword());
			statement.setString(7, user.getRole());
		/*	int update = */  statement.executeUpdate();
//			System.out.println(update);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	@Override
	public int registerUser(User user) {
		//static final String REGISTER_QUERY = "INSERT INTO `user`(`name`,`email`,`phoneNo`,`userName`,`password`,) values(?,?,?,?,?)";
		int n=0;
		try {
			PreparedStatement statement = connection.prepareStatement(REGISTER_QUERY);

			
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setLong(3, user.getPhoneNo());
			statement.setString(4, encryptipon(user.getUserName()));
			statement.setString(5, encryptipon(user.getPassword()));
			
			 n = statement.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return n;
	}
	@Override
	public User getUser(int userId) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User u1 = null;
		try {
			statement = connection.prepareStatement(SELECT_QUERY);

			statement.setInt(1, userId);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);
				Long phoneNo = resultSet.getLong(4);
				String address = resultSet.getString(5);
				String userName = resultSet.getString(6);
				String password = resultSet.getString(7);
				String role = resultSet.getString(8);
				LocalDateTime createdDate = resultSet.getTimestamp(9).toLocalDateTime();
				LocalDateTime lastLogin = resultSet.getTimestamp(10).toLocalDateTime();
				u1 = new User(userId, name, email, phoneNo, address, userName, password
						,role, createdDate, lastLogin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u1;
	}

	@Override
	public List<User> getAllUser() {
		Statement createStatement = null;
		ResultSet resultSet = null;
		User u2 = null;
		ArrayList<User> list = new ArrayList<User>();
		try {
			createStatement = connection.createStatement();
			resultSet = createStatement.executeQuery(SELECT_ALL_QUERY);

			while (resultSet.next()) {
				int userId = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);
				long phoneNo = resultSet.getLong(4);
				String address = resultSet.getString(5);
				String userName = resultSet.getString(6);
				String password = resultSet.getString(7);
				String role = resultSet.getString(8);
				LocalDateTime createdDate = resultSet.getTimestamp(9).toLocalDateTime();
				LocalDateTime lastLogin = resultSet.getTimestamp(10).toLocalDateTime();
				
				u2 = new User(userId, name, email, phoneNo, address, userName, password,role,createdDate,lastLogin);
				list.add(u2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void updateUser(User user) {
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getEmail());
			prepareStatement.setLong(3, user.getPhoneNo());
			prepareStatement.setString(4, user.getAddress());
			prepareStatement.setString(5, user.getUserName());
			prepareStatement.setString(6, user.getPassword());
			prepareStatement.setString(7, user.getRole());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(int userId) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);
			prepareStatement.setInt(1, userId);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getPassword(String userName) {
		PreparedStatement statement=null;
		String password="";
		try {
			statement = connection.prepareStatement(SELECT_PASS_QUERY);
			statement.setString(1, encryptipon(userName));
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {			
				 password=resultSet.getString("password");	
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return decryptipon(password);
	}
	public String getName(String userName) {
		PreparedStatement statement=null;
		String name="";
		try {
			statement = connection.prepareStatement(SELECT_NAME_QUERY);
			statement.setString(1, encryptipon(userName));
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {			
				 name=resultSet.getString("name");	
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return name;
	}
    
	public int getUserId(String userName) {
		PreparedStatement statement=null;
		int userId=0;
		try {
			statement = connection.prepareStatement(SELECT_USER_ID_QUERY);
			statement.setString(1, encryptipon(userName));
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {			
				userId=resultSet.getInt("userId");	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userId;
	}
	
	
    
	public static String  encryptipon(String s) {
		String t="";
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			c=(char)(c+1);
			t=t+c;
		}
		return t;
	}
	
	public static String decryptipon(String m) {
		String n="";
		for(int i=0;i<m.length();i++) {
			char c=m.charAt(i);
			c=(char)(c-1);
			n=n+c;
		}
		return n;
	}
	
	

}

