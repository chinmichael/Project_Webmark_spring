<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
	<div class="modal fade" id="addCategoryModal" tabindex="-1"
		aria-labelledby="addCategoryModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="addCategoryModalLabel">Adding
						Category</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" style="outline: none;">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form id="AddCatFrm" name="AddCatFrm" method="post"
					action="/Webmark/WebmarkServlet?command=add_category">
					<div class="modal-body" style="height: 130px;">
						<label for="addCategoryName" class="col-form-label">Category
							Name:</label> <input type="text" class="form-control"
							id="addCategoryName" name="addCategoryName">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							style="box-shadow: none;" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-success"
							style="box-shadow: none;" id="addCatBtn">Add</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>