<%@page import="javax.xml.transform.Templates"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.jdbc.FoodTableObj"%>
<%@page import="com.jdbc.CategoryTableobj"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jdbc.AdminDAO"%>
<%@ page import="com.util.Id" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify Selected</title>
</head>
<body>
	<%
	HttpSession httpSession=request.getSession();
	Id id =(Id)httpSession.getAttribute("foodid");
	AdminDAO adminDAO=new AdminDAO();
	FoodTableObj foodTableObj=new FoodTableObj();
	foodTableObj=adminDAO.fectchUsingId(id.getId());
	ArrayList<CategoryTableobj> categories=new ArrayList<CategoryTableobj> ();
	categories.addAll(adminDAO.fetchDataFromCategoryTable());
	Iterator<CategoryTableobj> itr=categories.iterator();
	%>
	<form action="/FoodDeliverySystem/modifyselectedfood.com" method="post">
		<table>
		<tr>
			<td>Enter name:</td>
			<td><input type="text" name="txtname" value=<%=foodTableObj.getFoodname() %>></td>
		</tr>
			<tr>
			<td>Select Category:</td>
			<td>
				<select name="ddcategory">	
					<%while(itr.hasNext()){
					CategoryTableobj temp=itr.next();
					%>
					<option value=<%=temp.getId()%>> <%=temp.getCuisine() %></option>
					<%} %>
				</select>
			</td>
		</tr>
		<tr>
			<td>Enter rate:</td>
			<td><input type="number" value=<%=foodTableObj.getRate()%> name="numrate"></td>
		</tr>
		<tr>
			<td>Enter stock:</td>
			<td><input type="number" value=<%=foodTableObj.getStock()%> name="numstock"></td>
		</tr>
		<tr>
			<td>Enter description:</td>
			<td><textarea rows="5" cols="20" name="txtdescription"><%=foodTableObj.getDescription() %></textarea></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="modify"></td>
		</tr>
		</table>
	</form>
</body>
</html>