
	<div class="modal fade" id="addURLModal" tabindex="-1"
		aria-labelledby="addURLModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="addURLModalLabel">Adding URL</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close" style="outline: none;">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form name="addUrlFrm" id = "addUrlFrm" method="post"
					action="/Webmark/url/addUrl.html">
					<input type="hidden" name="cat_no" value="${cat_no }">
					<div class="modal-body" style="height: 390px;">
						<div class="form-group">
							<label for="urlLink" class="col-form-label">URL Link :</label> <input
								type="text" class="form-control" id="urlLink" name="urlLink">
						</div>
						<div class="form-group">
							<label for="urlName" class="col-form-label">URL Name :</label> <input
								type="text" class="form-control" id="urlName" name="urlName">
						</div>
						<div class="form-group">
							<label for="urlTag" class="col-form-label">Tag (Divide by '#') :</label> <input type="text" class="form-control"
								id="urlTag" name="urlTag">
						</div>

						<div class="form-group" style="padding-top: 15px;">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<label class="input-group-text" for="AccessUrl">Permit
										accessing at community</label>
								</div>
								<select class="custom-select" id="AccessUrl" name="AccessUrl">
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
							style="box-shadow: none;" id ="addUrlBtn">Add</button>
					</div>
				</form>
			</div>
		</div>
	</div>
