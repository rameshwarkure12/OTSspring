<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMS</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>



<style>
#data {
	background: rgba(0, 0, 0, 0.8);
}

a:link, a:visited {
	color: white;
	padding: 15px 25px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
}

a:hover, a:active {
	background-color: red;
}

#fourthTable table {
	border: none;
	/* box-shadow: 9px 9px 7px grey; */
}

#fourthTable tr {
	background: linear-gradient(to right, #1d1c1c, #4d4d4e);
	transform: skewX(10deg);
}

#fourthTable td {
	color: white;
	padding: 13px 7px 13px 7px;
	transform: skewX(-10deg);
}

#fourthTable th {
	color: rgb(255, 255, 255);
	font-size: 21px;
	padding: 5px;
	transform: skewX(-10deg);
}

.container {
	display: block;
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}
</style>


</head>
<body class="container">
<nav class="navbar navbar-light bg-light">
		<form action="search" method="get" class="form-inline">
			<input class="form-control mr-sm-2" type="search" name="txteid"
				placeholder="Search by Student ID" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</nav>
	
	<a href="getBack">Back</a>

	Home Page ${NOTIFICATION}
	






	<div id=fourthTable>

		<table>
			<tr>
				<th>Student Number</th>
				
				<th>Student First Name</th>
				<th>Student Last Name</th>
				<th>Student Email</th>
				<th>Student Password</th>
				<th>Student Gender</th>
				<th>Student contact</th>
				<th colspan="2">Action</th>
			</tr>
			<c:forEach var="stu" items="${allemp}">
				<tr>
					<td><c:out value="${stu.st_id}"></c:out></td>
					
					<td><c:out value="${stu.firstName}"></c:out></td>
					<td><c:out value="${stu.lastName}"></c:out></td>
					<td><c:out value="${stu.st_email}"></c:out></td>
					<td><c:out value="${stu.st_password}"></c:out></td>
					<td><c:out value="${stu.st_gender}"></c:out></td>
					<td><c:out value="${stu.st_contact}"></c:out></td>
					<td><a href="edit?eid=${emp.eid}">EDIT</a></td>
					<td><a href="delete?eid=${emp.eid}">DELETE</a></td>


				</tr>

			</c:forEach>

		</table>



	</div>
</html>