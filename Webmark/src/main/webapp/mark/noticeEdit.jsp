<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<jsp:include page="/mark/markNav.jsp"></jsp:include>
	<main class="col bg-faded py-3 flex-grow-1">

		<%--notice form --%>
		<form name = "noticeEFrm" id = "noticeEFrm" method = "post" enctype = "multipart/form-data"
			action = "/Webmark/WebmarkServlet?command=notice_edit">
		<input type = "hidden" name = "noticeNumEdit" value = "${noticeCon.getNotice_num() }">

			<table class="table table-bordered">
				
					<tr>
						<th scope="col" class="table-active" style = "width:8.33%; text-align: center;" >Title</th>
						<th scope="col" style = "width:50%; padding: 8px">
						<input class="form-control form-control-sm" name = "noticeTitleE" id = "noticeTitleE" type="text" placeholder="Notice Title"
						value = "${noticeCon.getNotice_title() }">
						</th>
					</tr>
					<tr>
						<th scope="col" class="table-active" style = "width:8.33%; text-align: center;">Writer</th>
						<th scope="col" style = "width:50%; padding: 8px">
						<input class="form-control form-control-sm" name = "noticeWriterE" id = "noticeWriterE" type="text" value = "${noticeCon.getUserid() }" readonly>
						</th>
					</tr>
					<tr>
						<th scope="col" class="table-active" style = "width:8.33%; text-align: center;">Attach(Under10MB)</th>
						<th scope="col" id = "attachTd" style = "width:50%; padding: 9px;">
						<c:choose>
							<c:when test="${not empty noticeCon.getNotice_attach() }">
								<input type="hidden" name = "noticeAttachFlg" id = "noticeAttachFlg" value = "false">
								<input type="hidden" name="noticeBeforeAttach" value = "${noticeCon.getNotice_attach()}">
								<a href="/Webmark/downloadNotice.jsp?filename=${noticeCon.getNotice_attach() }"
								id = "noticeBeforeAttachLink" style = "font-size:10pt;">
									<i class="fas fa-paperclip"></i>&nbsp;${noticeCon.getNotice_attach() }&nbsp;&nbsp;</a>
								<button type="button" id = "attachFileDelBtn" class="btn btn-light btn-sm"
								onclick="editNoticeAttach()"><i class="fas fa-trash"></i></button>
								
								<script type = "text/javascript">
									function editNoticeAttach() {
										$("#noticeBeforeAttachLink").remove();
										$("#attachFileDelBtn").remove();
										$("#noticeAttachFlg").val("true");
																			
										var tag = "<input type='file' class='form-control-file' name = 'noticeAttachE' id='noticeAttachE'>";
										$("#attachTd").append(tag);
									}
								</script>	
								
							</c:when>
							<c:otherwise>
								<input type="hidden" name = "noticeAttachFlg" id = "noticeAttachFlg" value = "true">
								<input type="file" class="form-control-file" name = "noticeAttachE" id="noticeAttachE">
							</c:otherwise>
						</c:choose>
						
						</th>
					</tr>
				
				
					<tr>
						<td colspan = "2" style = "padding: 8px;">
						<textarea class="form-control" style="height:400px;"
						name = "noticeContentsE" placeholder="Notice Contents" required>${noticeCon.getNotice_contents() }</textarea>
						</td>
					</tr>
					
				
			</table>
			<button type="button" class="btn btn-light float-right"
					style="box-shadow: none; font-weight: none;"
					onclick = "location.href='/Webmark/WebmarkServlet?command=notice_list'">
					<i class="fas fa-list"></i>&nbsp; List
			</button>
			<button type="button" class="btn btn-light float-right"
					style="box-shadow: none; font-weight: none; margin-right:10px"
					id = "noticeEditBtn">
					<i class="fas fa-pencil-alt"></i>&nbsp; Edit
			</button>
		</form>
		
		
	</main>
		</div>
		<jsp:include page="/mark/markBottom.jsp"></jsp:include>
</body>
</html>