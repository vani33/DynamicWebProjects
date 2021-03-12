package com.hcl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;


//We can use @WebServlet annotation instead of using web.xml file
@WebServlet("/add")
public class AddServlet extends HttpServlet {

	// we can use doGet or doPost instead of service method depending on our
	// requirement.

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));

		int k = i + j;
		// System.out.println("Result is " + k);

		//PrintWriter out = res.getWriter();

		//out.println("Result is " + k);

		//req.setAttribute("k", k);

		// To call one servlet from another servlet
		// 1.RequestDispatcher 2. Redirect

		/*
		 * RequestDispatcher rd = req.getRequestDispatcher("square");
		 * //rd.forward(req, res); rd.include(req, res);
		 */

		//res.sendRedirect("square?k=" + k); // URL rewriting
		// session, cookies another way of sending data from one servlet to
		// another

		/*HttpSession session = req.getSession();
		session.setAttribute("k", k);

		res.sendRedirect("square");*/
		
		Cookie cookie = new Cookie("k", k + "");
		res.addCookie(cookie);
		res.sendRedirect("square");
	}

}
