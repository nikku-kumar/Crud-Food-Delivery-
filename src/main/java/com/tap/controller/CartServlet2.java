package com.tap.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.Cart;
import com.tap.model.CartCreator;
@WebServlet("/CallServletCart2")
public class CartServlet2 extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String imagepath=req.getParameter("imagepath");
		float price=Float.parseFloat(req.getParameter("price"));
		int menuId = Integer.parseInt(req.getParameter("menuId")); 
		int restaurantId= Integer.parseInt(req.getParameter("restaurantId"));  
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		Cart c = new Cart(menuId, imagepath, restaurantId, name, price, quantity);
		CartCreator creator = new CartCreator();
		creator.addCartItem(c);
		   HttpSession session = req.getSession();
		 session.setAttribute("cartCreator", creator);
		 resp.sendRedirect("cart.jsp"); 
		
		
	}

}
