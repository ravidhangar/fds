package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.Id;

/**
 * Servlet implementation class ModifyFoodServlet
 */
public class ModifyFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/jsps/modifyFood.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("ddmodify"));
		
		  Id idObj=new Id(id); 
		  HttpSession httpSession=request.getSession();
		  httpSession.setAttribute("foodid", idObj);
		  response.sendRedirect("/FoodDeliverySystem/modifyselectedfood.com");
		// RequestDispatcher rd=request.getRequestDispatcher("/modifyselectedfood.com");
		 //rd.forward(request, response);
		//response.getWriter().print(id);
	}

}
