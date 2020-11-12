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

		<div class="card border-light mb-3 mx-auto" style="max-width: 27rem; margin-top: 60px;">

			<div class="card-header bg-transparent border-dark"
				style="text-align: center; font-size: 15pt; padding-left:0px;">
				<i class="fas fa-feather-alt"></i>&nbsp;&nbsp;Change Password Form
			</div>
			<div class="card-body text-secondary">
				<form:form modelAttribute="accountPassVO" action="/Webmark/account/changePass.html" method="post">
					<form:hidden path="key" value="${key }" />
					<p class="card-text" style="margin-bottom: 5px;">ID or E-mail :</p>
					<div class="form-group">
						<form:input cssClass="form-control" path="userid"/>
						<font color="red" style="font-size:10pt; padding-bottom:0px; margin-bottom:0px;"><form:errors path="userid"/></font>
						<c:if test="${not empty idError}">
						<font style = "margin-top : 10px; color:red; font-size:10pt;">This ID is not available</font>
						</c:if>
					</div>
					
					<p class="card-text" style="margin-bottom: 5px;">New Password :</p>
					<div class="form-group">
						<form:password cssClass="form-control" path="userpw"/>
						<font color="red" style="font-size:10pt; padding-bottom:0px; margin-bottom:0px;"><form:errors path="userpw"/></font>
					</div>
					<p class="card-text" style="margin-bottom: 5px;">Confirm Password :</p>
					<div class="form-group">
						<form:password cssClass="form-control" path="confirm" />
						<font color="red" style="font-size:10pt; padding-bottom:0px; margin-bottom:0px;"><form:errors path="confirm"/></font>
						<c:if test="${not empty confirmError}">
						<font style = "margin-top : 10px; color:red; font-size:10pt;">Please check confirm password</font>
						</c:if>
					</div>

					<button type="submit" class="btn btn-success btn-block"
						style="height: 40px; margin-top: 30px; margin-bottom: 15px;">Change Password</button>
				</form:form>
			</div>
		</div>
		<div style="margin-bottom:120px;"></div>
	<%@ include file="/coverBottom.jsp" %>
</body>
</html>