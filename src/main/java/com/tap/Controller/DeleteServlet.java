package com.tap.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoI.UserDaoI;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	UserDaoI userDao =null;
	
	public DeleteServlet() {
		this.userDao = new UserDaoI();
	}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 int id =Integer.parseInt(request.getParameter("id"));
		 userDao.deleteStudent(id);
		 
		    response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<html><body><h1> Information Deleted </h1></body></html>");
	        out.close();
	 }

}
