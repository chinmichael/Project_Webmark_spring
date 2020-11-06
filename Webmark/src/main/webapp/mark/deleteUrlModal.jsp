<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="modal fade" id="trashUrlModal${urlL.url_num}" tabindex="-1"
	aria-labelledby="trashUrlModal${urlL.url_num}Label" aria-hidden="true">
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
				<button type="button" class="btn btn-secondary" data-dismiss="modal"
					style="box-shadow: none;">Close</button>
				<form name="delUrlFrm" method="post"
					action="/Webmark/url/delUrl.html">
					<input type="hidden" name="cat_no" value="${cat_no}"> <input
						type="hidden" name="url_num" value="${urlL.url_num}"> <input
						type="submit" class="btn btn-danger" style="box-shadow: none;"
						value="Delete">
				</form>
			</div>
		</div>
	</div>
</div>