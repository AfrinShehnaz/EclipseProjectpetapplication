<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration page</title>

	

</head>
<body>
<a href="/">Home</a>                                                 
			<a href="register">Register</a>
			<a href="login">Login</a>
			
	<h1 class="loginhead">REGISTRATION FORM FOR USER</h1>
	<p id="message">${message}</p>
	<div class="login">
	<form:form action="processregister" method="post" modelAttribute="user">
		<table>
			<tr>
				<td><form:label path="email">Enter user email: </form:label></td>
				<td><form:input path="email" id="userName" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Enter password: </form:label></td>
				<td><form:password path="password" id="password" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Enter name : </form:label></td>
				<td><form:input path="name" id="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>