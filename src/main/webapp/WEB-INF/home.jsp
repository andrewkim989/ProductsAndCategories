<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Products and Categories</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<style>
		#wrapper {
			background-color: rgb(178, 232, 167);
			text-align: center;
			padding: 30px;
			height: 650px;
		}
		a {
			font-size: 40px;
		}
	</style>
</head>
<body>
	<div id = "wrapper">
		<h1>Products and Categories (Many-to-Many Relationship)</h1>
		<br><br><br><br>
		<a href = "/products/new">Create a Product!</a>
		<br><br>
		<a href = "/categories/new">Create a Category!</a>
	</div>
</body>
</html>