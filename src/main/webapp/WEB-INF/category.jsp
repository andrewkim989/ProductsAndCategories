<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>${category.name}</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<style>
		#wrapper {
			background-color: rgb(166, 219, 192);
			padding: 25px;
			height: 650px;
		}
		h1 {
			text-align: center;
		}
		#top {
			padding: 35px;
			padding-left: 150px;
		}
		#main {
			padding-top: 50px;
			padding-left: 150px;
		}
		#products {
			display: inline-block;
			vertical-align: top;
			width: 650px;
		}
		#productadd {
			display: inline-block;
			vertical-align: top;
			width: 300px;
		}
	</style>
</head>
<body>
	<div id = "wrapper">
		<h1>${category.name}</h1>
		<div id = "main">
			<div id = "products">
				<h3>Products:</h3>
				<ul>
					<c:forEach items = "${added}" var = "p">
				        <li>${p.name}</li>
		        </c:forEach>
				</ul>
			</div>
			<div id = "productadd">
				<h6>Add a product:</h6>
				<form action = "/categories/${category.id}/add" method = "post" >
					<select name = "name">
						<c:forEach items = "${menu}" var = "m">
							<option value = "${m.name}">${m.name}</option>
						</c:forEach>
					</select>
					<br><br>
					<input type = "submit" value = "Add">
				</form>
			</div>
		</div>
	</div>
</body>
</html>