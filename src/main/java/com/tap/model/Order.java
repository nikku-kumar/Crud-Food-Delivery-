package com.tap.model;

public class Order {
	private String orderId;
	private int orestaurantId;
	private int ouserId;
	private float totalAmount;
	private String modeOfPayment;
	private String status;
	private int historyId;
	
	
	public Order() {}


	public Order(String orderId, int orestaurantId, int ouserId, float totalAmount, String modeOfPayment, String status,int historyId) {
		super();
		this.orderId = orderId;
		this.orestaurantId = orestaurantId;
		this.ouserId = ouserId;
		this.totalAmount = totalAmount;
		this.modeOfPayment = modeOfPayment;
		this.status = status;
		this.historyId=historyId;
	}


	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public int getOrestaurantId() {
		return orestaurantId;
	}


	public void setOrestaurantId(int orestaurantId) {
		this.orestaurantId = orestaurantId;
	}


	public int getOuserId() {
		return ouserId;
	}


	public void setOuserId(int ouserId) {
		this.ouserId = ouserId;
	}


	public float getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getModeOfPayment() {
		return modeOfPayment;
	}


	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getHistoryId() {
		return historyId;
	}


	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}
	
}
