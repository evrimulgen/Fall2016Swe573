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
			<div class="col-md-12">
				<legend>BecomeHealty</legend>
				<c:set var="contextPath" value="${pageContext.request.contextPath}" />
				<a href="${contextPath}/home/${userName}/${encriptedpassword}">Home</a>
				<a href="${contextPath}/profile/${userName}/${encriptedpassword}">Profile</a>
				<a href="${contextPath}/graph/${userName}/${encriptedpassword}">Progress
					Chart</a> <a
					href="${contextPath}/myFoods/${userName}/${encriptedpassword}">My
					Foods</a>
				<h2>My Foods</h2>
				<sf:form
					action="${contextPath}/myFoods/listFoodsHistory/${userName}/${encriptedpassword}"
					modelAttribute="dateRange">
					<br />
					<sf:label path="startDate">From:</sf:label>
					<sf:input type="date" path="startDate" required="required" />
					<br />
					<sf:label path="endDate">To:</sf:label>
					<sf:input type="date" path="endDate" required="required" />
					<br />
					<input type="submit" value="List My Foods" />
					<br />
				</sf:form>
				<br />
			</div>
			<div class="col-md-8">
				<table border="1px">
					<tr>
						<td>Eaten Date</td>
						<td>Food Dame</td>
						<td>Amount</td>
						<td>Unit</td>
						<td>Meal Name</td>
					</tr>
					<c:forEach var="eatenItem" items="${foodList}">
						<tr>
							<td width="100px">${eatenItem.foodEatenDate}</td>
							<td><a
								href="${contextPath}/home/${userName}/${encriptedpassword}/${eatenItem.ndbno}/${eatenItem.amount}/${eatenItem.amountType}/${eatenItem.meal}">${eatenItem.foodName}</a></td>
							<td>${eatenItem.amount}</td>
							<td>${eatenItem.amountType}</td>
							<td>${eatenItem.meal}
						</tr>
					</c:forEach>
				</table>
				<br/>
				<br/>
			</div>
			<div class="col-md-4">
				<table border="1px">
					<tr>
						<td>Exercise Date</td>
						<td>Exercise Name</td>
						<td>Duration</td>
						<td>Calories Burnt</td>
					</tr>
					<c:forEach var="sport" items="${sportList}">
						<tr>
							<td width="100px"> ${sport.date }</td>
							<td>${sport.exercise}</td>
							<td>${sport.duration}</td>
							<td>${sport.caloriesBurnt}</td>
						</tr>
					</c:forEach>
				</table>
				<br/>
				<br/>
			</div>
		</fieldset>
	</div>
</body>
</html>