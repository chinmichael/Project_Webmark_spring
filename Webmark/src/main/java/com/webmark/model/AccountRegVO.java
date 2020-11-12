package com.webmark.model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class AccountRegVO extends AccountVO {
	
	@Pattern(regexp="[A-Za-z\\d]{5,20}$",
			message="Only 5~20 English lowercase letters and numbers are available")
	private String userid;
	@Pattern(regexp="(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$",
			message="Please use 8~16 English letters, numbers and special characters") // https://code.i-harness.com/ko-kr/q/12b269e
	private String userpw;
	@NotEmpty(message="Please check passowrd")
	private String confirm;
	@NotEmpty(message="Please input your name")
	private String username;
	@NotEmpty(message="Please input your nickname")
	private String usernick;
	@NotEmpty(message="Please input your e-mail")
	@Email(message="This e-mail form is not available")
	private String email;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsernick() {
		return usernick;
	}
	public void setUsernick(String usernick) {
		this.usernick = usernick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
