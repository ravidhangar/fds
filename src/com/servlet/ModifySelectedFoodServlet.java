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
import com.jdbc.FoodTableObj;
import com.util.Id;

/**
 * Servlet implementation class ModifySelectedFoodServlet
 */
public class ModifySelectedFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int id=0;
	String foodName=null;
	int categoryid=0;
	int rate=0;
	int stock=0;
	String description=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifySelectedFoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/jsps/modifySelected.jsp");
		rd.forward(request, response);
		//HttpSession httpSession=request.getSession();
		//Id id=(Id)httpSession.getAttribute("foodid");
		//response.getWriter().print(id.getId());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession();
		Id idobj=(Id)httpSession.getAttribute("foodid");
		id=idobj.getId();
		foodName=request.getParameter("txtname");
		categoryid=Integer.parseInt(request.getParameter("ddcategory"));
		rate=Integer.parseInt(request.getParameter("numrate"));
		stock=Integer.parseInt(request.getParameter("numstock"));
		description=request.getParameter("txtdescription");
		
		FoodTableObj obj=new FoodTableObj(id, foodName, categoryid, rate, stock, description);
		
		AdminDAO adminDAO=new AdminDAO();
		adminDAO.modifyFood(obj);
		
		PrintWriter out=response.getWriter();
		out.print("Food item inserted !!");
		RequestDispatcher rd = request.getRequestDispatcher("/jsps/adminHomePage.jsp");
		rd.include(request, response);
	}

}
