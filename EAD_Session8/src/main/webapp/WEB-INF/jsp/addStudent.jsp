<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="./header.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
<style>
input, select {
	margin: 2px;
	padding: 2px;
}
</style>
</head>
<body>
	<form:form method="POST" modelAttribute="student" action="/addStudent">
			<h1>Enter Student Details</h1>
			<table>
				<tr>
					<td>First Name</td>
					<td><form:input type="text" path="firstName" /></td>
					<td><form:errors path="firstName"></form:errors></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input type="text" path="lastName" /></td>
				</tr>
				<tr>
					<td>Father's name</td>
					<td><form:input type="text" path="fatherName" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input type="text" path="email" /></td>
					<td><form:errors path="email"></form:errors></td>
				</tr>
				<tr>
					<td>Class</td>
					<td><form:input type="number" path="class1" /></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><form:input type="number" path="age" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
	</form:form>
</body>
</html>