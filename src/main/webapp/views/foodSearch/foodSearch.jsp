<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
<link href="<c:url value="/resources/styles/bootstrap.min.css" />"
	rel="stylesheet">
</head>
<body>
	<div class="content">
		<fieldset>
			<div class="col-md-12">
				<legend>Welcome to BecomeHealty</legend>
				<h2>Search a food</h2>
				<sf:form action="dofoodsearch" modelAttribute="food">
					<!-- to display error message from action method if any -->
					<sf:errors />
					<br />
					<sf:input path="name" />
					<input type="submit" value="Search" />

				</sf:form>
				<c:set var="contextPath" value="${pageContext.request.contextPath}" />
				<ul>
					<c:forEach var="listValue" items="${allfoods}">
						<li><a
							href="${contextPath}/home/${userName}/${encriptedpassword}/dofoodsearch/${listValue.ndbno}">${listValue.name}</a></li>
					</c:forEach>
				</ul>
				${unMarshalXml}
			</div>
		</fieldset>
	</div>
</body>
</html>