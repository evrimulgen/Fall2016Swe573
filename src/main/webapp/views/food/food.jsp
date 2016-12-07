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
				<h2>New Eaten Item</h2>
				<sf:form
					action="${requestScope['javax.servlet.forward.request_uri']}/saveEatenItem"
					modelAttribute="newEatenItem">

					<br />
					<sf:label path="foodName">Food name:</sf:label>
					<sf:input path="foodName" type="text" value="${foodName}"
						style="width:800px" />
					<br />
					<sf:label path="when">When:</sf:label>
					<sf:select path="meal" items="${mealList}" />
					<br />
					<sf:label path="amount">Amount</sf:label>
					<sf:input path="amount" type="number" />
					<sf:select path="amountType" items="${labelList}" />
					<input type="submit" value="Save" />

				</sf:form>
				<br />
				<h3>Nutrient values</h3>
				<table border="1px">
					<tr>
						<td>Name</td>
						<td>Unit</td>
						<td>Per 100 gr</td>
						<c:forEach var="measureElement" items="${measureList}">

							<td>${measureElement.label}-per ${measureElement.eqv}gr</td>

						</c:forEach>

					</tr>
					<c:forEach var="nutrient" items="${nutrientList}">
						<tr>
							<td>${nutrient.name}</td>
							<td>${nutrient.unit}</td>
							<td>${nutrient.value}</td>
							<c:forEach var="measure" items="${nutrient.measureList}">

								<td>${measure.value}</td>

							</c:forEach>

						</tr>
					</c:forEach>
				</table>
			</div>
		</fieldset>
	</div>
</body>
</html>