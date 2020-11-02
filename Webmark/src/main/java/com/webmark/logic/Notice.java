package com.webmark.logic;

import java.util.List;

import com.webmark.model.NoticePagingVO;
import com.webmark.model.NoticeVO;

public interface Notice {
	
	public List<NoticeVO> getPagingList (NoticePagingVO vo);
	public List<NoticeVO> getSearchPaging (NoticePagingVO vo);
	
	public NoticeVO getContents (long notice_num);
	public Integer add(NoticeVO vo, boolean flg);
	public Integer edit(NoticeVO vo);
	public Integer delete(long notice_num);
}
