package com.tap.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoI.UserDaoI;
import com.tap.model.User;

@WebServlet("/RetrieveServletOne")
public class RetrieveServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoI userDao =null;
	public RetrieveServletOne() {
		this.userDao = new UserDaoI();
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 int id =Integer.parseInt(request.getParameter("id"));
		 User user =userDao.getStudent(id);
		 
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 
		 if (user != null) {
	            out.println("<html><body>");
	            out.println("<h1>Student Details</h1>");
	            out.println("<p>ID: " +user.getId() + "</p>");
	            out.println("<p>Name: " + user.getName()+ "</p>");
	            out.println("<p>Email: " + user.getEmail() + "</p>");
	            out.println("<p>Age: " + user.getAge() + "</p>");
	            out.println("</body></html>");
	        } else {
	            out.println("<html><body>");
	            out.println("<h1>No student found with ID: " + id + "</h1>");
	            out.println("</body></html>");
	        }
	        
		 
		 out.close();
	 }

}
