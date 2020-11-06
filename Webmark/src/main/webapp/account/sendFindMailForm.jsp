<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body style="background-color: #BDBDBD;">

	<jsp:include page="/coverTop.jsp"></jsp:include>
	<div class="container-fluid" style="background-color: #D8D8D8;">

		<div class="card border-light mb-3 mx-auto"
			style="max-width: 18rem; margin-top: 80px;">

			<div class="card-header bg-transparent border-dark"
				style="text-align: center; font-size: 15pt;">
				<i class="far fa-bookmark"></i>&nbsp;&nbsp;Finding Password
			</div>
			<div class="card-body text-secondary">
				<form action="/Webmark/account/findByMail.html" method="post">
					<p class="card-text" style="margin-bottom: 5px;">E-mail :</p>
					<div class="form-group">
						<input type="text" name="email" class="form-control" value="${mail}">
						<c:if test="${not empty mailError}">
						<font style = "margin-top : 10px; color:red; font-size:10pt;">${mailError}</font>
						</c:if>
					</div>

					<button type="submit" class="btn btn-success btn-block"
						style="height: 40px; margin-top: 25px;"
						onclick="return loginCheck()">Send Email</button>
				</form>
				<h6 align="center"
					style="font-size: 9pt; margin-top: 20px; font-weight: normal; margin-bottom: 2px;">If
					have not Webmark account yet</h6>
				<div style="text-align: center; margin-top: 2px;">
					<a style="font-size: 10pt;" href="/Webmark/home/joinForm.html">Create
						new account</a>
				</div>
			</div>
		</div>


		<div style="margin-bottom: 120px;"></div>

		<%@ include file="/coverBottom.jsp"%>
</body>
</html>