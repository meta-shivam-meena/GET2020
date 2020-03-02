<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.metacube.eadSession9and10.model.Employee"%>
	<%@ page import="org.springframework.ui.Model" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="/Home" method="post">
			<input type="submit" value="Home">
		</form>
		<form action="/Friends" method="post">
			<input type="submit" value="Friends">
		</form>
		<form action="/Logout" method="post">
			<input type="submit" value="Log Out">
		</form>
	</div>
	<%
		Employee employee = (Employee) session.getAttribute("friend");
		String fullName = employee.getFullName();
		String gender = employee.getGender();
		String email = employee.getEmail();
		String contactNumber = employee.getContactNumber();
		String organization = employee.getOrganization();
		int registrationId = employee.getRegistrationId();
	%>
	<h2>Employee Profile</h2>
	<table>
		<tr>
			<td>Full Name</td>
			<td><%=fullName%></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><%=gender%></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><%=email%></td>
		</tr>
		<tr>
			<td>Contact Number</td>
			<td><%=contactNumber%></td>
		</tr>
		<tr>
			<td>Organization</td>
			<td><%=organization%></td>
		</tr>
		<tr>
			<td>Registration Id</td>
			<td><%=registrationId%></td>
		</tr>
	</table>
</body>
</html>