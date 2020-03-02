<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Pass</title>
</head>
<body>
	<h2>Select Pass</h2>
	<form:form method="POST" modelAttribute="pass" action="/SelectPass">
		<input name="vehicleNumber" value="<%=session.getAttribute("vehicleNumber")%>" type="hidden">
		<select name="passType">
			<option value="daily">Daily
			<option value="monthly">Monthly
			<option value="yearly">Yearly
		</select>
		<td><form:errors path="passType"></form:errors></td>
		<input type="submit" value="Get Pass">
	</form:form>
</body>
</html>