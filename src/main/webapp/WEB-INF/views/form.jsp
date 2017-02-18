<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Guest form</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=0.5">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		$(".restform").toggle();
		$('input[type="checkbox"]').click(function() {
			if ($(this).hasClass("restform-toggle")) {
				$(".restform").toggle();
			}
		});
	});
</script>
<body style="margin-left: 5%; width: 70%">
	<h1>Welcome to the Restaurant Picker!</h1>
	<br>
	<!--  need to fix static image serving in spring config -->
	<!-- 	<br> -->
	<!-- 	<img src="/images/idontcare.jpg"> -->
	<form action="#" th:action="@{/form}" method="get">
		<input type="submit" class="btn btn-default" value="Home"></input>
	</form>
	<form action="#" th:action="@{/picker}" method="get">
		<input type="submit" class="btn btn-default" value="Picker"></input>
	</form>
	<br>
	<form action="#" th:action="@{/form}" method="post">
		<div class="form-group">
			<label for="fname">First name:</label> <input type="text"
				class="form-control" id="fname" th:value="${guest.firstName}"
				name="firstName">
		</div>
		<div class="form-group">
			<label for="lname">Last name:</label> <input type="text"
				class="form-control" id="lname" th:value="${guest.lastName}"
				name="lastName">
		</div>
		<div class="form-group">
			<label for="email">Email address:</label> <input type="email"
				class="form-control" id="email" th:value="${guest.email}"
				name="email">
		</div>
		<div class="checkbox">
			<label><input class="restform-toggle" type="checkbox"
				value="unchecked"> Recommend a restaurant</label>
		</div>

		<div class="restform restform-toggle">

			<h3 style="margin-top: 4%">Restaurant information</h3>
			<div class="form-group">
				<label for="restname">Name:</label> <input type="text"
					class="form-control" id="restname"
					th:value="${restaurant.restName}" name="restName">
			</div>
			<div class="form-group">
				<label for="restcity">City:</label> <input type="text"
					class="form-control" id="restcity"
					th:value="${restaurant.restCity}" name="restCity">
			</div>
			<div class="form-group">
				<label for="restzip">Zip code:</label> <input type="number"
					class="form-control" data-format="ddddd" id="restzip"
					th:value="${restaurant.restZip}" name="restZip">
			</div>
			<div class="form-group">
				<label for="restphonenumber">Phone number:</label> <input
					type="text" class="form-control input-medium bfh-phone"
					id="restphonenumber" data-format="+1 (ddd) ddd-dddd"
					th:value="${restaurant.restPhoneNumber}" name="restPhoneNumber">
			</div>
		</div>
		<input type="submit" class="btn btn-default"></input>
	</form>
</body>
</html>

