<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home Page</title>
<link href="<c:url value="/resources/styles/bootstrap.min.css" />"
	rel="stylesheet">
</head>
<body>
	<div class="col-md-12">
		<sf:form
			action="${requestScope['javax.servlet.forward.request_uri']}/saveSport"
			modelAttribute="sport">
			<br />
			<sf:label path="exercise">Food name:</sf:label>
			<sf:input path="exercise" type="text" value="${exerciseName}"
				style="width:400px" />
			<br />
			<sf:label path="duration">Duration:</sf:label>
			<sf:input path="duration" type="number" /> minutes
			<br/>
		<input type="submit" value="Save" />

		</sf:form>
	</div>
</body>
</html>