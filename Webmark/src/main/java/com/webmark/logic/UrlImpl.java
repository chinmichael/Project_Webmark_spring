package com.webmark.logic;

import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webmark.dao.WebmarkDAO;
import com.webmark.model.SearchUrlVO;
import com.webmark.model.UrlVO;

@Service
public class UrlImpl implements Url {
	
	@Autowired
	private WebmarkDAO dao;
	
	public Integer checkId(String userid, long cat_no) {
		Integer result = 0;
		
		try {
			String check = dao.categoryCheckId(cat_no);
			
			if(userid.equals(check)) {
				result = 1;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<UrlVO> getList(long cat_no) {
		List<UrlVO> list = new Vector<UrlVO>();
		try {
			list = dao.getUrlList(cat_no);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<SearchUrlVO> search(SearchUrlVO vo) {
		String searchName = "%" + vo.getUrl_name() + "%";
		vo.setUrl_name(searchName);
		List<SearchUrlVO> list = new Vector<SearchUrlVO>();
		list = dao.searchUrl(vo);
		return list;
	}

	public Integer add(UrlVO vo) {
		Long check = dao.checkUrlName(vo);
		Integer result = 0;
		if(check == null) {
			result = dao.addUrl(vo);
		}
		return result;
	}

	public Integer edit(UrlVO vo) {
		Long check = dao.checkUrlName(vo);
		Integer result = 0;
		if(check == null) {
			result = dao.editUrl(vo);
		}
		return result;
	}

	public Integer delete(long url_num) {
		return dao.deleteUrl(url_num);
	}
}
