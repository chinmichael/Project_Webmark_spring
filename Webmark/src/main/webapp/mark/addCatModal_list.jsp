<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="modal fade" id="addCategoryModal2" tabindex="-1"
		aria-labelledby="addCategoryModal2Label" aria-hidden="true" style = "text-align : left;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="addCategoryModal2Label">Adding
						Category</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" style="outline: none;">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form id = "AddCatFrm2" name="AddCatFrm2" method="post"
					action="/Webmark/WebmarkServlet?command=add_category">

					<div class="modal-body" style="height: 130px;">
						<label for="addCategoryName" class="col-form-label">Category
							Name:</label> <input type="text" class="form-control"
							id="addCategoryName2" name="addCategoryName">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							style="box-shadow: none;" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-success" id = "addCatBtn2"
							style="box-shadow: none;">Add</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>