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
import com.tap.model.Restaurant;

@WebServlet("/CallingServlet2")
public class RestaurantServlet2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDaoI r1 = new RestaurantDaoI();
		List<Restaurant> l1=r1.getAll();
		HttpSession session = req.getSession();
		String  name = (String)session.getAttribute("name");
		int userId = (int)session.getAttribute("userId");
		 req.setAttribute("restaurantList", l1);
		 req.setAttribute("name", name);
		 req.setAttribute("userId", userId);
	    RequestDispatcher rd = req.getRequestDispatcher("Restaurant2.jsp");
	    rd.include(req, resp);
	}

}
