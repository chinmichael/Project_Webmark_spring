<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>

	<jsp:include page="/mark/markNav.jsp"></jsp:include>

	<%-- content --%>
	<main class="col bg-faded py-3 flex-grow-1">

		<%-- main home --%>

		<c:choose>
			<c:when test="${empty cat_no && empty urlList}">
				<div class="jumbotron jumbotron-fluid" style = "text-align : center; margin-bottom : 100px;">
					<div class="container">
						<h1 class="display-4">Welcome to Webmark!!</h1>
						<br>
						<p class="lead">
							If you don't have any category, please start
							<a id="addCatModal2" href=#>'Add New Category'!</a>

							<%@ include file="/mark/addCatModal_list.jsp" %>
						</p>
					</div>
				</div>
			</c:when>
			
			<c:when test = "${empty cat_no && not empty urlList }">
				<jsp:include page="/mark/searchList.jsp" />
			</c:when>

			<%-- url list --%>
			<c:otherwise>
				<c:if test="${empty urlList }">
					<div class="jumbotron jumbotron-fluid" style = "text-align : center; margin-bottom : 100px;">
						<div class="container">
							<h1 class="display-4">This category is empty.</h1>
							<br>
							<p class="lead">
								Please click
								<a href=# data-toggle="modal" data-target="#addURLModal">'+' button</a>
								to create new URL list!!
							</p>
						</div>
					</div>
				</c:if>

				<ul class="list-group list-group-flush">
					<c:forEach var="urlL" items="${urlList }">

						<li class="list-group-item" style="line-height: 40px;"><a
							href="${urlL.url_address }" target="_blank">${urlL.url_name}</a>

							<%-- Button trigger modal --%>

							<button type="button" class="btn btn-light float-right"
								data-toggle="modal" style="box-shadow: none;"
								data-target="#trashUrlModal${urlL.url_num}">
								<i class="fas fa-trash"></i>
							</button>
							
							<%-- Modal --%>
							<%@ include file="/mark/deleteUrlModal.jsp" %>
							
							<%-- edit url --%>

							<button type="button" class="btn btn-light float-right"
								style="box-shadow: none; margin-right:5px;" data-toggle="modal"
								data-target="#editURLModal${urlL.url_num }">
								<i class="fas fa-edit"></i>
							</button>

							<%@ include file="/mark/editUrlModal.jsp" %>
							
							<%-- move url --%>

							<button type="button" class="btn btn-light float-right"
								style="box-shadow: none; margin-right:5px;"
								onclick="window.open('${urlL.url_address }')">
								<i class="fas fa-map-marker-alt"></i>
							</button></li>
					</c:forEach>

					<%-- add new url --%>

					<li class="list-group-item">
						<button type="button" class="btn btn-light btn-lg btn-block"
							style="border-radius: 10px; box-shadow: none;" id="addUModal">
							<i class="fas fa-plus"></i>
						</button>
						<%@ include file="/mark/addUrlModal.jsp" %>
					</li>
				</ul>
			</c:otherwise>
		</c:choose>

	</main>

	</div>

	<!-- /contents -->
	<%@ include file="/mark/markBottom.jsp" %>

</body>
</html>
