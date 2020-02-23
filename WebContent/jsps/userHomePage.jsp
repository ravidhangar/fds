<%@page import="java.util.Iterator"%>
<%@page import="com.jdbc.CategoryTableobj"%>
<%@page import="com.jdbc.FoodTableObj"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jdbc.AdminDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user homepage</title>
</head>
<body>
	<form action="/FoodDeliverySystem/user.com" method="post">
		<input type="text" name="txtsearch">
		<input type="submit" value="search">
	</form>
	<form action="/FoodDeliverySystem/logout.com" method="post">
		<input type="submit" value="logout">
	</form>
	<%
		AdminDAO adminDAO=new AdminDAO();
		ArrayList<FoodTableObj> foods=new ArrayList<FoodTableObj> ();
		ArrayList<CategoryTableobj> categories=new ArrayList<CategoryTableobj>();
		foods.addAll(adminDAO.fetchDataFromFood());
		categories.addAll(adminDAO.fetchDataFromCategoryTable());
		Iterator<FoodTableObj> itr=foods.iterator();
		int counter=0;
		while(itr.hasNext()){
			FoodTableObj temp=itr.next();
	%>
	<hr size="2">
	<div><%=++counter %> Name :<%=temp.getFoodname() %><br/>
		Rate :<%=temp.getRate() %><br/>
		Description :<%=temp.getDescription() %>
	 </div>
	<%} %>
</body>
</html>