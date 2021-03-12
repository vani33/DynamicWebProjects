package com.hcl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hcl.Dao.EmployeeDao;
import com.hcl.model.Employee;

@WebServlet("/EmployeeLoginServlet")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		Employee employee = new Employee();
		employee.setUserName(userName);
		employee.setPassword(password);

		EmployeeDao employeeDao = new EmployeeDao();
		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		if (employeeDao.validate(employee)) {
			response.sendRedirect("loginSuccess.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
