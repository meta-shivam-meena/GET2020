<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.metacube.eadSession9and10.model.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Vehicle</title>
</head>
<body>
	<h2>Vehicle Registration Form</h2>
	<%
		Employee employee = (Employee) session.getAttribute("employee");
		int registrationId = employee.getRegistrationId() ;
	%>
	<form:form method="POST" modelAttribute="vehicle" action="/RegisterVehicle">
		<table>
			<tr>
				<td>Vehicle Name</td>
				<td><input type="text" name="name" required="required">
				<td><form:errors path="name"></form:errors></td>
			</tr>
			<tr>
				<td>Vehicle Type</td>
				<td>
					<select name="type" required="required">
						<option value="Cycle">Cycle
						<option value="Motorcycle">Motorcycle
						<option value="FourWheeler">Four Wheeler
					</select>
				</td>
				<td><form:errors path="type"></form:errors></td>
			</tr>
			<tr>
				<td>Vehicle Number</td>
				<td><input type="text" name="vehicleNumber" required="required"></td>
				<td><form:errors path="vehicleNumber"></form:errors></td>
			</tr>
			<tr>
				<td>Employee Registration Id</td>
				<td><input type="number" name="employeeId" value=<%=registrationId %> readonly></td>
				<td><form:errors path="employeeId"></form:errors></td>
			</tr>
			<tr>
				<td>Identification</td>
				<td><textarea></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register Vehicle">
			</tr>
		</table>
	</form:form>
</body>
</html>