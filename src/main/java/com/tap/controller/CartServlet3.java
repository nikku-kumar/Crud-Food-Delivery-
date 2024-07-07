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
@WebServlet("/CallServletCart3")
public class CartServlet3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int menuId = Integer.parseInt(req.getParameter("menuId"));
		Cart cart = new Cart();
		CartCreator creator = new CartCreator();
		creator.deleteCartItem(menuId);
		   HttpSession session = req.getSession();
		 session.setAttribute("cartCreator", creator);
		 resp.sendRedirect("cart.jsp"); 
		
	}

}
