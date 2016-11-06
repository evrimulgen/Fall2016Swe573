<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
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
				<legend>Navigation menu</legend>
				<a href="index.jsp">Home</a>
				<!-- here the action's value will be used to map the corresponding 
					method in controller needs to be executed on form submit.
					modelAttribute value should be camelCase name of bean 
					added earlier as model in spring controller
					-->
				<c:if test="${error == 'Error'}">
								<div class="alert alert-danger">
									<p>Invalid username or password.</p>
								</div>
				</c:if>
				<sf:form action="doLogin" modelAttribute="user">
					<!-- to display error message from action method if any -->
					<sf:errors />
					<br />
					<sf:label path="userId">UserName:</sf:label>
					<sf:input path="userId" />
					<br />
					<!-- to display validation error message if any -->
					<sf:errors path="userId" />
					<br />
					<sf:label path="password">Password:</sf:label>
					<sf:password path="password" />
					<br />
					<sf:errors path="password" />
					<br />
					<input type="submit" value="Login" /><br />
				</sf:form>
		     
			</fieldset>
		</div>
	</body>
</html>