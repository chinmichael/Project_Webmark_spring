<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<jsp:include page="/mark/markNav.jsp"></jsp:include>
	<main class="col-md-8 bg-faded py-3 flex-grow-1">

		<%--notice contents --%>
		<div class="table-responsive">
			<table class="table table-borderless">
					<tr class="table-active">
						<td colspan = "2"><h4 style = "padding-top: 3px;">${noticeCon.getNotice_title() }</h4></td>
					</tr>
					<tr class="table-light">
						<td style = "color: gray; text-decoration: none; padding : 8px; margin-top : 0px; text-align: right;">
						<i class="fas fa-pencil-alt"></i>&nbsp;${noticeCon.getUserid() }&nbsp;&nbsp;&nbsp;
						<i class="far fa-calendar-alt"></i>&nbsp;&nbsp;${noticeCon.getWrite_date() }</td>
					</tr>

					<tr>
						<td colspan = "2" style = "padding-top: 20px; padding-bottom : 20px;">${noticeCon.getNotice_contents() }</td>
					</tr>
					<tr>
						
					</tr>

			</table>
		</div>

		<c:if test="${not empty noticeCon.getNotice_attach() }">
			<hr>&nbsp;&nbsp;Attached :&nbsp;
			<a href="/Webmark/downloadNotice.jsp?filename=${noticeCon.getNotice_attach() }">
				<i class="fas fa-paperclip"></i>&nbsp;&nbsp;${noticeCon.getNotice_attach() }
			</a>
		</c:if>

		<hr>
		<%--button --%>
		<c:choose>
			<c:when
				test="${noticeCon.getUserid() == account.getUserid() || (empty noticeCon.getUserid() && account.getUsertype == '1') }">
				<button type="button" class="btn btn-light float-right"
					style="box-shadow: none; font-weight: none;" data-toggle="modal"
					data-target="#trashNoticeModal">
					<i class="fas fa-trash"></i>
				</button>
				
				<%--trash modal --%>
				<div class="modal fade" id="trashNoticeModal" tabindex="-1"
					aria-labelledby="trashNoticeModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="trashNoticeModalLabel">Caution</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close" style="outline: none;">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">Are you sure delete this notice?</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal" style="box-shadow: none;">Close</button>
								<form name="delNoticeFrm" method="post"
									action="/Webmark/WebmarkServlet?command=notice_delete">
									<input type="hidden" name="notice_num" value="${noticeCon.getNotice_num()}">
									<input type="submit" class="btn btn-danger"
										style="box-shadow: none;" value="Delete">
								</form>
							</div>
						</div>
					</div>
				</div>

			<c:choose>
				<c:when test="${not empty searchName }">
					<button type="button" class="btn btn-light float-right"
						style="box-shadow: none; font-weight: none; margin-left: 5px; margin-right: 5px;"
						onclick="location.href='/Webmark/WebmarkServlet?command=notice_edit_ready&notice_num=${noticeCon.getNotice_num()}'">
						<i class="fas fa-edit"></i>
					</button>

					<button type="button" class="btn btn-light float-right"
						style="box-shadow: none; font-weight: none;"
						onclick="location.href='/Webmark/notice/noticeSearch.html?page=${currentPage}&searchName=${searchName}&searchType=${searchType }'">
						<i class="fas fa-list"></i>
					</button>
				</c:when>
				<c:otherwise>
					<button type="button" class="btn btn-light float-right"
						style="box-shadow: none; font-weight: none; margin-left: 5px; margin-right: 5px;"
						onclick="location.href='/Webmark/WebmarkServlet?command=notice_edit_ready&notice_num=${noticeCon.getNotice_num()}'">
						<i class="fas fa-edit"></i>
					</button>

					<button type="button" class="btn btn-light float-right"
						style="box-shadow: none; font-weight: none;"
						onclick="location.href='/Webmark/notice/noticeList.html?page=${currentPage}'">
						<i class="fas fa-list"></i>
					</button>
				</c:otherwise>
			</c:choose>

		</c:when>
			<c:otherwise>
				<button type="button" class="btn btn-light float-right"
					style="box-shadow: none; font-weight: none;"
					onclick = "location.href='javascript:history.back()'">
					<i class="fas fa-list"></i>&nbsp; List
				</button>
			</c:otherwise>
		</c:choose>
	</main>
		</div>
		<%@ include file="/mark/markBottom.jsp" %>
</body>
</html>