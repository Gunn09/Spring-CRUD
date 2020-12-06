<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
.ajust {
		margin: auto;
		width: 60%;
		padding: 50px;
}
</style>
</head>
<body>

	<div class="jumbotron ajust pt-4 mt-5">
		<h3>Railway Reservation Form</h3><br><br>

		<form:form method="post" action="save">
			<div class="form-group">
				<label>Name</label>
				<form:input path="name" class="form-control" />
			</div>
			<div class="form-group">
				<label>Gender</label>
				<div class="form-control">
					<label> Male</label>
					<form:radiobutton path="gender" value="Male" />

					<label>Female</label>
					<form:radiobutton path="gender" value="Female" />
				</div>
			</div>
			<div class="form-group">
				<label>City </label>
				<form:select path="city_id" class="form-control">
					<c:forEach items="${cityList }" var="city">
						<option value="${city.id}">${city.name }</option>
					</c:forEach>
				</form:select>
			</div>

			<input type="submit" value="Submit" class="btn btn-primary" />
			<a href="index.jsp" class="btn btn-primary" >Back</a>

		</form:form>

	</div>

</body>
</html>