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
<title>Admin home page</title>
</head>
<body>
	<form action="/FoodDeliverySystem/admin.com" method="post">
		<table>
			<tr>
				<td><input type="submit" value="Add category" name="action"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Delete category" name="action"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add food" name="action"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Modify food" name="action"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Delete food" name="action"></td>
			</tr>
			<tr>
				<td><input type="submit" value="logout" name="action"></td>
			</tr>
		</table>
	</form>
</body>
</html>