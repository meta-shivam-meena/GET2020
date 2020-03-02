<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.metacube.eadSession9and10.model.Employee"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friends</title>
</head>
<body>
	<%
		ArrayList<Employee> friends = (ArrayList<Employee>) session
				.getAttribute("friends");
	%>
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
	<h2>Friends</h2>
	<table>
		<thead>
			<tr>
				<td>Full Name</td>
				<td>Email</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<%
				for (Employee employee : friends) {
					String fullName = employee.getFullName();
					String email = employee.getEmail();
			%>
			<form action="/ViewProfile" method="post">
			<tr>
				<td><%=fullName%></td>
				<td><%=email%><input type="hidden" name="email" value=<%=email%> ></td>
				<td><input type="submit" value="View Profile"></td>
				
			</tr>
			</form>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>