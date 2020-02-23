package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AddFoodFilter
 */
public class AddFoodFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AddFoodFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String foodName = request.getParameter("txtfoodname");
		PrintWriter out = response.getWriter();
		if (httpRequest.getMethod().equalsIgnoreCase("POST")) {
			if (foodName.isEmpty()) {
				out.print("name cannot be empty");
				RequestDispatcher rd = request.getRequestDispatcher("/jsps/addFood.jsp");
				rd.include(request, response);
			}else {
				chain.doFilter(request, response);
			}
		}
		// pass the request along the filter chain
		else {
		chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
