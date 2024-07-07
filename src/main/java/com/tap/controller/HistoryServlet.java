package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.OrderDaoI;
import com.tap.daoimpl.OrderItemDaoI;
import com.tap.model.Order;
@WebServlet("/callservlethistory")
public class HistoryServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	OrderDaoI daoI = new OrderDaoI();
    	HttpSession session = req.getSession();
    	int userId=(int)session.getAttribute("userId");
    	 List<Order> order2 = daoI.getOrder(userId);
//    	 for (Order order : order2) {
//			
//    		 System.out.println(order.getOrderId()+" "+order.getOrestaurantId()+" "+order.getOuserId()+" "+order.getTotalAmount()+" "+order.getModeOfPayment()+" "+order.getStatus());
//		}
    	session.setAttribute("order2", order2);
    	resp.sendRedirect("history.jsp");
    }
}
