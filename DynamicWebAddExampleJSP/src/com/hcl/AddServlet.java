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
import javax.xml.ws.Response;

import jdk.nashorn.internal.ir.RuntimeNode.Request;


//We can use @WebServlet annotation instead of using web.xml file
//@WebServlet("/add")
public class AddServlet extends HttpServlet {

	// we can use doGet or doPost instead of service method depending on our
	// requirement.

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		PrintWriter out = res.getWriter();
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));

		int k = i + j;
		
		
		//If we want to use html inside servlets we need to write lot of html code which is tidious
		//so we go for jsp(java server pages) where we can write java code inside html pages.
		
		out.println("<html><body bgcolor ='cyan'>");
		out.println("Result is " + k);
		out.println("</body></html>");
		

		
	}

}
