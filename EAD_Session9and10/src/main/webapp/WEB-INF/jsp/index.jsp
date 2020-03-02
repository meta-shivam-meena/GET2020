<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Metacube Parking System</title>
</head>
<body>
	<div>
		<a href="/Login">Login</a>
	</div>
	<h1>Metacube Parking System</h1>
	<form:form method="POST" modelAttribute="employee" action="/RegisterEmployee">
		<h2>Register Employee</h2>
		<table>
			<tr>
				<td>Full Name</td>
				<td><input type="text" name="fullName" required="required"></td>
				<td><form:errors path="fullName"></form:errors></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="male"
					checked="checked">Male <input type="radio" name="gender"
					value="female">Female</td>
				<td><form:errors path="gender"></form:errors></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" required="required">
				<td><form:errors path="email"></form:errors></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required="required"></td>
				<td><form:errors path="password"></form:errors></td>
			</tr>
			<tr>
				<td>ContactNumber</td>
				<td><input type="text" name="contactNumber" required="required"></td>
				<td><form:errors path="contactNumber"></form:errors></td>
			</tr>
			<tr>
				<td>Organization</td>
				<td><select name="organization" required="required">
						<option value="metacube">Metacube
						<option value="google">Google
						<option value="amazon">Amazon
						<option value="microsoft">Micorsoft
				</select></td>
				<td><form:errors path="organization"></form:errors></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>