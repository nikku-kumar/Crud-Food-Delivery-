package com.tap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.daoimpl.MenuDaoI;
import com.tap.model.Menu;
@WebServlet("/menuallservlet")
public class MenuAllServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MenuDaoI m  = new MenuDaoI();
		List<Menu> menu = m.getAll();
		req.setAttribute("menulist", menu);
		RequestDispatcher rd = req.getRequestDispatcher("menuAll.jsp");
		rd.forward(req,resp);
	}

}
