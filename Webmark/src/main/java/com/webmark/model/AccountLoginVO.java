package com.webmark.model;

import org.hibernate.validator.constraints.NotEmpty;

public class AccountLoginVO extends AccountVO {
	
	@NotEmpty(message="Please put in your ID")
	private String userid;
	@NotEmpty(message="Please put in your Password")
	private String userpw;
	
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
	
}
