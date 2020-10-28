package com.webmark.model;

public class CommPagingVO {
	
	private long rows = 10; // 페이지에 보여질 게시글 수, 상속 받는 페이징에 따라 적절히 조절
	private long page = 1;
	private long totalPage;
	private long startPage = 1;
	private long endPage;
	private long pageScale = 5; // 한 페이지에 보여질 페이지 수, 상속 받는 페이징에 따라 적절히 조절
	
	
	public long getRows() {
		return rows;
	}
	public void setRows(long rows) {
		this.rows = rows;
	}
	public long getPage() {
		return page;
	}
	public void setPage(long page) {
		this.page = page;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public long getStartPage() {
		return startPage;
	}
	public void setStartPage(long startPage) {
		this.startPage = startPage;
	}
	public long getEndPage() {
		return endPage;
	}
	public void setEndPage(long endPage) {
		this.endPage = endPage;
	}
	public long getPageScale() {
		return pageScale;
	}
	public void setPageScale(long pageScale) {
		this.pageScale = pageScale;
	}
	
	
	
}
