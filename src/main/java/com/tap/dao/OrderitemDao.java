package com.tap.dao;

import java.util.List;

import com.tap.model.Order;
import com.tap.model.Orderitem;

public interface OrderitemDao {
	void addOrderItem(Orderitem orderitem);
	Orderitem getOrderItem(int orderItemId);
	List<Orderitem> getAll();
	List<Orderitem> getOrderItemByHistoryId(int historyId );
    void updateOrderItem(Orderitem orderitem);
    void deleteOrderItem(int orderItemId);
}
