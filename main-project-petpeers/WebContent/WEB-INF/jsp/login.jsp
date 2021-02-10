<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>User Login Page</title>
</head>
<body>
<h1>The PetPeers</h1>
		<a href="/">Home</a>
		<a href="register">Register</a>
		<a href="/ogin">Login</a>
	<h1 class="loginhead">LOGIN FORM</h1>
	<div class="login">
		
		<form:form action="processlogin"
			method="post" modelAttribute="user">
			<table>
				<tr>
					<td><form:label path="email">Enter Email: </form:label></td>
					<td><form:input path="email" id="userName" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Enter password: </form:label></td>
					<td><form:password path="password" id="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="LOGIN"></td>
				</tr>
			</table>
		</form:form>
	</div>
	<br><br><div class="message"><span class="bgcolor" >${message}</span></div>
		
</body>
</html>