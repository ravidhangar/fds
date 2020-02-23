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
import com.jdbc.CategoryTableobj;
import com.util.User;

/**
 * Servlet implementation class AddFoodServlet
 */
public class AddFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String foodName=null;
	int categoryid=0;
	int rate=0;
	int stock=0;
	String description=null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession httpSession=request.getSession();
		
		User user=(User) httpSession.getAttribute("admin");
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsps/addFood.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		foodName=request.getParameter("txtfoodname");
		categoryid=Integer.parseInt(request.getParameter("ddcategory"));
		rate=Integer.parseInt(request.getParameter("numrate"));
		stock=Integer.parseInt(request.getParameter("numstock"));
		description=request.getParameter("txtdescription");
		
		AdminDAO adminDAO=new AdminDAO();
		adminDAO.insertDataInFood(foodName,categoryid,rate,stock,description);
		
		PrintWriter out=response.getWriter();
		out.print("Food item insrted !!");
		RequestDispatcher rd = request.getRequestDispatcher("/jsps/adminHomePage.jsp");
		rd.include(request, response);
	}

}
