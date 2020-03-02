<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form:form method="POST" modelAttribute="loginData" action="/Login">
<input type="text" name="email" placeholder="email" required="required">
<input type="password" name="password" placeholder="password" required="required">
<input type="submit" value="login">
</form:form>
</body>
</html>