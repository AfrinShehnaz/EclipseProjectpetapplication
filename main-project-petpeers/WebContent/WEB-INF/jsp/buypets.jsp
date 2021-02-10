<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
	<div class="head-div">
		<h1>PetPeers</h1>
		<nav class="main-nav">
			<br>
			<ul class="main-nav-items">
				<li class="main-nav-item"><a href="profile">Profile</a></li>
				<li class="main-nav-item"><a href="registerpet">Register
						Pet</a></li>
				<li class="main-nav-item"><a href="displaypets">My Pets</a></li>
				<li class="main-nav-item"><a href="logout">Logout</a></li>
			</ul>
		</nav>
	</div>
	<h1 class="welcome">Welcome To My Pet Shop</h1>
	<div class="login">
		<table>
			<thead>
				<tr>
					<th>Pet Name</th>
					<th>Pet Breed</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pet" items="${availPets}">
					<c:if test="${pet.user!=null}">
						<tr>
							<td><c:out value="${pet.pname}" /></td>
							<td><c:out value="${pet.petbreed}" /></td>
							<td><c:out value="${pet.price}" /></td>
							<td class="soldout"><c:out value="Sold Out" /></td>
						</tr>
					</c:if>
					<c:if test="${ pet.user==null}">
						<tr>
							<td><c:out value="${pet.pname}" /></td>
							<td><c:out value="${pet.petbreed}" /></td>
							<td><c:out value="${pet.price}" /></td>
							<td><a class="butt" href="/buypet/${pet.pid}">Buy Now</a></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>