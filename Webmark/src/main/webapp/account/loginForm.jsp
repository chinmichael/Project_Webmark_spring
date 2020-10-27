<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				<form action="/Webmark/WebmarkServlet?command=login" method="post" name="loginFrm">
					<p class="card-text" style = "margin-bottom: 5px;">ID or E-mail :</p>
					<div class="form-group">
						<input type="text" class="form-control" name="loginID" id="loginID" value="${loginError }">
					</div>
					<p class="card-text" style = "margin-bottom: 5px;">Password :</p>
					<div class="form-group">
						<input type="password" class="form-control" name="loginPW" id="loginPW">
					</div>
					
					<button type="submit" class="btn btn-success btn-block" style="height:40px; margin-top:30px;" onclick="return loginCheck()">Sign in</button>
				</form>
				<h6 align="center" style="font-size:9pt; margin-top:20px; font-weight:normal; margin-bottom: 2px;">If have not Webmark account yet</h6>
				<div style = "text-align:center; margin-top:2px;">
					<a style="font-size:10pt;" href = "/Webmark/account/joinForm.jsp">Create new account</a>
				</div>
			</div>
		</div>


		<div style="margin-bottom:120px;"></div>
		
		<script type = "text/javascript">
			function loginCheck() {
				
				var userid = $("#loginID").val();
				var userpw = $("#loginPW").val();
				
				if(userid == '') {
					$("#loginID").focus();
					return false;
				}
				if(userpw == '') {
					$("#loginPW").focus();
					return false;
				}
				return true;
			}
		</script>
	
	<jsp:include page="/coverBottom.jsp"></jsp:include>
</body>
</html>