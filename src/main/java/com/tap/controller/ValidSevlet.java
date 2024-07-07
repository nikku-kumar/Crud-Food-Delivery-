package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpl.UserDaoI;
import com.tap.model.User;
@WebServlet("/CallingValidServlet")
public class ValidSevlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		int n=0;
		UserDaoI userDaoI = new UserDaoI();
		String username=req.getParameter("username");
		String name=req.getParameter("fullname");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String phone = req.getParameter("phone");
		if (phone != null) {
			phone = phone.trim();
		}
		try {
		    long number = Long.parseLong(phone);
		User user = new User(name, email, number, username, password);
		n= userDaoI.registerUser(user);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		if(n>0) {
			resp.sendRedirect("login.jsp");
		}else {
			out.println("ivalid details");
		}
		
	}

}
