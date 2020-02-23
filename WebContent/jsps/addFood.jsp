<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList,com.jdbc.*"%>
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
<title>Add food</title>
</head>
<body>
	<%
		AdminDAO adminDAO = new AdminDAO();
		ArrayList<CategoryTableobj> categories = new ArrayList<CategoryTableobj>();
		categories.addAll(adminDAO.fetchDataFromCategoryTable());
		Iterator<CategoryTableobj> itr = categories.iterator();
	%>
	<form action="/FoodDeliverySystem/addfood.com" method="post">
		<table>
			<tr>
				<td>Enter name:</td>
				<td><input type="text" name="txtfoodname"></td>
			</tr>
			<tr>
				<td><label for="category">Choose a category:</label></td>
				<td><select id="category" name="ddcategory">
						<%
				while (itr.hasNext()) {
					CategoryTableobj temp = (CategoryTableobj) itr.next();
			%>
						<option value=<%=temp.getId()%>><%=temp.getCuisine()%></option>
						<%}%>
				</select></td>
			</tr>
			<tr>
				<td>Rate:</td>
				<td><input type="number" name="numrate"></td>
			</tr>
			<tr>
				<td>Stock:</td>
				<td><input type="number" name="numstock"></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><textarea rows="5" cols="20" name="txtdescription"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
		</table>


	</form>
</body>
</html>