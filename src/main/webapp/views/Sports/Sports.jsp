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
	<div class="content">
		<fieldset>
			<div class="col-md-12">
				<legend>BecomeHealty</legend>
				<c:set var="contextPath" value="${pageContext.request.contextPath}" />
				<table border="1px">
					<tr>
						<td>Sports Name</td>

					</tr>
					<c:forEach var="exercise" items="${exerciseList}">
						<tr>
							<td><a
								href="${contextPath}/home/${userName}/${encriptedpassword}/addSport/${exercise.id}">${exercise.exercise}</a></td>

						</tr>
					</c:forEach>
				</table>
			</div>
		</fieldset>
	</div>
</body>
</html>