package com.webmark.logic;

import java.util.List;

import com.webmark.model.CategoryVO;

public interface Category {
	
	public List<CategoryVO> getList(String userid);
	public Integer add (CategoryVO vo);
	public Integer delete (long cat_no);

}
