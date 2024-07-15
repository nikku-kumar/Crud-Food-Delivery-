package com.tap.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoI.UserDaoI;
import com.tap.model.User;

@WebServlet("/RetrieveServletAll")
public class RetrieveServletAll extends HttpServlet{
	private static final long serialVersionUID = 1L;
	UserDaoI userDao =null;
	
	public RetrieveServletAll() {
		this.userDao = new UserDaoI();
	}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 List<User> user = userDao.getAllStudent();
		 

		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 
		 out.println("<html><body>");
	     out.println("<h1>All Students</h1>");
	     
	     for (User ur : user) {
	            out.print("<p>ID: " + ur.getId() + "</p>");
	            out.print("<p>Name: " + ur.getName() + "</p>");
	            out.print("<p>Email: " + ur.getEmail() + "</p>");
	            out.print("<p>Age: " + ur.getAge()+ "</p>");
	            out.print("<hr>"); // Optional: Separating each user's details
	        }
	     
	     out.println("</body></html>");
	     out.close();
	 }
	 
}
