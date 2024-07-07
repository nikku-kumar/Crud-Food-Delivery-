package com.tap.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.OrderDaoI;
import com.tap.model.Order;
@WebServlet("/confirmservlet")
public class ConfirmServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 LocalDateTime now = LocalDateTime.now();
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	        String orderId = now.format(formatter);
	        HttpSession session = req.getSession();
	        int orestaurantId=(int)session.getAttribute("restaurantId");
	        int ouserId=(int)session.getAttribute("userId");
	        float totalAmount=(float)session.getAttribute("total");
	        String payment_method=req.getParameter("payment_method");
	        String status="confirmed";
	        String name=req.getParameter("name");
	        String address=req.getParameter("address");
	        String state=req.getParameter("state");
	        String city=req.getParameter("city");
	        int zipcode=Integer.parseInt(req.getParameter("zipcode"));
	        int historyId=(int)session.getAttribute("historyId");
	      //  System.out.println(orderId +" "+ orestaurantId+","+ouserId+ totalAmount+ payment_method+ status);
	        
	        
	        Order order = new Order(orderId, orestaurantId, ouserId, totalAmount, payment_method, status,historyId);
         OrderDaoI daoI = new OrderDaoI();
         daoI.addOrder(order);
         session.setAttribute("orderId", orderId);
         session.setAttribute("name", name);
         session.setAttribute("address", address);
         session.setAttribute("state", state);
         session.setAttribute("city", city);
         session.setAttribute("zipcode", zipcode);
         session.setAttribute("status", status);
         session.setAttribute("payment_method", payment_method);
         resp.sendRedirect("Confirm.jsp");
	}

}
