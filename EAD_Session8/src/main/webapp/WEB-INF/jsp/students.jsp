<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="./header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	margin: 2px;
	padding: 2px
}
</style>
<title>All Students</title>
</head>
<body>
	<h1>All Students</h1>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Father's Name</th>
				<th>Email</th>
				<th>Class</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">
				<tr>
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.fatherName}</td>
					<td>${student.email}</td>
					<td>${student.class1}</td>
					<td>${student.age}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>