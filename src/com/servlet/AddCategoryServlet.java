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
import com.util.User;

/**
 * Servlet implementation class AddCategoryServlet
 */
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession();
		User user=(User) httpSession.getAttribute("admin");
		
		PrintWriter out =response.getWriter();
		out.print(user.getEmail());
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsps/addCategory.jsp");
		rd.include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession();
		User user=(User) httpSession.getAttribute("admin");
		
		PrintWriter out =response.getWriter();
	
		
		String category=request.getParameter("txtcategory");
		
		AdminDAO adminDAO=new AdminDAO();
		adminDAO.insertCategory(category);
		
		out.print("Category Added");
		RequestDispatcher rd=request.getRequestDispatcher("/jsps/adminHomePage.jsp");
		rd.include(request, response);
	}

}
