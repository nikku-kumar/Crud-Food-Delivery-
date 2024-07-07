package com.tap.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CartCreator {
	static Map<Integer,Cart> cart=new HashMap<>();
public CartCreator() {
	
}

  public void addCartItem(Cart ci) {
	if(cart.containsKey(ci.getMenuId())) {
		int n3=cart.get(ci.getMenuId()).getQuantity()+ci.getQuantity();
		if(n3>0) {
		cart.get(ci.getMenuId()).setQuantity(n3);
		  }
//		cart.put(ci.getMenuId(), ci);
	}else {
		cart.put(ci.getMenuId(),ci);
	}
}
  public void updateCartItem(int menuId, int quantity) {
	  cart.get(menuId).setQuantity(quantity);
  }
   public void deleteCartItem(int menuId) {
	  cart.remove(menuId);
  }
   public  Map<Integer,Cart> getAll(){

    	return cart;
    }


}
