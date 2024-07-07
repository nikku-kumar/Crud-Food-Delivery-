package com.tap.daoimpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tap.dao.RestaurantDao;
import com.tap.model.Restaurant;

public class RestaurantDaoI implements RestaurantDao {
	
	static final String INSERT_QUERY = "INSERT INTO `restaurant`(`name`,`imagePath`,`ratings`,`eta`,`cuisineType`,`address`,`isActive`,`restaurantOwnerId`) values(?,?,?,?,?,?,?,?)";
	static final String SELECT_QUERY = "SELECT * FROM `restaurant` Where `restaurantId`=?";
	static final String SELECT_ALL_QUERY = "SELECT * FROM `restaurant`";
	static final String UPDATE_QUERY = "UDATE `restaurant` SET `name`=? ,`imagePath`=? ,`ratings`=?,`eta`=?, `cuisineType`=?,`address`=?, `isActive`=?,`restaurantOwnerId`=? WHERE `restaurantId`=? ";
	static final String DELETE_QUERY = "DELETE FROM `restaurant` WHERE `restaurantId`=?";
	private Connection connection;
	public RestaurantDaoI() {
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
	public void addRestaurant(Restaurant restaurant) {
		try {
			PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
			statement.setString(1, restaurant.getName());
			statement.setString(2, restaurant.getImagePath());
			statement.setFloat(3, restaurant.getRatings());
			statement.setString(4, restaurant.getEta());
			statement.setString(5, restaurant.getCuisinType());
			statement.setString(6, restaurant.getAddress());
			statement.setBoolean(7, restaurant.getIsActive());
			statement.setInt(8, restaurant.getRestaurantId());
			int update = statement.executeUpdate();
			System.out.println(update);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Restaurant getRestaurant(int restaurantId) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Restaurant r1 = null;
		try {
			statement = connection.prepareStatement(SELECT_QUERY);

			statement.setInt(1, restaurantId);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String name = resultSet.getString(2);
				String imagePath = resultSet.getString(3);
				 
				int ratings = resultSet.getInt(4);
				String eta = resultSet.getString(5);
				String cuisineType = resultSet.getString(6);
				String address = resultSet.getString(7);
				Boolean isActive=resultSet.getBoolean(8);
				int  restaurantOwnerId= resultSet.getInt(9);
			     r1 = new Restaurant(restaurantId, name, imagePath, ratings, eta, cuisineType, address, isActive, restaurantOwnerId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r1;
	}
	@Override
	public List<Restaurant> getAll() {
		Statement createStatement = null;
		ResultSet resultSet = null;
		Restaurant r2 = null;
		ArrayList<Restaurant> list = new ArrayList<Restaurant>();
		
		try {
			createStatement = connection.createStatement();
			resultSet = createStatement.executeQuery(SELECT_ALL_QUERY);

			while (resultSet.next()) {
				int restaurantId=resultSet.getInt(1);
				String name = resultSet.getString(2);
				String imagePath = resultSet.getString(3);
				int ratings = resultSet.getInt(4);
				String eta = resultSet.getString(5);
				String cuisineType = resultSet.getString(6);
				String address = resultSet.getString(7);
				Boolean isActive=resultSet.getBoolean(8);
				int  restaurantOwnerId= resultSet.getInt(9);
			     r2 = new Restaurant(restaurantId, name, imagePath, ratings, eta, cuisineType, address, isActive, restaurantOwnerId);
				list.add(r2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public void updateRestaurant(Restaurant restaurant) {
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(UPDATE_QUERY);
			statement.setString(1, restaurant.getName());
			statement.setString(2, restaurant.getImagePath());
			statement.setFloat(3, restaurant.getRatings());
			statement.setString(4, restaurant.getEta());
			statement.setString(5, restaurant.getCuisinType());
			statement.setString(6, restaurant.getAddress());
			statement.setBoolean(7, restaurant.getIsActive());
			statement.setInt(8, restaurant.getRestaurantOwnerId());
			statement.setInt(9, restaurant.getRestaurantId());
			
			statement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	@Override
	public void deleteRestaurant(int restaurantId) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);
			prepareStatement.setInt(1, restaurantId);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	

}
