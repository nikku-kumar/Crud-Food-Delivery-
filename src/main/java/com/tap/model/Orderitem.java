package com.tap.model;

public class Orderitem {
	private int orderItemId;
	private int userId;
	private int menuId;
	private String name;
	private int quantity;
	private float  price;
	private int historyId;
	int restaurantId;
	public Orderitem() {
	}
	
	
	public Orderitem(int menuId, String name, int quantity, float price, int restaurantId) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.restaurantId = restaurantId;
	}
	
	public Orderitem(int orderItemId,  int menuId, String name, int quantity, float price,int restaurantId,int userId) {
		super();
		this.orderItemId = orderItemId;
		this.userId = userId;
		this.menuId = menuId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.restaurantId = restaurantId;
	}


	public Orderitem( int menuId, String name, int quantity, float price, int restaurantId,int userId,int historyId) {
		super();
		this.userId = userId;
		this.menuId = menuId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.restaurantId = restaurantId;
		this.historyId=historyId;
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}


	public int getHistoryId() {
		return historyId;
	}


	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	
}
