<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	</head>
	<body>
		<div class="content">
			<fieldset>
				<legend>BecomeHealty</legend>
				<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
				<a href="${contextPath}/home/${userName}/${encriptedpassword}">Home</a>
				<a href="${contextPath}/profile/${userName}/${encriptedpassword}">Profile</a>
				<a href="">Progress Chart</a>
				<a href="">My Foods</a>
				<h2>Profile</h2>
				<sf:form action="profile" modelAttribute="customer">
					<br />
					<sf:label path="birthDate">BirthDate:</sf:label>
					<sf:input type="date" path="birthDate" value="" required = "required" />
					<br />
					<sf:label path="gender">Gender:</sf:label>
					<sf:radiobutton path="gender" value="Male" />Male <sf:radiobutton
					path="gender" value="Female" />Female
					<br />
					<sf:label path="height">Height:</sf:label>
					<sf:input path="height" />
					<br />
					<sf:label path="weight">Weight:</sf:label>
					<sf:input path="weight" />
					<br />
					<input type="submit" value="Update" /><br />
				</sf:form>
			</fieldset>
		</div>
	</body>
</html>