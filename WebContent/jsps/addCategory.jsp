<%@ page language="java" import="com.util.User" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	HttpSession httpSession = request.getSession();
	//response.setHeader("Cache-Control", "no-cache,no-store");//HTTP 1.1

	//response.setHeader("Pragma", "no-cache");//HTTP 1.0
	if (httpSession.getAttribute("admin") == null) {
		response.sendRedirect("login.jsp");
	}
	User user=(User)httpSession.getAttribute("admin");
	out.print(user.getEmail());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add category</title>
</head>
<body>
	<form action="/FoodDeliverySystem/addcategory.com" method="post">
		Add category:<input type="text" name="txtcategory"><br> 
		<input type="submit" value="add" name="action">
	</form>	
</body>
</html>