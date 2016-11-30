<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home Page</title>
</head>
<body>
	<div class="content">
		<fieldset>
			<legend>BecomeHealty</legend>
			<c:set var="contextPath" value="${pageContext.request.contextPath}" />
			<a href="${contextPath}/home/${userName}/${encriptedpassword}">Home</a>
			<a href="${contextPath}/profile/${userName}/${encriptedpassword}">Profile</a>
			<a href="">Progress Chart</a> <a href="">My Foods</a> <br />
			<br />
			<h2>Home page</h2>
			<br />
			<!-- display the userId just logged in -->
			Welcome ${userName}
			<a href="${contextPath}/home/${userName}/${encriptedpassword}/foodsearch">Add new eaten item</a>
			
		</fieldset>
	</div>
</body>
</html>