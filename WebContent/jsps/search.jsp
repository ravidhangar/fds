<%@page import="java.util.Iterator"%>
<%@page import="com.jdbc.FoodTableObj"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jdbc.AdminDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
	<%
	HttpSession httpSession=request.getSession();
	String search=(String) httpSession.getAttribute("search");
	//response.getWriter().print(search);
	AdminDAO adminDAO=new AdminDAO();
	ArrayList<FoodTableObj> foods=new ArrayList<FoodTableObj> ();
	foods.addAll(adminDAO.fetchDataFromFood());
	Iterator<FoodTableObj> itr=foods.iterator();
	while(itr.hasNext()){
		FoodTableObj temp=itr.next();
		if(temp.getFoodname().equalsIgnoreCase(search)){
	%>
	<div>name:<%=temp.getFoodname() %><br/> 
	Rate:<%=temp.getRate()%><br/>
	Description:<%= temp.getDescription()%>
	</div>
	<%} }%>
	
</body>
</html>