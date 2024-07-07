package com.tap.model;

public class Restaurant {

   private int restaurantId;
   private String name;
   private String imagePath;
   private float ratings;
   private String eta;
   private String cuisinType;
   private String address;
   private boolean isActive;
   private int restaurantOwnerId;
   
   public Restaurant() {}

public Restaurant(int restaurantId, String name, String imagePath, float ratings, String eta, String cuisinType,
		String address, boolean isActive, int restaurantOwnerId) {
	super();
	this.restaurantId = restaurantId;
	this.name = name;
	this.imagePath = imagePath;
	this.ratings = ratings;
	this.eta = eta;
	this.cuisinType = cuisinType;
	this.address = address;
	this.isActive = isActive;
	this.restaurantOwnerId = restaurantOwnerId;
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

public String getImagePath() {
	return imagePath;
}

public void setImagePath(String imagePath) {
	this.imagePath = imagePath;
}

public float getRatings() {
	return ratings;
}

public void setRatings(float ratings) {
	this.ratings = ratings;
}

public String getEta() {
	return eta;
}

public void setEta(String eta) {
	this.eta = eta;
}

public String getCuisinType() {
	return cuisinType;
}

public void setCuisinType(String cuisinType) {
	this.cuisinType = cuisinType;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public boolean getIsActive() {
	return isActive;
}

public void setActive(boolean isActive) {
	this.isActive = isActive;
}

public int getRestaurantOwnerId() {
	return restaurantOwnerId;
}

public void setRestaurantOwnerId(int restaurantOwnerId) {
	this.restaurantOwnerId = restaurantOwnerId;
}
   
}
