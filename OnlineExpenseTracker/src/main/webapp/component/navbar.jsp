
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Expense Tracker</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<c:if test="${ empty loginUser }">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp"> <i
							class="fa-solid fa-house"></i> Home
					</a></li>
				</c:if>

				<c:if test="${not empty loginUser }">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="home.jsp"> <i
							class="fa-solid fa-house"></i> Home
					</a></li>

					<li class="nav-item"><a class="nav-link active"
						href="add_expense.jsp"> <i class="fa-solid fa-dollar-sign"></i>
							Add Expense
					</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="view_expense.jsp"> <i class="fa-solid fa-money-check"></i>
							View Expense
					</a></li>
				</c:if>
			</ul>

			<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
				<c:if test="${not empty loginUser }">
					<li class="nav-item"><a class="nav-link active" href="#">
							<i class="fa-solid fa-user"></i> ${loginUser.name}
					</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="../logout"> <i class="fa fa-sign-out" aria-hidden="true"></i>
							Logout
					</a></li>
				</c:if>

				<c:if test="${ empty loginUser }">
					<li class="nav-item"><a class="nav-link active"
						href="register.jsp"> <i class="fa-solid fa-user-plus"></i>
							Register
					</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="login.jsp"> <i class="fa-solid fa-right-to-bracket"></i>
							Login
					</a></li>
				</c:if>

			</ul>
		</div>
	</div>
</nav>