package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimpl.UserDaoI;
@WebServlet("/Callingvalidservlet1")
public class Validservlet1 extends HttpServlet {
	static int count=3;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
	    //out.print(password);
		UserDaoI daoI = new UserDaoI();
		String pass=daoI.getPassword(username);
		String name=daoI.getName(username);
		int userId=daoI.getUserId(username);
		HttpSession session = req.getSession();
		session.setAttribute("name", name);
		session.setAttribute("userId", userId);
		
		//out.print(pass);
		if(password.equals(pass)) {
			//out.print("rightpassword");
			resp.sendRedirect("CallingServlet2");
		}else if(count>0){
			  req.setAttribute("count", count);
			  count--;
			RequestDispatcher rd = req.getRequestDispatcher("invalidLogin.jsp");
			rd.forward(req, resp);
			}
		else {
			out.print("you crossed the limit of wrong user");
		}
		
		
	}

}
