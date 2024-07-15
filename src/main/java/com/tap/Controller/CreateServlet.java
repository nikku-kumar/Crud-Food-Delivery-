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

@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoI userDao = null;
    public CreateServlet() {
        this.userDao = new UserDaoI();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));

        // Create User object
        User user = new User(name, email, age);

        // Add user to database
        userDao.AddStudent(user);

        // Respond to client
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Information successfully submitted to the database!</h1></body></html>");
        out.close();
    }
}
