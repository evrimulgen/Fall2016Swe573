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
				<h2>Graph Page</h2>

				<br />

				<div id="bmiChart"></div>
				<script type="text/javascript" src="https://www.google.com/jsapi"></script>
			</div>

			<script>
				google.load("visualization", "1", {
					packages : [ "corechart" ]
				});
				google.setOnLoadCallback(drawChart);

				function drawChart() {
					var dataAsString = "${dataAsString}";
					console.log(dataAsString);
					var splittedDataAsString = dataAsString.split(" ");
					var dataAsArray = [
										[ splittedDataAsString[0], splittedDataAsString[1], splittedDataAsString[2] ]
										];
					for( var i= 0; i < (splittedDataAsString.length -1) / 3 -1; i++ ) {
						dataAsArray.push( [] );
						}
					
					for(var i = 1 ; i < (splittedDataAsString.length -1) / 3; i++){
						for(var j = 0; j < 3; j++){
							dataAsArray[i].push(splittedDataAsString[i*3+j]);
						}
					}
					
					for (var i = 1; i < ((splittedDataAsString.length -1) / 3); i++) {
						for (var j = 1; j < 3 ; j++) {
							dataAsArray[i][j] = parseFloat(dataAsArray[i][j]);
						}
					}

					var dataTable = google.visualization
							.arrayToDataTable(dataAsArray);

					var dataView = new google.visualization.DataView(dataTable);

					var options = {
						title : "BMI and Weight",
						vAxes : {
							0 : {
								logScale : false
							},
							1 : {
								logScale : false
							}
						},
						series : {
							0 : {
								targetAxisIndex : 0
							},
							1 : {
								targetAxisIndex : 0
							}
						},
					};

					// Create and draw the visualization.
					new google.visualization.ColumnChart(document
							.getElementById('bmiChart'))
							.draw(dataView, options);
				}
			</script>
		</fieldset>
	</div>
</body>
</html>