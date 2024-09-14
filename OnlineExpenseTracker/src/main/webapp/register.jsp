<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<%@include file="component/all_css.jsp"%>
<style>
.card-sh {
	box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body class="bg-light">
	<%@include file="component/navbar.jsp"%>


	<div class="container">
		<div class="row mt-5">
			<div class="col-md-6 offset-md-3">
				<div class="card card-sh">
					<div class="card-header">
						<p class="text-center fs-3">Register Here</p>
						<c:if test="${not empty msg}">
							<p class="text-center text-success fs-4">${msg}</p>
							<c:remove var="msg" />
						</c:if>
					</div>

					<div class="card-body">
						<form action="userRegister" method="post">
							<div class="mb-3">
								<label>Full name:</label> <input type="text" name="fullName"
									class="form-control" />
							</div>

							<div class="mb-3">
								<label>Email:</label> <input type="email" name="email"
									class="form-control" />
							</div>

							<div class="mb-3">
								<label>Password:</label> <input type="text" name="password"
									class="form-control" />
							</div>

							<div class="mb-3">
								<label>About:</label>
								<textarea class="form-control" name="about"></textarea>
							</div>

							<button class="btn btn-success col-md-12">Register</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>