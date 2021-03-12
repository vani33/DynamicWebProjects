package com.hcl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/MyServlet")
public class idFilter implements Filter {

    
    public idFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("In ID filter");
		PrintWriter out = response.getWriter();
		
		HttpServletRequest req = (HttpServletRequest) request;
		int id = Integer.parseInt(req.getParameter("id"));
		
		if (id >= 1) {
			chain.doFilter(request, response);
		}
		else {
			out.println("Invalid id entered");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
