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

				<a href="${contextPath}/home/${userName}/${encriptedpassword}">Home</a>
				<a href="${contextPath}/profile/${userName}/${encriptedpassword}">Profile</a>
				<a href="${contextPath}/graph/${userName}/${encriptedpassword}">Progress
					Chart</a> <a
					href="${contextPath}/myFoods/${userName}/${encriptedpassword}">My
					Foods</a> <br /> <br />
				<h2>Home page</h2>
				<br />
			</div>
			<div class="col-md-8">
				List of Eaten Foods Today: <br /> <br /> Breakfast:
				<table border="1px">
					<tr>
						<td>Food name</td>
						<td>Amount</td>
						<td>Unit</td>
					</tr>
					<c:forEach var="eatenItem" items="${breakfastList}">
						<tr>
							<td><a
								href="${contextPath}/home/${userName}/${encriptedpassword}/${eatenItem.ndbno}/${eatenItem.amount}/${eatenItem.amountType}/${eatenItem.meal}">${eatenItem.foodName}</a></td>
							<td>${eatenItem.amount}</td>
							<td>${eatenItem.amountType}</td>
						</tr>
					</c:forEach>
				</table>
				<br /> Lunch:
				<table border="1px">
					<tr>
						<td>Food name</td>
						<td>Amount</td>
						<td>Unit</td>
					</tr>
					<c:forEach var="eatenItem" items="${lunchList}">
						<tr>
							<td><a
								href="${contextPath}/home/${userName}/${encriptedpassword}/${eatenItem.ndbno}/${eatenItem.amount}/${eatenItem.amountType}/${eatenItem.meal}">${eatenItem.foodName}</a></td>
							<td>${eatenItem.amount}</td>
							<td>${eatenItem.amountType}</td>
						</tr>
					</c:forEach>
				</table>
				<br /> Dinner:
				<table border="1px">
					<tr>
						<td>Food name</td>
						<td>Amount</td>
						<td>Unit</td>
					</tr>
					<c:forEach var="eatenItem" items="${dinnerList}">
						<tr>
							<td><a
								href="${contextPath}/home/${userName}/${encriptedpassword}/${eatenItem.ndbno}/${eatenItem.amount}/${eatenItem.amountType}/${eatenItem.meal}">${eatenItem.foodName}</a></td>
							<td>${eatenItem.amount}</td>
							<td>${eatenItem.amountType}</td>
						</tr>
					</c:forEach>
				</table>
				<br /> Other:
				<table border="1px">
					<tr>
						<td>Food name</td>
						<td>Amount</td>
						<td>Unit</td>
					</tr>
					<c:forEach var="eatenItem" items="${otherList}">
						<tr>
							<td><a
								href="${contextPath}/home/${userName}/${encriptedpassword}/${eatenItem.ndbno}/${eatenItem.amount}/${eatenItem.amountType}/${eatenItem.meal}">${eatenItem.foodName}</a></td>
							<td>${eatenItem.amount}</td>
							<td>${eatenItem.amountType}</td>
						</tr>
					</c:forEach>
				</table>
				<br /> <a
					href="${contextPath}/home/${userName}/${encriptedpassword}/foodsearch">Add
					new eaten item</a> <br /> <a
					href="${contextPath}/home/${userName}/${encriptedpassword}/showDailyNutrients">Show
					Daily Nutrients</a> <br />
			</div>
			<div class="col-md-4">

				List of Exercises Done Today: <br /> <br />
				<table border="1px">
					<tr>
						<td>Exercise Name</td>
						<td>Duration</td>
						<td>Calories Burnt</td>
					</tr>
					<c:forEach var="sport" items="${sportList}">
						<tr>
							<td>${sport.exercise}</td>
							<td>${sport.duration}</td>
							<td>${sport.caloriesBurnt}</td>
						</tr>
					</c:forEach>
				</table>
				<br /> <a
					href="${contextPath}/home/${userName}/${encriptedpassword}/sportsList">Add
					New Sport</a>
			</div>
		</fieldset>
	</div>
</body>
</html>