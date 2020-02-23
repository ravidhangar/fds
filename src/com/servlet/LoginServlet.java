package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.AdminDAO;
import com.jdbc.UserDAO;
import com.util.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
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
		RequestDispatcher rd = null;

		PrintWriter out = response.getWriter();
		User user = (User) request.getAttribute("user");
		request.removeAttribute("user");
		// out.print(user.getEmail()+" "+user.getPassword()+" "+user.getUserType());

		if (user.getUserType().equals("admin")) {

			AdminDAO adminDAO = new AdminDAO();
			boolean result = adminDAO.checkAdmin(user);

			if (result == true) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("admin", user);
				rd = request.getRequestDispatcher("/jsps/adminHomePage.jsp");
				rd.forward(request, response);
			} else {
				out.print("invalid admin login");
				rd = request.getRequestDispatcher("/jsps/login.jsp");
				rd.include(request, response);
			}
		} else {
			UserDAO userDao = new UserDAO();
			boolean result = userDao.checkUser(user);

			if (result == true) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("customer", user);
				response.sendRedirect("/FoodDeliverySystem/user.com");
				//rd = request.getRequestDispatcher("/user.com");
				//rd.forward(request, response);
			} else {
				out.print("invalid customer login");
				rd = request.getRequestDispatcher("/jsps/login.jsp");
				rd.include(request, response);
			}
		}

	}

}
