<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
	<div class="content">
		<fieldset>
			<legend>Welcome to BecomeHealty</legend>
			<c:if test="${error == 'Error'}">
				<div class="alert alert-danger">
					<p>Invalid username or password.</p>
				</div>
			</c:if>
			<sf:form action="home" modelAttribute="user">
				<!-- to display error message from action method if any -->
				<sf:errors />
				<br />
				<sf:label path="userName">User name:</sf:label>
				<sf:input path="userName" />
				<br />
				<sf:label path="password">Password:</sf:label>
				<sf:password path="password" />
				<br />
				<input type="submit" value="Login" />
				
			</sf:form>

			<sf:form action="signup">
				<input type="submit" value="Sign Up" />
				<br />
			</sf:form>

		</fieldset>
	</div>
</body>
</html>