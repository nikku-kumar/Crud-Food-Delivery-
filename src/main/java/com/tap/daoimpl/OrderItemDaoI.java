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

import com.tap.dao.OrderitemDao;
import com.tap.model.Order;
import com.tap.model.Orderitem;
import com.tap.model.User;

public class OrderItemDaoI implements OrderitemDao {
	
	static final String INSERT_QUERY="INSERT INTO  `orderitem`(`menuId`,`name`,`quantity`,`price`,`restaurantId_fk`,`userId_fk`,`historyId`)VALUES(?,?,?,?,?,?,?) ";
	static final String SELECT_QUERY = "SELECT * FROM `orderitem` Where `orderItemId`=?";
	static final String SELECT_BY_HISTORYID_QUERY = "SELECT * FROM `orderitem` Where `historyId`=?";
	static final String SELECT_ALL_QUERY = "SELECT * FROM `orderitem`";
	static final String UPDATE_QUERY = "UDATE `orderitem` SET `menuId`=?,`name`=?,`quantity`=? ,`price`=? `restaurantId_fk`=? ,`userId_fk`=?WHERE `orderItemId`=? ";
	static final String DELETE_QUERY = "DELETE FROM `orderitem` WHERE `orderItemId`=?";
	
	private Connection connection;
	
	public OrderItemDaoI() {
		String url="jdbc:mysql://localhost:3306/tapfoods";
		String username="root";
		String password="123456";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	@Override
	public void addOrderItem(Orderitem orderitem) {
		try {
			PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);

			
		//	statement.setInt(1, orderitem.getUserId());
			statement.setInt(1, orderitem.getMenuId());
			statement.setString(2, orderitem.getName());
			statement.setInt(3, orderitem.getQuantity());
			statement.setFloat(4, orderitem.getPrice());
			statement.setInt(5, orderitem.getRestaurantId());
			statement.setInt(6, orderitem.getUserId());
			statement.setInt(7, orderitem.getHistoryId());
			
		/*	int update = */  statement.executeUpdate();
//			System.out.println(update);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		
	}

	@Override
	public Orderitem getOrderItem(int orderItemId) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Orderitem o1 = null;
		try {
			//
			statement = connection.prepareStatement(SELECT_QUERY);

			statement.setInt(1, orderItemId);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				
				int menuId=resultSet.getInt(2);
				String name=resultSet.getString(3);
				int quantity=resultSet.getInt(4);
				float price=resultSet.getFloat(5);
				int restaurantId=resultSet.getInt(6);
				int userId=resultSet.getInt(7);
				
				
				o1 = new Orderitem(orderItemId, menuId, name, quantity,  price,restaurantId,userId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return o1;
	}

	@Override
	public List<Orderitem> getAll() {
		ArrayList<Orderitem> list = new ArrayList<Orderitem>();
		Statement  statement = null;
		ResultSet resultSet = null;
		Orderitem o2 = null;
		try {
			//
			statement = connection.createStatement();

			
			resultSet = statement.executeQuery(SELECT_ALL_QUERY);

			if (resultSet.next()) {
				int orderItemId=resultSet.getInt(1);
				int menuId=resultSet.getInt(2);
				String name=resultSet.getString(3);
				int quantity=resultSet.getInt(4);
				float price=resultSet.getFloat(5);
				int restaurantId=resultSet.getInt(6);
				int userId=resultSet.getInt(7);
				o2 = new Orderitem(orderItemId, menuId, name, quantity,price,restaurantId,userId);
				list.add(o2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void updateOrderItem(Orderitem orderitem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderItem(int orderItemId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Orderitem> getOrderItemByHistoryId(int historyId) {
		ArrayList<Orderitem> list = new ArrayList<Orderitem>();
		PreparedStatement  statement = null;
		ResultSet resultSet = null;
		Orderitem o2 = null;
		try {
			//
			statement = connection.prepareStatement(SELECT_BY_HISTORYID_QUERY);

			statement.setInt(1, historyId);
			resultSet = statement.executeQuery();

			while(resultSet.next()) {
				int orderItemId=resultSet.getInt(1);
				int menuId=resultSet.getInt(2);
				String name=resultSet.getString(3);
				int quantity=resultSet.getInt(4);
				float price=resultSet.getFloat(5);
				int restaurantId=resultSet.getInt(6);
				int userId=resultSet.getInt(7);
				o2 = new Orderitem(orderItemId, menuId, name, quantity,price,restaurantId,userId);
				list.add(o2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
