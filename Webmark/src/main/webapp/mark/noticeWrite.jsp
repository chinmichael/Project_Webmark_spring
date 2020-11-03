<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--https://medium.com/@cyr9210/kosta-day43-%EA%B2%8C%EC%8B%9C%ED%8C%90-%ED%8E%98%EC%9D%B4%EC%A7%95%EC%B2%98%EB%A6%AC-%ED%8C%8C%EC%9D%BC-%EC%97%85%EB%A1%9C%EB%93%9C-%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C-%EC%8D%B8%EB%84%A4%EC%9D%BC-%EC%9D%B4%EB%AF%B8%EC%A7%80-%EA%B2%8C%EC%8B%9C%ED%8C%90-49e64007705b --%>

<!DOCTYPE html>
<html>
<body>
	<jsp:include page="/mark/markNav.jsp"></jsp:include>
	<main class="col-md-8 bg-faded py-3 flex-grow-1">

		<%--notice form --%>
		<form name = "noticeWFrm" id = "noticeWFrm" method = "post" enctype = "multipart/form-data"
			action = "/Webmark/notice/noticeWrite.html">

			<table class="table table-bordered">
				
					<tr>
						<th scope="col" class="table-active" style = "width:8.33%; text-align: center;" >Title</th>
						<th scope="col" style = "width:50%; padding: 8px">
						<input class="form-control form-control-sm" name = "noticeTitle" id = "noticeTitle" type="text" placeholder="Notice Title">
						</th>
					</tr>
					<tr>
						<th scope="col" class="table-active" style = "width:8.33%; text-align: center;">Writer</th>
						<th scope="col" style = "width:50%; padding: 8px">
						<input class="form-control form-control-sm" name = "noticeWriter" id = "noticeWriter" type="text" value = "${account.getUserid()}" readonly>
						</th>
					</tr>
					<tr>
						<th scope="col" class="table-active" style = "width:8.33%; text-align: center; font-size: 12pt;">
						Attach(Under10MB)</th>
						<th scope="col" style = "width:50%; padding: 9px;">
						<input type="file" class="form-control-file" name = "noticeAttach" id="noticeAttach">
						</th>
					</tr>
				
				
					<tr>
						<td colspan = "2" style = "padding: 8px;">
						<textarea class="form-control" style="height:400px;"
						name = "noticeContents"
						placeholder="Notice Contents" required></textarea>
						</td>
					</tr>
					
				
			</table>
			<button type="button" class="btn btn-light float-right"
					style="box-shadow: none; font-weight: none;"
					onclick = "location.href='javascript:history.back()'">
					<i class="fas fa-list"></i>&nbsp; List
			</button>
			<button type="button" class="btn btn-light float-right"
					style="box-shadow: none; font-weight: none; margin-right:10px"
					id = "noticeWriteBtn">
					<i class="fas fa-pencil-alt"></i>&nbsp; Submit
			</button>
		</form>
		
		
	</main>
		</div>
		<%@ include file="/mark/markBottom.jsp" %>
</body>
</html>