<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="modal fade" id="delCategoryModal" tabindex="-1"
		aria-labelledby="delCategoryModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="delCategoryModalLabel">Delete
						Category</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" style="outline: none;">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form id="DelCatFrm" name="DelCatFrm" method="post"
					action="/Webmark/WebmarkServlet?command=delete_category">
					<div class="modal-body" style="height: 70px;">

						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<label class="input-group-text" for="delCategoryGroup">Name</label>
							</div>
							<select class="custom-select" id="delCategoryGroup"
								name="delCategoryGroup">
								<option value="-1" selected>Choose...</option>
								<c:forEach var="categoryDel" items="${categoryList }">
									<option value="${categoryDel.cat_no }">${categoryDel.cat_name }</option>
								</c:forEach>
							</select>

						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							style="box-shadow: none;" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-danger"
							style="box-shadow: none;" id = "delCatBtn">Delete</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>