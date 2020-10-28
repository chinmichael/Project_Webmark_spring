package com.webmark.logic;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webmark.dao.WebmarkDAO;
import com.webmark.model.CategoryVO;

@Service
public class CategoryImpl implements Category {
	
	@Autowired
	private WebmarkDAO dao;
	
	public List<CategoryVO> getList(String userid) {
		List<CategoryVO> list = new Vector<CategoryVO>();
		list = dao.getCategoryList(userid);
		return list;
	}

	public Integer add(CategoryVO vo) {
		Long check = dao.checkCategoryName(vo);
		Integer result = 0;
		if(check == null) { // 중복 이름이 없음 null 반환
			result = dao.addCategory(vo); // 삽입이 되면 1 반환
		}
		return result;
	}

	public Integer delete(long cat_no) {
		return dao.deleteCategory(cat_no);
	}
	
}
