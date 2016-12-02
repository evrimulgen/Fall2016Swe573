<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home Page</title>
</head>
<body>
	<div class="content">
		<fieldset>
			<legend>BecomeHealty</legend>
			<h2>Eaten Item</h2>
				<br />
				Food name:
				${foodName}
				<br />
				When:
				${meal}
				<br />
				Amount
				${amount}
				${amountType}

			<br />
			<h3>Taken Nutrient values from this food:</h3>
			<table border="1px">
				<tr>
					<td>Name</td>
					<td>Unit</td>
					<td>${amount} ${amountType}</td>

				</tr>
				<c:forEach var="nutrient" items="${nutrientList}">
					<tr>
						<td>${nutrient.name}</td>
						<td>${nutrient.unit}</td>
						<td>${nutrient.value}</td>

					</tr>
				</c:forEach>
			</table>
		</fieldset>
	</div>
</body>
</html>