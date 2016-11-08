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
				<legend>Navigation menu</legend>
				<a href="">Home</a>
				<a href="">Profile</a>
				<a href="">Progress Chart</a>
				<a href="">My Foods</a>
				<br /><br />
				<h2>Home page</h2>
				<br/>
				<!-- display the userId just logged in -->
				Welcome ${user.userName }
			</fieldset>
		</div>
	</body>
</html>