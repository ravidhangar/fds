<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up</title>
</head>
<body>
	<form action="/FoodDeliverySystem/signup.com" method="post">
		<table>
			<tr>

				<th colspan="2"><h2>Signup</h2></th>
			</tr>
			<tr>
				<td>Enter email:</td>
				<td><input type="text" name="txtemail"></td>
			</tr>
			<tr>
				<td>Enter password:</td>
				<td><input type="text" name="txtpassword"></td>
			</tr>
			<tr>
				<td>Confirm password:</td>
				<td><input type="text" name="txtconfirmpassword"></td>
			</tr>
			<tr>
				<td>
				<input type="radio" id="customer" name="usertype" value="customer">
				<label for="customer">user login</label>
				</td>
				<td>
				<input type="radio" id="admin" name="usertype" value="admin">
				<label for="admin">admin login</label>
				</td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="signup"></th>
			</tr>
		</table>
	</form>

</body>
</html>