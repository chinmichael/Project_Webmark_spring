<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body>
	<jsp:include page="/mark/markNav.jsp"></jsp:include>
	<main class="col bg-faded py-3 flex-grow-1">
	
	<%--notice contents --%>

		<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Title</th>
						<th scope="col">Writer</th>
						<th scope="col">Date</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var = "pagingList" items = "${pagingList }">
					<tr>
						<th scope="row" style="color: gray;">${pagingList.getNotice_num() }</th>
						<td>
						<c:choose>
							<c:when test="${empty searchName }">
								<a href = "/Webmark/notice/noticeContents.html?noticeNum=${pagingList.getNotice_num()}&currentPage=${currentPage}">
							</c:when>
							<c:otherwise>
								<a href = "/Webmark/notice/noticeContents.html?noticeNum=${pagingList.getNotice_num()}&currentPage=${currentPage}&searchName=${searchName}&searchType=${searchType}">
							</c:otherwise>
						</c:choose>
						${pagingList.getNotice_title() }</a></td>
						<td>${pagingList.getUserid() }</td>
						<td>${pagingList.getWrite_date() }</td>
					</tr>
					</c:forEach>
					
				</tbody>
			</table>
			
		
		<%--notice add only by admin --%>
		
		<c:if test = "${account.getUsertype() == '1' }">
			<hr>
			<button type="button" class="btn btn-light btn-lg btn-block btn-sm"
				style="border-radius: 10px; box-shadow: none;"
				onclick="location.href='/Webmark/mark/noticeWrite.jsp'">
				<i class="fas fa-plus"></i>
			</button>
			
		</c:if>
		<hr>
		</div>
		
		<div>
			<form class="form-inline my-0 my-lg-0 justify-content-end" method="post"
			action="/Webmark/notice/noticeSearch.html">

				<div class="form-group mx-sm-0 mb-2">
					<select class="custom-select mr-sm-0" id="searchType"
					name = "searchType"
						style="height: calc(1.5em + 0.75rem - 1.2px); box-shadow: none; font-size: 10pt;">
						<option value="1" selected>Title</option>
						<option value="2">Writer</option>
					</select>
				</div>
				&nbsp;
				<div class="form-group mb-2">
					<input class="form-control ml-sm-0" type="text" name="searchName"
						placeholder="Search"
						style="height: calc(1.5em + 0.75rem - 5px); box-shadow: none;">
				</div>
				&nbsp;
				<div class="form-group mx-sm-0 mb-2">
					<button class="btn btn-outline-secondary "
						type="submit"
						style="height: calc(1.5em + 0.75rem - 5px); line-height: 0; box-shadow: none;">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</form>
		</div>

		<%--notice paging --%>
		
		<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center mt-3 mb-4">
			
			<%-- 그냥 공지 띄우기의 페이징 --%>
			<c:choose>
				<c:when test="${empty searchName }">
				
					<c:if test="${resMap.pageGroup > 1 }">
						<li class="page-item"><a class="page-link"
							aria-label="Previous" style="color: gray; box-shadow: none;"
							href="javascript:fnGoPaging(<c:out value = '${resMap.prePage }'/>)">
								<span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>

					<c:forEach var="i" begin="${resMap.startPage }"
						end="${resMap.endPage > resMap.total ? resMap.total : resMap.endPage }"
						varStatus="status">
						<c:choose>
							<c:when test="${resMap.page eq i }">
								<li class="page-item"><a class="page-link"
									href="javascript:fnGoPaging(${i});"
									style="color: #585858; font-weight:bold; box-shadow: none;">${i }</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="javascript:fnGoPaging(${i});"
									style="color: gray; box-shadow: none;">${i }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:if test="${resMap.nextPage <= resMap.total }">
						<li class="page-item"><a class="page-link"
							href="javascript:fnGoPaging(<c:out value='${resMap.nextPage }'/>)"
						aria-label="Next"
							style="color: gray; box-shadow: none;"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
				</c:when>
				
				<%-- 검색 시 공지 띄우기의 페이징 --%>
				<c:otherwise> 
					<c:if test="${resMap.pageGroup > 1 }">
					<li class="page-item"><a class="page-link"
						aria-label="Previous" style = "color: gray; box-shadow: none;"
						href="javascript:fnGoSearchPaging(${resMap.prePage})">
						<%-- href="javascript:fnGoPaging(<c:out values = '${resMap.prePage }'/>)">--%>
							<span aria-hidden="true">&laquo;</span>
					</a></li>
				</c:if>
				
				<c:forEach var = "i" begin = "${resMap.startPage }" end = "${resMap.endPage > resMap.total ? resMap.total : resMap.endPage }" varStatus="status">
					<c:choose>
						<c:when test = "${resMap.page eq i }">
							<li class="page-item"><a class="page-link" href="javascript:fnGoSearchPaging(${i});" style = "color: #585858; font-weight:bold; box-shadow: none;">${i }</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link" href="javascript:fnGoSearchPaging(${i});" style = "color: gray; box-shadow: none;">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>

				<c:if test="${resMap.nextPage <= resMap.total }">
					<li class="page-item">
					<a class="page-link" href="javascript:fnGoSearchPaging(${resMap.nextPage})"
					<%-- <c:out value='${resMap.nextPage }'/>--%>
						aria-label="Next" style = "color: gray; box-shadow: none;"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</c:if>
				</c:otherwise>
			</c:choose>
		</ul>
			
		</nav>

	</main>
	</div>
	
	<form name="searchMove" action="/Webmark/notice/noticeSearch.html" method="post">
		<input type="hidden" name="page">
		<input type="hidden" name="searchName" value="${searchName }">
		<input type="hidden" name="searchType" value="${searchType }">
	</form>
	
	<script>
		function fnGoPaging(page){
			location.href = "/Webmark/notice/noticeList.html?page=" + page;
		}
		
		function fnGoSearchPaging(page){
			document.searchMove.page.value = page;
			document.searchMove.submit();
		}
	</script>
	<%@ include file="/mark/markBottom.jsp" %>
</body>
</html>