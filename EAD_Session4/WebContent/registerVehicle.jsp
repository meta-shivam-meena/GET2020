<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Vehicle</title>
</head>
<body>
	<h2>Vehicle Registration Form</h2>
	<%
		int registrationId = (Integer) request.getAttribute("registrationId");
	%>
	<form action="RegisterVehicle" method="post">
		<table>
			<tr>
				<td>Vehicle Name</td>
				<td><input type="text" name="vehicleName" required="required">
			</tr>
			<tr>
				<td>Vehicle Type</td>
				<td>
					<select name="vehicleType" required="required">
						<option value="Cycle">Cycle
						<option value="Motorcycle">Motorcycle
						<option value="FourWheeler">Four Wheeler
					</select>
				</td>
			</tr>
			<tr>
				<td>Vehicle Number</td>
				<td><input type="text" name="vehicleNumber" required="required"></td>
			</tr>
			<tr>
				<td>Employee Registration Id</td>
				<td><input type="number" name="employeeId" value=<%=registrationId %> readonly></td>
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
	</form>
</body>
</html>