package com.hcl.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.hcl.Dao.UserDao;
import com.hcl.model.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;

	public LoginServlet() {
		super();
		this.userDao = userDao;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String action = request.getServletPath();

		switch (action) {
		case "/new":
			showLoginForm(request, response);
			break;
		case "/insert":
			insertUser(request, response);
			break;
		case "/fetch":
			fetchUser(request, response);
			break;
		case "/update":
			UpdateUser(request, response);
			break;
		case "/delete":
			deleteUser(request, response);
			break;
		default:
			break;
		}
		
	

	}
	
	
	private void validateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		User user = new User();
		if(name.equals(user.getId())) {
			response.sendRedirect("welcome.jsp");
		}
		else {
			response.sendRedirect("error.jsp");
		}
	}

	private void showLoginForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);

	}

	private User insertUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		User user = new User(id, name, email, city);
		userDao.insertUser(user);
		return user;

	}

	private List<User> fetchUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<User> users = userDao.fetchUser();
		return users;
	}

	private User UpdateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		User user = new User(id, name, email, city);
		userDao.updateUser(user);
		return user;

	}

	private int deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int delId = userDao.deleteUser(id);
		return delId;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
