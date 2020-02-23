package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.AdminDAO;
import com.jdbc.UserDAO;
import com.util.User;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupServlet() {
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
		User user = (User) request.getAttribute("user");
		PrintWriter out = response.getWriter();
		if (user.getUserType().equals("admin")) {
			AdminDAO adminDAO = new AdminDAO();
			adminDAO.createAdmin(user);
		} else {
			UserDAO userDAO = new UserDAO();
			userDAO.createCustomer(user);
		}
		request.removeAttribute("user");
		out = response.getWriter();
		out.print("Account Created");
		RequestDispatcher rd=request.getRequestDispatcher("/jsps/login.jsp");
		rd.include(request, response);
	}

}
