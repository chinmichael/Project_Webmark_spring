<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<body style = "background-color: #BDBDBD;">

	<jsp:include page="/coverTop.jsp"></jsp:include>
	<div class="container-fluid" style= "background-color:#D8D8D8;">
	
	<c:choose>
		<c:when test = "${not empty loginError}">
				<div class="alert alert-danger mb-3 mx-auto" role="alert" style="padding-left:8px; max-width: 18rem; margin-top:80px; text-align:center; font-size:10pt;">
				<i class="fas fa-exclamation-circle"></i>&nbsp;&nbsp;Please check your ID or Password.</div>
				<div class="card border-light mb-3 mx-auto" style="max-width: 18rem; margin-top:20px;">
		</c:when>
		<c:otherwise>
			<div class="card border-light mb-3 mx-auto" style="max-width: 18rem; margin-top:80px;">
		</c:otherwise>
	</c:choose>

			<div class="card-header bg-transparent border-dark" style = "text-align:center; font-size: 15pt;">
			<i class="far fa-bookmark"></i>&nbsp;&nbsp;Sign in to Webmark</div>
			<div class="card-body text-secondary">
				<form:form modelAttribute="accountVO" action="/Webmark/account/login.html" method="post" name="loginFrm">
					<p class="card-text" style = "margin-bottom: 5px;">ID or E-mail :</p>
					<div class="form-group">
						<form:input path="userid" cssClass="form-control" value="${loginError }"/>
						<font color="red" style="font-size:10pt; padding-bottom:0px; margin-bottom:0px;"><form:errors path="userid"/></font>
					</div>
					<p class="card-text" style = "margin-bottom: 5px;">Password :</p>
					<div class="form-group">
						<form:password path="userpw" cssClass="form-control"/>
						<font color="red" style="font-size:10pt; padding-bottom:0px; margin-bottom:0px;"><form:errors path="userpw"/></font>
					</div>
					
					<button type="submit" class="btn btn-success btn-block" style="height:40px; margin-top:25px;" onclick="return loginCheck()">Sign in</button>
				</form:form>
				<h6 align="center" style="font-size:9pt; margin-top:20px; font-weight:normal; margin-bottom: 2px;">If have not Webmark account yet</h6>
				<div style = "text-align:center; margin-top:2px;">
					<a style="font-size:10pt;" href = "/Webmark/home/joinForm.html">Create new account</a>
				</div>
			</div>
		</div>


		<div style="margin-bottom:120px;"></div>
	
	<%@ include file="/coverBottom.jsp" %>
</body>
</html>