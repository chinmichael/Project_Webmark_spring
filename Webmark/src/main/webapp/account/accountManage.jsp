<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

	<jsp:include page="/account/accountTop.jsp"></jsp:include>

	<%-- content --%>
	<main class="col bg-faded py-3 flex-grow-1" style="background:#E6E6E6;">
	
	<div class="card border-light mb-3 mx-auto" style="max-width: 30rem; margin-top: 30px;">

			<div class="card-header bg-transparent border-dark"
				style="text-align: center; font-size: 15pt; padding-left:5px;">
				<i class="fas fa-feather-alt"></i>&nbsp;&nbsp;Change Webmark Account
			</div>
			<div class="card-body text-secondary">
				<form:form modelAttribute="accountRegVO" action="/Webmark/account/changeAccount.html" method="post">
					<form:hidden path="userid" value="${account.userid }" />
					<p class="card-text" style="margin-bottom: 5px;">E-mail :</p>
					<div class="form-group">
						<form:input cssClass="form-control" path="email" value="${account.email }"/>
						<font color="red" style="font-size:10pt; padding-bottom:0px; margin-bottom:0px;"><form:errors path="email"/></font>
						<c:if test="${not empty duplicationMail}">
						<font style = "margin-top : 10px; color:red; font-size:10pt;">This Mail is already used.</font>
						</c:if>
					</div>
					<p class="card-text" style="margin-bottom: 5px;">Name :</p>
					<div class="form-group">
						<form:input cssClass="form-control" path="username" value="${account.username }"/>
						<font color="red" style="font-size:10pt; padding-bottom:0px; margin-bottom:0px;"><form:errors path="username"/></font>
					</div>
					<p class="card-text" style="margin-bottom: 5px;">Nick :</p>
					<div class="form-group">
						<form:input cssClass="form-control" path="usernick" value="${account.usernick }"/>
						<font color="red" style="font-size:10pt; padding-bottom:0px; margin-bottom:0px;"><form:errors path="usernick"/></font>
					</div>
					<p class="card-text" style="margin-bottom: 5px;">Password :</p>
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
						style="height: 40px; margin-top: 30px; margin-bottom: 15px;">Change Account</button>
				</form:form>
			</div>
		</div>

		<div style="margin-bottom:100px;"></div>
		

	</main>

	</div>

	<!-- /contents -->
	<%@ include file="/mark/markBottom.jsp" %>

</body>
</html>