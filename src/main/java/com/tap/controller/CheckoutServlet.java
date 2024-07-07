package com.tap.controller;

import java.util.concurrent.ThreadLocalRandom;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.OrderItemDaoI;
import com.tap.model.Cart;
import com.tap.model.CartCreator;
import com.tap.model.Orderitem;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	// private static int historyId=1;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		int historyId = ThreadLocalRandom.current().ints().distinct().limit(1).findFirst().orElse(0);
		if (session.getAttribute("userId") == null) {
			out.print("Please login first");
			return;
		} else {
			int userId = (int) session.getAttribute("userId");
			CartCreator cartCreator = (CartCreator) session.getAttribute("cartCreator");

			for (Cart item : cartCreator.getAll().values()) {
				int menuId = item.getMenuId();
				String name = item.getName();
				int quantity = item.getQuantity();
				float price = item.getPrice();
				int restaurantId = item.getRestaurantId();

				Orderitem orderitem = new Orderitem(menuId, name, quantity, price, restaurantId, userId, historyId);
				OrderItemDaoI daoI = new OrderItemDaoI();
				daoI.addOrderItem(orderitem);

			}

			session.setAttribute("cartCreator", cartCreator);
			int restaurantId = (int) session.getAttribute("restaurantId");
			session.setAttribute("restaurantId", restaurantId);
			session.setAttribute("historyId", historyId);
			// historyId ++;

			resp.sendRedirect("checkOut.jsp");
		}

	}

}
