package com.tap.daoimpl;

import java.util.List;

import com.tap.model.CartCreator;
import com.tap.model.Menu;
import com.tap.model.Restaurant;
import com.tap.model.User;

public class Demo {

	public static void main(String[] args) {
//		Menu m = new Menu();
//		MenuDaoI daoI = new MenuDaoI();
//		     // List<Menu> all = daoI.getAll();
//		      List<Menu> all = daoI.getByRestaurantId(1);
//		      
//		      for (Menu menu : all) {
//				System.out.println(menu.getName());
//			}
		CartCreator cart = new CartCreator();
		cart.getAll();
    
	}

}
