<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body style = "background-color: #BDBDBD;">

	<jsp:include page="/coverTop.jsp"></jsp:include>
	
	
	<div class="container-fluid" style= "background-color:#D8D8D8;">

		<div class="card border-light mb-3 mx-auto" style="max-width: 23rem; margin-top: 60px;">

			<div class="card-header bg-transparent border-dark"
				style="text-align: center; font-size: 15pt;">
				<i class="fas fa-feather-alt"></i>&nbsp;&nbsp;Sign up to Webmark
			</div>
			<div class="card-body text-secondary">
				<form action="/Webmark/WebmarkServlet?command=join" method="post" name="joinFrm">
					<p class="card-text" style="margin-bottom: 5px;">ID :</p>
					<div class="form-group">
						<input type="text" class="form-control" name="joinID" id="joinID" value="${joinError.getUserid() }">
					</div>
					<p class="card-text" style="margin-bottom: 5px;">E-mail :</p>
					<div class="form-group">
						<input type="text" class="form-control" name="joinMail" id="joinMail" value="${joinError.getEmail() }">
					</div>
					<p class="card-text" style="margin-bottom: 5px;">Name :</p>
					<div class="form-group">
						<input type="text" class="form-control" name="joinName" id="joinName" value="${joinError.getUsername() }">
					</div>
					<p class="card-text" style="margin-bottom: 5px;">Nick :</p>
					<div class="form-group">
						<input type="text" class="form-control" name="joinNick" id="joinNick" value="${joinError.getUsernick() }">
					</div>
					<p class="card-text" style="margin-bottom: 5px;">Password :</p>
					<div class="form-group">
						<input type="password" class="form-control" name="joinPW" id="joinPW" value="${joinError.getUserpw() }">
					</div>
					<p class="card-text" style="margin-bottom: 5px;">Confirm Password :</p>
					<div class="form-group">
						<input type="password" class="form-control" name="joinCP" id="joinCP" value="${joinError.getUserpw() }">
					</div>

					<button type="submit" class="btn btn-success btn-block"
						style="height: 40px; margin-top: 30px; margin-bottom: 15px;"
						onclick="return loginCheck()">Sign up</button>
				</form>
			</div>
		</div>


		<div style="margin-bottom:120px;"></div>
	
	<jsp:include page="/coverBottom.jsp"></jsp:include>
</body>
</html>