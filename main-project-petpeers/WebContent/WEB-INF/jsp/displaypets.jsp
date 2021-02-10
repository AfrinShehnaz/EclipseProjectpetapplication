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
<div align="center">
<h3>Display List of Pets</h3>
<%-- <h5>${myPets.petbreed}</h5> --%>
<%-- <c:if test="${!empty petList}"> --%>
 <c:if test="${!empty myPets}">
    <table class="petTable">
    <tr>
        <th width="180">Pet Name</th>
        <th width="160">Pet Breed</th>
        <th width="60">Price</th>
        <th width="60" colspan="2">Action</th>
       
    </tr>
 <c:forEach items="${myPets}" var="pet">
 <%-- <c:forEach items="${petList}" var="pet"> --%>
        <tr>
        <td>${pet.pid}</td>
            <td>${pet.pname}</td>
            <td>${pet.petbreed}</td>
            <td>${pet.price}</td>
             <td><a href="<c:url value='/edit/${pet.pid}' />" >Edit</a></td>
            <td><a href="<c:url value='/delete/${pet.pid}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</div>

</body>
</html>s