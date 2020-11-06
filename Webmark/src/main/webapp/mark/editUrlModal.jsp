<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="modal fade" id="editURLModal${urlL.url_num }" tabindex="-1"
	aria-labelledby="editURLModal${urlL.url_num }Label" aria-hidden="true">
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
				onsubmit="editUrlCheck(this)"
				action="/Webmark/url/editUrl.html">
				<input type="hidden" name="url_num" value="${urlL.url_num}">
				<input type="hidden" name="cat_no" value="${cat_no}">
				<div class="modal-body" style="height: 460px;">
					<div class="form-group">
						<label for="urlLinkE" class="col-form-label">URL Link :</label> <input
							type="text" class="form-control" id="urlLinkE" name="urlLinkE"
							onfocus="this.select()" value="${urlL.url_address }">
					</div>
					<div class="form-group">
						<label for="urlNameE" class="col-form-label">URL Name :</label> <input
							type="text" class="form-control" id="urlNameE" name="urlNameE"
							value="${urlL.url_name }">
					</div>
					<div class="form-group">
						<label for="urlTagE" class="col-form-label">Tag (Divide by
							'#') :</label> <input type="text" class="form-control" id="urlTagE"
							name="urlTagE" value="${urlL.tag }">
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
										<c:when test="${categorySel.cat_no == cat_no }">
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
							<select class="custom-select" id="accessUrlE" name="accessUrlE">
								<option value="1" selected>Agree</option>
								<option value="0">Deny</option>
							</select>

						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						style="box-shadow: none;" data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-success"
						style="box-shadow: none;" id="editUrlBtn">Edit</button>
				</div>
			</form>
		</div>
	</div>
</div>

<script type="text/javascript">
	function editUrlCheck(frm) {

		var link = frm.urlLinkE.value;
		var name = frm.urlNameE.value;
		var tag = frm.urlTagE.value;

		if (link == '' || link == null) {
			alert("Please input url address");
			frm.urlLinkE.focus();

			return false;
		}
		if (name == '' || name == null) {
			alert("Please input url name");
			frm.urlNameE.focus();

			return false;
		}

	}
</script>