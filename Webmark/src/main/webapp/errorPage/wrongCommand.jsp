<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body>
	<jsp:include page="/errorPage/errorPageTop.jsp"></jsp:include>
	<div class="container-fluid">

<!--   <main role="main" class="inner cover">
    <h1 class="cover-heading">Cover your page.</h1>
    <p class="lead">Cover is a one-page template for building simple and beautiful home pages. Download, edit the text, and add your own fullscreen background photo to make it your own.</p>
    <p class="lead">
      <a href="#" class="btn btn-lg btn-secondary">Learn more</a>
    </p>
  </main> -->
		<div class="jumbotron" style = "margin-top : 15px; margin-bottom : 100px; text-align : center;">
			<h1 class="display-4">Sorry, we can't find your request page.</h1>
			<br>
			<p class="lead">Please check the address you entered is correct.</p>
			<hr class="my-4">
			<p>You entered wrong address.</p>
				<br>
			<a class="btn btn-secondary btn-lg" href="/Webmark/cover.jsp" role="button">Go to Webmark Home</a>
		</div>


		<jsp:include page="/errorPage/errorPageBottom.jsp"></jsp:include>
</body>
</html>