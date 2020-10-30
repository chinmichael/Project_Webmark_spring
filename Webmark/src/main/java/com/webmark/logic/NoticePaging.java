package com.webmark.logic;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webmark.dao.WebmarkDAO;
import com.webmark.model.CommPagingVO;
import com.webmark.model.NoticePagingVO;

@Service
public class NoticePaging implements Paging {
	
	@Autowired
	WebmarkDAO dao;

	public HashMap<String, Object> getPagingCnt(CommPagingVO vo) {
		NoticePagingVO tc = (NoticePagingVO) vo;
		HashMap<String, Object> noticePagingListCnt = new HashMap<String, Object>();
		try {
			Long totalPage = dao.getNoticePagingListCnt(tc);
			if(totalPage == null) totalPage = (long) 0;
			vo.setTotalPage(totalPage);
			noticePagingListCnt.put("totalPage", totalPage); // 참고한 블로거가 이걸 도대체 왜 한거지...
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return noticePagingListCnt;
	}

	public HashMap<String, Object> getSearchCnt(CommPagingVO vo, boolean searchType) {
		NoticePagingVO tc = (NoticePagingVO) vo;
		
		HashMap<String, Object> searchNoticePagingCnt = new HashMap<String, Object>();
		Long totalPage;
		if(searchType) {
			totalPage = dao.getSearchNoticeByTitlePagingCnt(tc);
		} else {
			totalPage = dao.getSearchNoticeByNamePagingCnt(tc);
		}
		if(totalPage == null) totalPage = (long) 0;
		vo.setTotalPage(totalPage);
		searchNoticePagingCnt.put("totalPage", totalPage); // 참고한 블로거가 이걸 도대체 왜 한거지...
		
		return searchNoticePagingCnt;
	}

	public HashMap<String, Object> getResMap(CommPagingVO vo, HashMap<String, Object> listCnt) {
		NoticePagingVO tc = (NoticePagingVO) vo;
		
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		
		resMap.put("total", listCnt.get("totalPage"));
		resMap.put("page", tc.getPage()); // 현재 페이지
		resMap.put("pageScale", tc.getPageScale()); // 한 페이지에 보여징 페이징 수
		
		int pageGroup = (int) Math.ceil((double)tc.getPage() / tc.getPageScale()); // 현재 페이징 그룹
		
		long startPage = (pageGroup - 1) * tc.getPageScale() + 1;
		tc.setStartPage(startPage);
		resMap.put("startPage", tc.getStartPage());
		
		long endPage = startPage + tc.getPageScale() - 1;
		tc.setEndPage(endPage);
		resMap.put("endPage", tc.getEndPage());
		
		long prePage = (pageGroup - 2) * tc.getPageScale() + 1;
		long nextPage = (pageGroup) * tc.getPageScale() + 1;
		
		resMap.put("nextPage", nextPage);
		resMap.put("prePage", prePage);
		resMap.put("pageGroup", pageGroup);
		
		return resMap;
	}

}
