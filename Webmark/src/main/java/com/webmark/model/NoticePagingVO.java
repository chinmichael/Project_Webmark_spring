package com.webmark.model;

public class NoticePagingVO extends CommPagingVO {
	
	private String searchName; // 검색할 때, 페이징 처리가 동시에 이뤄져야 하므로
	

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = "%" + searchName + "%";
	}
	
}
