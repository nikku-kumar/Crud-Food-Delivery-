package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.MenuDao;
import com.tap.model.Menu;

public class MenuDaoI implements MenuDao {
	
	static final String INSERT_QUERY="INSERT INTO  `menu`(`name`,`price`,`description`,`imagePath`,`isAvailable`,`ratings`)VALUES(?,?,?,?,?,?) ";
	static final String SELECT_QUERY = "SELECT * FROM `menu` Where `menuId`=?";
	static final String SELECT_QUERY_BY_RESTAURANTID = "SELECT * FROM `menu` Where `restaurantId`=?";
	static final String SELECT_QUERY_BY_NAME = "SELECT * FROM `menu` Where `name` like?";
	static final String SELECT_ALL_QUERY = "SELECT * FROM `menu`";
	static final String UPDATE_QUERY = "UDATE `menu` SET `name`=? ,`price`=?,`description`=?,`imagePath`=?,`isAvailable`=?,`restaurantId`=? ,`ratings`=? WHERE `menuId`=? ";
	static final String DELETE_QUERY = "DELETE FROM `menu` WHERE `menuId`=?";
	private Connection connection;
	
	public MenuDaoI() {
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
	public void addMenu(Menu menu) {
		PreparedStatement statement=null;
		try {
			statement = connection.prepareStatement(INSERT_QUERY);
			statement.setString(1,menu.getName());
			statement.setFloat(2,menu.getPrice());
			statement.setString(3,menu.getDescription());
			statement.setString(4,menu.getImagePath());
			statement.setBoolean(5,menu.isAvailable());
//			statement.setInt(6,menu.getRestaurantId());
			statement.setFloat(6,menu.getRatings());
			int update = statement.executeUpdate();
			System.out.println(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Menu getMenu(int menuId) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Menu m1 = null;
		try {
			statement = connection.prepareStatement(SELECT_QUERY);

			statement.setInt(1, menuId);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String name = resultSet.getString(2);
				float price=resultSet.getFloat(3);
				String description = resultSet.getString(4);
				String imagePath = resultSet.getString(5);
				Boolean  isAvailable=resultSet.getBoolean(6);
				int  restaurantId= resultSet.getInt(7);
			    float ratings = resultSet.getFloat(8);
				
			     m1 = new Menu(menuId, name, price, description, imagePath, isAvailable, restaurantId, ratings);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m1;
	}

	@Override
	public List<Menu> getAll() {
		Statement statement = null;
		ResultSet resultSet = null;
		Menu m2 = null;
		ArrayList<Menu> list = new ArrayList<Menu>();
		
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_ALL_QUERY);

			while (resultSet.next()) {
				int menuId=resultSet.getInt(1);
				String name = resultSet.getString(2);
				float price=resultSet.getFloat(3);
				String description = resultSet.getString(4);
				String imagePath = resultSet.getString(5);
				Boolean  isAvailable=resultSet.getBoolean(6);
				int  restaurantId= resultSet.getInt(7);
			    float ratings = resultSet.getFloat(8);
				
			     m2 = new Menu(menuId, name, price, description, imagePath, isAvailable, restaurantId, ratings);
			     list.add(m2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void updateMenu(Menu menu) {
		PreparedStatement statement = null;
        try {
			statement = connection.prepareStatement(UPDATE_QUERY);
			statement.setString(1, menu.getName());
			statement.setFloat(2, menu.getPrice());
			statement.setString(3, menu.getDescription());
			statement.setString(4, menu.getImagePath());
			statement.setBoolean(5, menu.isAvailable());
			statement.setInt(6, menu.getRestaurantId());
			statement.setFloat(7, menu.getRatings());
			statement.setInt(8, menu.getMenuId());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	 
	@Override
	public void deleteMenu(int menuId) {
		PreparedStatement statement=null;
		
		try {
			statement = connection.prepareStatement(DELETE_QUERY);
			statement.setInt(1, menuId);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Menu> getByRestaurantId(int restaurantId) {
		ArrayList<Menu> list = new ArrayList<Menu>();
		
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Menu m = null;
		try {
			statement = connection.prepareStatement(SELECT_QUERY_BY_RESTAURANTID);

			statement.setInt(1, restaurantId);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int menuId=resultSet.getInt(1);
				String name = resultSet.getString(2);
				float price=resultSet.getFloat(3);
				String description = resultSet.getString(4);
				String imagePath = resultSet.getString(5);
				Boolean  isAvailable=resultSet.getBoolean(6);
				
			    float ratings = resultSet.getFloat(8);
				
			     m = new Menu(menuId, name, price, description, imagePath, isAvailable, restaurantId, ratings);
			     list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Menu> getByName(String s) {
		ArrayList<Menu> list = new ArrayList<Menu>();

		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Menu m = null;
		try {
			statement = connection.prepareStatement(SELECT_QUERY_BY_NAME);
              s="%"+s+ "%";
			statement.setString(1, s);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int menuId = resultSet.getInt(1);
				String name = resultSet.getString(2);
				float price = resultSet.getFloat(3);
				String description = resultSet.getString(4);
				String imagePath = resultSet.getString(5);
				Boolean isAvailable = resultSet.getBoolean(6);
				int restaurantId = resultSet.getInt(7);

				float ratings = resultSet.getFloat(8);

				m = new Menu(menuId, name, price, description, imagePath, isAvailable, restaurantId, ratings);
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
