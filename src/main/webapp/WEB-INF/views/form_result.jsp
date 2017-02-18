<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Thank you</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body style="margin-left: 5%; width: 70%">
	<br>
	<form action="#" th:action="@{/form}" method="get">
		<input type="submit" class="btn btn-danger" value="Home"></input>
	</form>
	<form action="#" th:action="@{/picker}" method="get">
		<input type="submit" class="btn btn-danger" value="Picker"></input>
	</form>
	<h2>Thank you for your submission.</h2>
	<form action="#" th:action="@{/form}" method="get">
		<input type="submit" class="btn btn-danger" value="Home"></input>
	</form>
	<br><br>
	<h4>Guest info</h4>
	<br>
	<table class="table">
		<thead>
			<tr>
				<th>First name</th>
				<th>Last name</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${guest.firstName}</td>
				<td>${guest.lastName}</td>
				<td>${guest.email}</td>
			</tr>
		</tbody>
	</table>
	<br><br>
	
	<h4>Restaurant info</h4>
	<br>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>City</th>
				<th>Zip code</th>
				<th>Phone number</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${restaurant.restName}</td>
				<td>${restaurant.restCity}</td>
				<td>${restaurant.restZip}</td>
				<td>${restaurant.restPhoneNumber}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>