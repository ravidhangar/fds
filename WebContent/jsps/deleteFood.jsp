<%@page import="java.util.Iterator"%>
<%@page import="com.jdbc.AdminDAO"%>
<%@page import="com.jdbc.FoodTableObj"%>
<%@page import="java.util.ArrayList"%>
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
<title>Delete food</title>
</head>
<body>
	<%
	ArrayList<FoodTableObj> foods=new ArrayList<FoodTableObj> ();
	foods.addAll(new AdminDAO().fetchDataFromFood());
	Iterator<FoodTableObj> itr=foods.iterator();
	%>
	<form action="/FoodDeliverySystem/deletefood.com" method="post">
	<label for="food">Select Food item to Delete:</label>
	<select id="food" name="dbfood">
		<%
			while(itr.hasNext()){
			FoodTableObj temp=(FoodTableObj)itr.next();
		%>
		<option value=<%=temp.getId()%>><%=temp.getFoodname()%></option>
		<%} %>
	</select>
	<br/>
	<input type="submit">
	</form>
</body>
</html>