function checkAll() {
			
			var userid = document.getElementById("user_id").value;
			var email = document.getElementById("e_mail").value;
			var username = document.getElementById("user_name").value;
			var userpw = document.getElementById("user_pw").value;
			var cfpw = document.getElementById("confirm_pw").value;

			if (!checkUserId(userid)) {
				return false;
			}
			if (!checkMail(email)) {
				return false;
			}
			if (!checkName(username)) {
				return false;
			}
			if (!checkPassWord(userid,userpw,cfpw)) {
				return false;
			}

			return true;
		}

		function checkUserId(user_id) {
			
			
			var idRegExp = /^[a-zA-Z0-9]{4,12}$/;
			
			if (!idRegExp.test(user_id)) {
				alert("아이디는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
				document.getElementById("user_id").value = "";
				document.getElementById("user_id").focus();
				return false;

			}
			return true;
		}
		function checkMail(e_mail) {
			var emailRegExp = /^[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}$/;

			if (!emailRegExp.test(e_mail)) {
				alert("이메일 형식이 올바르지않습니다!");
				document.getElementById("e_mail").value = "";
				document.getElementById("e_mail").focus();
				return false;
			}
			return true;
		}
		function checkName(user_name) {

			var nameRegExp = /^[가-힣]||^[a-zA-Z0-9]$/;
			if (!nameRegExp.test(user_name)) {
				alert("이름이 올바르지 않습니다");
				return false;
			}
			return true;
		}
		function checkPassWord(user_id, user_pw, confirm_pw) {

			var password1RegExp = /^[a-zA-Z0-9]{4,12}$/;
			if (!password1RegExp.test(user_pw)) {
				alert("비밀번호는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
				document.getElementById("user_pw").value = "";
				document.getElementById("user_pw").focus();
				return false;
			}
			if (user_pw != confirm_pw) {
				document.getElementById("user_pw").value = "";
				document.getElementById("confirm_pw").value = "";
				document.getElementById("user_pw").focus();
				return false;
			}
			if (user_id == user_pw) {
				alert("아이디와 비밀번호는 같을수 없습니다!");
				document.getElementById("user_pw").value = "";
				document.getElementById("confirm_pw").value = "";
				document.getElementById("confirm_pw").focus();
				return false;

			}
			return true;
		}

