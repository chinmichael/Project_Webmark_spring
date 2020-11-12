<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body style="background-color: #BDBDBD;">

	<jsp:include page="/coverTop.jsp"></jsp:include>
	<div class="container-fluid" style="background-color: #D8D8D8;">

		<div class="card border-light mb-3 mx-auto"
			style="max-width: 40rem; margin-top: 125px;">

			<div class="card-header bg-transparent border-dark"
				style="text-align: center; font-size: 15pt; color:green;">
				<i class="fas fa-exclamation-circle"></i>&nbsp;&nbsp;Result Information
			</div>
			<div class="card-body text-secondary" style="text-align:center;">		
					<p style="margin-top:6px; margin-bottom:3px;">${param.changePassMsg}</p>
			</div>
		</div>


		<div style="margin-bottom: 120px;"></div>

		<%@ include file="/coverBottom.jsp"%>
</body>
</html>