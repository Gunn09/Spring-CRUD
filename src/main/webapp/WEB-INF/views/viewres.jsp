<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style>
.cards {
		display: flex;
		flex-wrap: wrap;
		gap: 1rem;
		padding-top: 1.5rem;
}

.card {
		display: flex;
		flex-direction: column;
		max-width: 300px;
		overflow: hidden;
}
</style>

</head>
<body>

	<div class="container pt-4">

		<h1>Reservation List</h1>
		<br>

		<nav class="navbar navbar-expand-md navbar-light bg-light naving">
			<ul class="navbar-nav mr-auto mt-lg-0">
				<li class="nav-item"><a
					class="nav-link text-primary btn btn-outline-success my-2 my-sm-0 border-0"
					href="resform">Add New Record </a></li>
				<li class="nav-item"><a
					class="nav-link text-primary btn btn-outline-success my-2 my-sm-0 border-0"
					href="index.jsp">Back</a></li>
			</ul>
		</nav>


		<div class="cards">
			<c:forEach items="${res}" var="emp">
				<div class="card" style="width: 200px">
					<div class="card-body">
						<p>ID : ${emp.id}</p>
						<p>Name : ${emp.name}</p>
						<p>Gender : ${emp.gender}</p>
						<p>City : ${emp.city}</p>
						<a href="editres/${emp.id}" class="btn btn-info">Edit</a>
						<a href="deleteres/${emp.id}" class="btn btn-danger">Delete</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>