<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/styles/bootstrap.min.css" />"
	rel="stylesheet">
</head>
<body>
	<div class="content">
		<fieldset>
			<legend>Welcome to BecomeHealty</legend>
			<h2>Sign Up</h2>
			${error} ${notUniqueUserNameError}
			<sf:form action="login" modelAttribute="customer">
				<br />
				<sf:label path="userName">User name:</sf:label>
				<sf:input path="userName" required="required" />
				<br />
				<sf:label path="password">Password:</sf:label>
				<sf:password path="password" required="required" />
				<br />
				<sf:label path="name">Name:</sf:label>
				<sf:input path="name" />
				<br />
				<sf:label path="birthDate">BirthDate:</sf:label>
				<sf:input type="date" path="birthDate" value="" required="required" />
				<br />
				<sf:label path="gender">Gender:</sf:label>
				<sf:radiobutton path="gender" value="Male" />Male <sf:radiobutton
					path="gender" value="Female" />Female
					<br />
				<sf:label path="height">Height:</sf:label>
				<sf:input path="height" />m.
					<br />
				<sf:label path="weight">Weight:</sf:label>
				<sf:input path="weight" />kgs.
					<br />
				<sf:label path="email">Email:</sf:label>
				<sf:input path="email" />
				<br />
				<input type="submit" value="Sign Up" />
				<br />
			</sf:form>
		</fieldset>
	</div>
</body>
</html>