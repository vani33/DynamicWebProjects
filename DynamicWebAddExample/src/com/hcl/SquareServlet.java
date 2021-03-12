package com.hcl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//We can use @WebServlet annotation instead of using web.xml file
@WebServlet("/square")
public class SquareServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

		// int k = (int) req.getAttribute("k");
		// k = k * k;

		/*
		 * int k = Integer.parseInt(req.getParameter("k")); k = k * k;
		 */

		/*
		 * HttpSession session = req.getSession(); int k = (int)
		 * session.getAttribute("k"); k = k * k;
		 */

		int k = 0;
		Cookie cookies[] = req.getCookies();

		for (Cookie c : cookies) {
			if (c.getName().equals("k")) {
				k = Integer.parseInt(c.getValue());
			}
		}

		k = k * k ;
		PrintWriter out = res.getWriter();
		out.println("Square of two numbers is " + k);

	}
}
