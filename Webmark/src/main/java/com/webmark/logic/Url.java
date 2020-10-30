package com.webmark.logic;

import java.util.List;

import com.webmark.model.SearchUrlVO;
import com.webmark.model.UrlVO;

public interface Url {
	
	public Integer checkId (String userid, long cat_no);
	public List<UrlVO> getList (long cat_no);
	public List<SearchUrlVO> search (SearchUrlVO vo);
	public Integer add(UrlVO vo);
	public Integer edit(UrlVO vo);
	public Integer delete(long url_num);
	
}
