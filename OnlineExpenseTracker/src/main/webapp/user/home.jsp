<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<%@include file="../component/all_css.jsp"%>
</head>
<body>
	<c:if test="${empty loginUser }">
		<c:redirect url="../login.jsp"></c:redirect>
	</c:if>
	<%@include file="../component/navbar.jsp"%>
	<div id="carouselExample" class="carousel slide">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="../img/exp3.jpg" class="d-block w-100" alt="..."
					height="639px">
			</div>
			<div class="carousel-item">
				<img src="../img/exp2.png" class="d-block w-100" alt="..."
					height="639px">
			</div>
			<div class="carousel-item">
				<img src="../img/exp1.jpg" class="d-block w-100" alt="..."
					height="639px">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExample" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExample" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

</body>
</html>