package com.webmark.logic;

import java.util.HashMap;
import java.util.List;

import com.webmark.model.NoticePagingVO;
import com.webmark.model.NoticeVO;

public interface Notice {
	
	public List<NoticeVO> getPagingList (NoticePagingVO vo);
	public HashMap<String, Object> getPagingCnt (NoticePagingVO vo);
	
	public List<NoticeVO> getSearchPaging (NoticePagingVO vo, boolean searchType);
	public HashMap<String, Object> getSearchCnt(NoticePagingVO vo, boolean searchType);
	
	public NoticeVO getContents (long notice_num);
	public Integer add(NoticeVO vo);
	public Integer edit(NoticeVO vo);
	public Integer delete(long notice_num);
}
