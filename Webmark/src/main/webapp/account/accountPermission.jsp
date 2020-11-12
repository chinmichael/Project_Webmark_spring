<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>

	<jsp:include page="/account/accountTop.jsp"></jsp:include>

	<%-- content --%>
	<main class="col bg-faded py-3 flex-grow-1" style="background:#E6E6E6;">

		<div class="card border-light mb-3 mx-auto" style="max-width: 25rem; margin-top: 30px;">

			<div class="card-header bg-transparent border-dark"
				style="text-align: center; font-size: 15pt; padding-left:5px;">
				<i class="fas fa-arrow-circle-up"></i>&nbsp;&nbsp;Authorization
			</div>
			<div class="card-body text-secondary">
			<form action="/Webmark/account/permissionCheck.html" method="post"
				class="form-inline my-1 my-lg-0">

				<p class="card-text" style="margin-bottom: 5px;">ID to
					Authorize&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;</p>
					<div class="form-group mb-0">
						<input class="form-control mr-sm-1" type="text" name="userid" value="${idError }"
							style="height: calc(1.5em + 0.75rem - 2px); box-shadow: none; width:150px;">
					</div>
					<div class="form-group mx-sm-0 mb-0">
						&nbsp;
						<button class="btn btn-secondary my-2 my-sm-0" type="submit"
							style="height: calc(1.5em + 0.75rem - 2px); line-height: 0; box-shadow: none;">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</form>
				<div style="text-align: right; padding-right: 78px;">
					<c:if test="${not empty idError}">
						<font style="margin-top: 10px; color: red; font-size: 10pt;">This
							ID is not available.</font>
					</c:if>
				</div>

				<c:if test="${not empty upgradeId}">
					<form method="post" action="/Webmark/account/permissionSet.html">
						<input type="hidden" name="upgradeId" value="${upgradeId }">
						<button type="submit" class="btn btn-danger btn-block"
							style="height: 40px; margin-top: 20px; margin-bottom: 15px; font-size: 10pt;">
							Do you give permission to ${upgradeId}?</button>
					</form>
				</c:if>
		</div>
		</div>

		<div style="margin-bottom:100px;"></div>
		

	</main>

	</div>

	<!-- /contents -->
	<%@ include file="/mark/markBottom.jsp" %>

</body>
</html>