package com.tap.model;

public class Cart {
  private int menuId;
  private int restaurantId;
  private String name;
  private String imagePath;
  private float price;
  private int quantity;
  
  public Cart() {}

public Cart(int menuId, String imagePath ,int restaurantId, String name, float price, int quantity) {
	super();
	this.menuId = menuId;
	this.imagePath=imagePath;
	this.restaurantId = restaurantId;
	this.name = name;
	this.price = price;
	this.quantity = quantity;
}

public Cart(int menuId, int restaurantId, String name, float price, int quantity) {
	super();
	this.menuId = menuId;
	this.restaurantId = restaurantId;
	this.name = name;
	this.price = price;
	this.quantity = quantity;
}

public int getMenuId() {
	return menuId;
}

public void setMenuId(int menuId) {
	this.menuId = menuId;
}

public int getRestaurantId() {
	return restaurantId;
}

public void setRestaurantId(int restaurantId) {
	this.restaurantId = restaurantId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public String getImagePath() {
	return imagePath;
}

public void setImagePath(String imagePath) {
	this.imagePath = imagePath;
}

@Override
public String toString() {
	return "Cart [menuId=" + menuId + ", restaurantId=" + restaurantId + ", name=" + name + ", imagePath=" + imagePath
			+ ", price=" + price + ", quantity=" + quantity + "]";
}
  
  
}
