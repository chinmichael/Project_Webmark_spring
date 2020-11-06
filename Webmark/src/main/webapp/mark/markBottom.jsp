<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- footer & bootstrap js -->

<footer>
	<h4 align="center" style="font-size: 15pt;">© LemonCookie</h4>
</footer>
</div>

<script type="text/javascript">
	function searchUrlCheck(frm) {
		var check = frm.urlSearch.value;
		if(check == "" || check == null) {
			alert("Please input search word");
			return false;
		}
		return true;
	}

</script>

<c:if test = "${empty account }">
		<script type = "text/javascript">
			window.onload = function() {
				alert("There is no login information.");
				location.href="/Webmark/home/loginForm.html";
			};
		</script>
		
</c:if>

<c:if test="${not empty message }">
	<input type = "hidden" value = "${message }" id = "message">
	<script type="text/javascript">
		window.onload = function() {
			alert($("#message").val());
		};
	</script>
</c:if>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"
	src="/Webmark/resource/js/bootstrap.js"></script>
<script type="text/javascript"
	src="/Webmark/resource/js/maincheck.js"></script>
