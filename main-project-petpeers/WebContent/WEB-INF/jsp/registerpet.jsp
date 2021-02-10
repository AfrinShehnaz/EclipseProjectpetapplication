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
<h2>PET APPLICATION</h2>
<%-- <c:url var="action" value="/pet/add.html" ></c:url> --%>
<c:url var="action" value="processregisterpet" ></c:url>
<form:form action="${action}"  commandName="pet" method="POST">


<table>
<c:if test="${!empty pet.pid}">
<tr>
         <td><font face="verdana" size="2px">Pet Id</font></td>
    <td>:</td>
        <td>
            <form:input path="pid" readonly="true" size="8"  disabled="true" />
            <form:hidden path="pid" /><%-- To disable pet id--%>
        </td>
    </tr>
    </c:if>

<tr>
    <td><font face="verdana" size="2px">Pet Name : </font></td>
     <td>
    <font face="verdana" size="2">
    <form:input path="pname" /> 
    <form:errors path="pname" cssClass="error"></form:errors>
    </font>
    </td>
</tr>
<tr>
    <td><font face="verdana" size="2px">Pet Breed : </font></td>
    <td>
    <font face="verdana" size="2">
    <form:input path="petbreed" /> 
    <form:errors path="petbreed" cssClass="error"></form:errors>
    </font>
    </td>
</tr>

<tr>
    <td><font face="verdana" size="2px">Price : </font></td>
    <td>
    <font face="verdana" size="2">
    <form:input path="price" /> 
    <form:errors path="price" cssClass="error"></form:errors>
    </font>
    </td>
</tr>

<tr>
        <td colspan="2">
            <c:if test="${!empty pet.pid}">
                <input type="submit" value="Edit" />
            </c:if>
            <c:if test="${empty pet.pid}">
                <input type="submit" value="Add Pet" />
            </c:if>
        </td>
    </tr>
</table>
</form:form>
</div>
</body>
</html>