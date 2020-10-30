package com.webmark.logic;

import java.util.HashMap;
import java.util.List;

import com.webmark.model.CommPagingVO;

public interface Paging {
	public HashMap<String, Object> getPagingCnt (CommPagingVO vo);
	public HashMap<String, Object> getSearchCnt(CommPagingVO vo, boolean searchType);
	public HashMap<String, Object> getResMap(CommPagingVO vo, HashMap<String, Object> listCnt);
}
