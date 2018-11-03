<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>New Category</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<style>
		#wrapper {
			background-color: rgb(178, 232, 167);
			padding: 25px;
			padding-left: 30px;
			height: 650px;
			color: rgb(34, 162, 117);
		}
		input[type = submit] {
			font-size: 20px;
		}
	</style>
</head>
<body>
	<div id = "wrapper">
		<h1>New Category</h1>
		<br>
		<form:form action = '/categories/new/process' method = 'post' modelAttribute = "category">
			<p><form:errors path = "name"/></p>
			<form:label path = "name"><h4>Name:</h4> </form:label>
			<form:input path = "name"/><br><br>
			<input type = "submit" value = "Create">
		</form:form>
	</div>
</body>
</html>