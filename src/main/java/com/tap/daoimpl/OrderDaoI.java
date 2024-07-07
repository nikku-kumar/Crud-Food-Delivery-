package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderDao;
import com.tap.model.Order;

public class OrderDaoI implements OrderDao{
 
  static final String INSERT_QUERY="INSERT INTO `order`(`orderId`,`orestaurantId`,`ouserId`,`totalAmount`,`modeOfPayment`,`status`,`historyId`) "+ "VALUES(?,?,?,?,?,?,?)";
  static final String SELECT_QUERY="SELECT * FROM `order` WHERE `ouserId`=?";
  static final String SELECT_ALL_QUERY = "SELECT * FROM `order`";
  static final String UPDATE_QUERY = "UDATE `order` SET `orestaurantId`=? ,`ouserId`=? ,`totalAmount`=?, `modeOfPayment`=?, `status`=? WHERE `orderId`=? ";
  static final String DELETE_QUERY = "DELETE FROM `order` WHERE `orderId`=?";
   private Connection connection; 
	
	public OrderDaoI() {
		String url="jdbc:mysql://localhost:3306/tapfoods";
		String username="root";
		String password="123456";
		
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
	public void addOrder(Order order) {
		try {
			PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
			statement.setString(1, order.getOrderId());
			statement.setInt(2, order.getOrestaurantId());
			statement.setInt(3,order.getOuserId() );
			statement.setFloat(4, order.getTotalAmount());
			statement.setString(5, order.getModeOfPayment());
			statement.setString(6, order.getStatus());
			statement.setInt(7,order.getHistoryId() );
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Order> getOrder(int ouserId) {
		ArrayList<Order> list = new ArrayList<Order>();
		 PreparedStatement statement;
		 Order o1=null;
		try {
			statement = connection.prepareStatement(SELECT_QUERY);
			statement.setInt(1, ouserId);
			ResultSet set = statement.executeQuery();
			
			while(set.next()) {
			int orestaurantId=set.getInt(2);
			String orderId=set.getString(1);
			float totalAmount=set.getFloat(4);
			String modeOfPayment=set.getString(5);
			String status=set.getString(6);
			int historyId=set.getInt(7);
			
			o1 = new Order(orderId, orestaurantId, ouserId, totalAmount, modeOfPayment, status,historyId);
			list.add(o1);
		} 
		}
	  catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Order> getAll() {
		ArrayList<Order> list = new ArrayList<Order>();
		ResultSet set=null;
		Order o2=null;
		try {
			Statement statement = connection.createStatement();
			set = statement.executeQuery(SELECT_ALL_QUERY);
			
			while(set.next()) {
				String orderId=set.getString(1);
				int orestaurantId=set.getInt(2);
				int ouserId=set.getInt(3);
				float totalAmount=set.getFloat(4);
				String modeOfPayment=set.getString(5);
				String status=set.getString(6);
				int historyId=set.getInt(7);
				
				o2=new Order(orderId, orestaurantId, ouserId, totalAmount, modeOfPayment, status,historyId);
				list.add(o2);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void updateUser(Order order) {
		PreparedStatement statement = null;
		
		try {
			statement=connection.prepareStatement(UPDATE_QUERY);
			statement.setInt(1,order.getOrestaurantId());
			statement.setInt(2,order.getOuserId());
			statement.setFloat(3,order.getTotalAmount());
			statement.setString(4, order.getModeOfPayment());
			statement.setString(5, order.getStatus());
			statement.setString(6, order.getOrderId());
			
			statement.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(String orderId) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);
			prepareStatement.setString(1, orderId);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
