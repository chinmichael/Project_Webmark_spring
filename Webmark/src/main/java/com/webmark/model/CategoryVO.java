package com.webmark.model;

import java.io.Serializable;

public class CategoryVO implements Serializable {
	
	private static final long serialVersionUID = -3156305778921382511L;
	
	private long cat_no;
	private String cat_name;
	
	private String user_id;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public long getCat_no() {
		return cat_no;
	}
	public void setCat_no(long cat_no) {
		this.cat_no = cat_no;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

}
