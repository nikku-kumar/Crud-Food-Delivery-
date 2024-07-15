package com.tap.dao;

import java.util.List;

import com.tap.model.Menu;


public interface MenuDao {
	void addMenu(Menu menu);
	Menu getMenu(int menuId);

	List<Menu> getAll();

	void updateMenu(Menu menu);

	void deleteMenu(int menuId);
	
	List<Menu> getByRestaurantId(int restaurantId);
	List<Menu> getByName(String name);
}
//hi