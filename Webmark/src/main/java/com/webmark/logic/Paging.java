package com.webmark.logic;

import java.util.HashMap;

import com.webmark.model.CommPagingVO;

abstract public class Paging {
	public abstract HashMap<String, Object> getPagingCnt (CommPagingVO vo);
	public abstract HashMap<String, Object> getSearchCnt(CommPagingVO vo, boolean searchType);
	
	public HashMap<String, Object> getResMap(CommPagingVO vo, HashMap<String, Object> listCnt) {
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		
		resMap.put("total", listCnt.get("totalPage"));
		resMap.put("page", vo.getPage()); // 현재 페이지
		resMap.put("pageScale", vo.getPageScale()); // 한 페이지에 보여징 페이징 수
		
		int pageGroup = (int) Math.ceil((double)vo.getPage() / vo.getPageScale()); // 현재 페이징 그룹
		
		long startPage = (pageGroup - 1) * vo.getPageScale() + 1;
		vo.setStartPage(startPage);
		resMap.put("startPage", vo.getStartPage());
		
		long endPage = startPage + vo.getPageScale() - 1;
		vo.setEndPage(endPage);
		resMap.put("endPage", vo.getEndPage());
		
		long prePage = (pageGroup - 2) * vo.getPageScale() + 1;
		long nextPage = (pageGroup) * vo.getPageScale() + 1;
		
		resMap.put("nextPage", nextPage);
		resMap.put("prePage", prePage);
		resMap.put("pageGroup", pageGroup);
		
		return resMap;
	}
}
