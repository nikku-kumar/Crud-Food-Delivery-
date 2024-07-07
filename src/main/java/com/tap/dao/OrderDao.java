package com.tap.dao;

import java.util.List;
import com.tap.model.Order;
import com.tap.model.User;

public interface OrderDao {
  void addOrder(Order order);
  List<Order> getOrder(int ouserId);
  List<Order> getAll();
  void updateUser(Order order);
  void deleteUser(String orderId);
  
  
}
