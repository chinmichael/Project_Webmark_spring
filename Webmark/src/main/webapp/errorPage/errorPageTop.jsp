<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"
  />
<link rel="stylesheet"
	href="/Webmark/resource/css/bootstrap.css">

<style type="text/css">
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

.container-fluid {
	min-height: 94%;
	position: relative;
	overflow: auto;
}

footer {
	position: absolute;
	bottom: 0;
	right: 0;
	width: 100%;
	height: 50px;
	padding: 12px 0px;
	color: #848484;
	background-color: #EDF1F4;
}
</style>

</head>
<body>

<!-- navigation -->
	<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="/Webmark/cover.jsp"><i class="far fa-bookmark"></i>&nbsp;&nbsp;Webmark</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarTogglerDemo02"
			aria-controls="navbarTogglerDemo02" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<c:if test = "${not empty account }">
				<li class="nav-item"><a class="nav-link" href="/Webmark/mark/markList.jsp">List
						 <span class="sr-only">(current)</span> 
				</a></li>
				<li class="nav-item"><a class="nav-link" href=#>Community</a></li>
				</c:if>
			</ul>

			<ul class="navbar-nav mr-sm-3 mt-2 mt-lg-0">
				<c:choose>
					<c:when test="${not empty account }">

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href=#
							id="navbarDropdownMenuLink" role="button"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">

								<c:choose>
									<c:when test="${account.usertype == '1' }">
										<i class="fas fa-user-cog"></i>
									</c:when>
									<c:otherwise>
										<i class="fas fa-user-tag"></i>
									</c:otherwise>
								</c:choose> &nbsp; ${account.usernick} &nbsp;
						</a>
							<div class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<a class="dropdown-item" href="/Webmark/account/AccountModify.jsp">Account</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item"
									href="/Webmark/account/logout.html">Logout</a>
							</div></li>

					</c:when>
					<c:otherwise>

						<li class="nav-item"><a class="nav-link" href="/Webmark/account/login.html"><i
								class="fas fa-user-check"></i> &nbsp; Sign-in &nbsp; </a></li>

					</c:otherwise>
				</c:choose>
			</ul>
			
		</div>
	</nav>
