package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.User;

/**
 * Servlet implementation class AdminHomePageServlet
 */
public class AdminHomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminHomePageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String btn = request.getParameter("action");
		

		HttpSession httpSession = request.getSession();
		User user = (User) httpSession.getAttribute("admin");
		request.setAttribute("admin", user);
		

		RequestDispatcher rd = null;

		if (btn.equals("Add category")) {
			//out.print("Add category");
			//rd = request.getRequestDispatcher("/addcategory.com");
			//rd.forward(request, response);
			response.sendRedirect("/FoodDeliverySystem/addcategory.com");
		} else if (btn.equals("Delete category")) {
			response.sendRedirect("/FoodDeliverySystem/deletecategory.com");
		} else if (btn.equals("Add food")) {
			response.sendRedirect("/FoodDeliverySystem/addfood.com");
		} else if (btn.equals("Delete food")) {
			response.sendRedirect("/FoodDeliverySystem/deletefood.com");
		} else if (btn.equals("Modify food")) {
			response.sendRedirect("/FoodDeliverySystem/modifyfood.com");
		}else if (btn.equals("logout")) {
			rd = request.getRequestDispatcher("/logout.com");
			rd.forward(request, response);
		}
	}

}
