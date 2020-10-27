package com.webmark.model;

public class NoticeVO {
	
	private long notice_num;
	private String userid;
	private String notice_title;
	private String notice_contents;
	private String write_date;
	private String notice_attach;
	
	
	public long getNotice_num() {
		return notice_num;
	}
	public void setNotice_num(long notice_num) {
		this.notice_num = notice_num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_contents() {
		return notice_contents;
	}
	public void setNotice_contents(String notice_contents) {
		this.notice_contents = notice_contents;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public String getNotice_attach() {
		return notice_attach;
	}
	public void setNotice_attach(String notice_attach) {
		this.notice_attach = notice_attach;
	}
	
	

}
