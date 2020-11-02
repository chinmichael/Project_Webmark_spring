package com.webmark.logic;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webmark.dao.WebmarkDAO;
import com.webmark.model.CommPagingVO;
import com.webmark.model.NoticePagingVO;

@Service
public class NoticePaging extends PagingMap {
	
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

	public HashMap<String, Object> getSearchCnt(CommPagingVO vo) {
		NoticePagingVO tc = (NoticePagingVO) vo;
		
		HashMap<String, Object> searchNoticePagingCnt = new HashMap<String, Object>();
		Long totalPage;
		if(tc.isSearchType()) {
			totalPage = dao.getSearchNoticeByTitlePagingCnt(tc);
		} else {
			totalPage = dao.getSearchNoticeByNamePagingCnt(tc);
		}
		if(totalPage == null) totalPage = (long) 0;
		vo.setTotalPage(totalPage);
		searchNoticePagingCnt.put("totalPage", totalPage); // 참고한 블로거가 이걸 도대체 왜 한거지...
		
		return searchNoticePagingCnt;
	}

}
