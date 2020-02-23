<%@page import="java.util.Iterator"%>
<%@page import="com.jdbc.CategoryTableobj"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jdbc.AdminDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	HttpSession httpSession = request.getSession(false);
	//response.setHeader("Cache-Control", "no-cache,no-store");//HTTP 1.1
	//response.setHeader("Pragma", "no-cache");//HTTP 1.0
	if (httpSession.getAttribute("admin") == null) {
		response.sendRedirect("login.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Category</title>
</head>
<body>
	<%
		AdminDAO adminDAO=new AdminDAO();
		ArrayList<CategoryTableobj> categories=new ArrayList<CategoryTableobj> ();
		categories=adminDAO.fetchDataFromCategoryTable();
		Iterator<CategoryTableobj> itr=categories.iterator();
	%>
	<form action="/FoodDeliverySystem/deletecategory.com" method="post">
		<label for="category"></label>
		<select id="category" name="ddcategory">
			<%while(itr.hasNext()){
				CategoryTableobj temp=itr.next();
				%>
				<option value=<%= temp.getId()%>><%= temp.getCuisine()%></option>
				<%} %>
		</select>
		<input type="submit" value="delete">
	</form>
</body>
</html>