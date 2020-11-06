<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<ul class="list-group list-group-flush">
		<c:forEach var="urlL" items="${urlList }">

			<li class="list-group-item" style="line-height: 40px;"><a
				href="${urlL.url_address }" target="_blank">${urlL.url_name}</a> <%-- Button trigger modal --%>
				<a style = "color : #BDBDBD;" href = "/Webmark/url/urlList.html?cat_no=${urlL.cat_no }"> ${urlL.cat_name }</a>
				
				<button type="button" class="btn btn-light float-right"
					data-toggle="modal" style="box-shadow: none;"
					data-target="#trashUrlModal${urlL.url_num}">
					<i class="fas fa-trash"></i>
				</button>
				
				<%-- Modal --%>
				<div class="modal fade" id="trashUrlModal${urlL.url_num}"
					tabindex="-1" aria-labelledby="trashUrlModal${urlL.url_num}Label"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="trashUrlModal${urlL.url_num}Label">Caution</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close" style="outline: none;">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">Are you sure delete this URL?</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal" style="box-shadow: none;">Close</button>
								<form name="delUrlFrm" method="post"
									action="/Webmark/WebmarkServlet?command=delete_url">
									<input type="hidden" name="cat_no" value="${cat_no}"> <input
										type="hidden" name="url_num" value="${urlL.url_num}">
									<input type="submit" class="btn btn-danger"
										style="box-shadow: none;" value="Delete">
								</form>
							</div>
						</div>
					</div>
				</div>
				
				<%-- edit url --%>
				<button type="button" class="btn btn-light float-right"
					style="box-shadow: none; margin-right:5px;" data-toggle="modal"
					data-target="#editURLModal${urlL.url_num }">
					<i class="fas fa-edit"></i>
				</button>

				<div class="modal fade" id="editURLModal${urlL.url_num }"
					tabindex="-1" aria-labelledby="editURLModal${urlL.url_num }Label"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="editURLModal${urlL.url_num }Label">Editing
									URL</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close" style="outline: none;">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<form id="editUrlFrm" name="editUrlFrm" method="post"
								action="/Webmark/WebmarkServlet?command=edit_url">
								<input type="hidden" name="url_num" value="${urlL.url_num}">
								<input type="hidden" name="cat_no" value="${urlL.cat_no}">
								<div class="modal-body" style="height: 460px;">
									<div class="form-group">
										<label for="urlLinkE" class="col-form-label">URL Link
											:</label> <input type="text" class="form-control" id="urlLinkE"
											name="urlLinkE" onfocus="this.select()"
											value="${urlL.url_address }">
									</div>
									<div class="form-group">
										<label for="urlNameE" class="col-form-label">URL Name
											:</label> <input type="text" class="form-control" id="urlNameE"
											name="urlNameE" value="${urlL.url_name }">
									</div>
									<div class="form-group">
										<label for="urlTagE" class="col-form-label">Tag
											(Divide by '#', Maximum '5') :</label> <input type="text"
											class="form-control" id="urlTagE" name="urlTagE"
											value="${urlL.tag }">
									</div>

									<div class="form-group" style="padding-top: 15px;">
										<div class="input-group mb-3">
											<div class="input-group-prepend">
												<label class="input-group-text" for="categorySelectE">Category</label>
											</div>
											<select class="custom-select" id="categorySelectE"
												name="categorySelectE">
												<c:forEach var="categorySel" items="${categoryList }">
													<c:choose>
														<c:when test="${categorySel.cat_no == urlL.cat_no }">
															<option value="${categorySel.cat_no }" selected>${categorySel.cat_name }</option>
														</c:when>
														<c:otherwise>
															<option value="${categorySel.cat_no }">${categorySel.cat_name }</option>
														</c:otherwise>
													</c:choose>
												</c:forEach>
											</select>

										</div>
									</div>

									<div class="form-group" style="padding-top: 15px;">
										<div class="input-group mb-3">
											<div class="input-group-prepend">
												<label class="input-group-text" for="accessUrlE">Permit
													accessing at community</label>
											</div>
											<select class="custom-select" id="accessUrlE"
												name="accessUrlE">
												<option value="1" selected>Agree</option>
												<option value="0">Deny</option>
											</select>

										</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										style="box-shadow: none;" data-dismiss="modal">Close</button>
									<button type="button" class="btn btn-success"
										style="box-shadow: none;" id="editUrlBtn">Edit</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				
				<%-- move url --%>
				<button type="button" class="btn btn-light float-right"
					style="box-shadow: none; margin-right:5px;"
					onclick="window.open('${urlL.url_address }')">
					<i class="fas fa-map-marker-alt"></i>
				</button></li>
		</c:forEach>
	</ul>

</body>
</html>