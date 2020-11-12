<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>

	<jsp:include page="/account/accountTop.jsp"></jsp:include>

	<%-- content --%>
	<main class="col bg-faded py-3 flex-grow-1">

	<div class="row row-cols-1 row-cols-md-3">
		<div class="col mb-4">
			<div class="card">
				<img src="/Webmark/resource/image/book-3006768_1280.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Webmark Activity</h5>
					<p class="card-text" style="line-height:180%;">
					<font color="gray">Total Category Num :</font> &nbsp;${categoryCnt} ea<br>
					<font color="gray">Total Bookmark Num :</font> &nbsp;${bookmarkCnt} ea
					</p>
					<div style="text-align:right;"><a href="/Webmark/mark/markList.jsp">
					<i class="fas fa-external-link-alt"></i>&nbsp;&nbsp;Go to Webmark List</a></div>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card">
				<img src="/Webmark/resource/image/adult-1850177_1280.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Account Management</h5>
					<p class="card-text" style="line-height:180%;">
					<font color="gray">Account Create Date :</font> &nbsp;&nbsp;${account.createdate }<br>
					<font color="gray">Last Change Date :</font> &nbsp;&nbsp;${account.lastchange }<br>
					<font color="gray">Last Previous Login Date :</font> &nbsp;&nbsp;${account.lastlogin }
					</p>
					<div style="text-align:right;"><a href="/Webmark/home/accountManage.html">
					<i class="fas fa-external-link-alt"></i>&nbsp;&nbsp;Go to Account Manage</a></div>
				</div>
			</div>
		</div>
		<div class="col mb-4">
			<div class="card">
				<img src="/Webmark/resource/image/coffee-2151200_1280.jpg" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title">Community Activity</h5>
					<p class="card-text" style="line-height:180%;">
					Coming soon...
					</p>
				</div>
			</div>
		</div>
		
	</div>




	</main>

	</div>

	<!-- /contents -->
	<%@ include file="/mark/markBottom.jsp" %>

</body>
</html>