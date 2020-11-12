<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>

	<jsp:include page="/account/accountTop.jsp"></jsp:include>

	<%-- content --%>
	<main class="col bg-faded py-3 flex-grow-1" style="background:#E6E6E6;">

	<div class="card border-light mb-3 mx-auto" style="max-width: 30rem; margin-top: 30px;">

			<div class="card-header bg-transparent border-dark"
				style="text-align: center; font-size: 15pt; padding-left:5px; color:#B40404;">
				<i class="fas fa-exclamation-triangle"></i>&nbsp;&nbsp;Are you sure Drop your Account?
			</div>
			<div class="card-body text-secondary">
				<form action="/Webmark/account/dropAccount.html" method="post">
					
					<p class="card-text" style="margin-bottom: 5px;">Password :</p>
					<div class="form-group">
						<input type="password" class="form-control" name="userpw"/>
						<c:if test="${not empty passError}">
						<font style = "margin-top : 10px; color:red; font-size:10pt;">Please check your password.</font>
						</c:if>
					</div>
					
					<div style="text-align:center; font-size:10pt; padding-bottom:0px; color:#B40404;">
						If drop your account, we can't restore your webmark activities.
					</div>

					<button type="submit" class="btn btn-danger btn-block"
						style="height: 40px; margin-top: 20px; margin-bottom: 15px;">Drop Account</button>
				</form>
			</div>
		</div>

		<div style="margin-bottom:100px;"></div>
		

	</main>

	</div>

	<!-- /contents -->
	<%@ include file="/mark/markBottom.jsp" %>

</body>
</html>