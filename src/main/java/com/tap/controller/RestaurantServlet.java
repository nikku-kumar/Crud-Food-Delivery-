package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.RestaurantDaoI;
import com.tap.daoimpl.UserDaoI;
import com.tap.model.Restaurant;
import com.tap.model.User;
@WebServlet("/CallingServlet")
public class RestaurantServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	RestaurantDaoI r1 = new RestaurantDaoI();
		List<Restaurant> l1=r1.getAll();
		 req.setAttribute("restaurantList", l1);
	    RequestDispatcher rd = req.getRequestDispatcher("Restaurant.jsp");
	    rd.include(req, resp);
	
	}

}
