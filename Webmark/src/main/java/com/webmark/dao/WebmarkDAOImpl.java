package com.webmark.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webmark.model.AccountVO;
import com.webmark.model.CategoryVO;
import com.webmark.model.NoticePagingVO;
import com.webmark.model.NoticeVO;
import com.webmark.model.SearchUrlVO;
import com.webmark.model.UrlVO;

@Repository
public class WebmarkDAOImpl implements WebmarkDAO {
	
	@Autowired
	private SqlSession session;
	private String mn = "com.webmark.mapper.webmarkMapper."; // mn = mapperName
	
	// 로그인 관련
	public AccountVO loginById(AccountVO vo) {
		return session.selectOne(mn + ".loginById", vo);
	}

	public AccountVO loginByEmail(AccountVO vo) {
		return session.selectOne(mn + ".loginByEmail", vo);
	}
	
	// 카테고리, URL 조회 관련
	public String categoryCheckId(long cat_no) {
		return null;
	}

	public List<CategoryVO> getCategoryList(String userid) {
		return null;
	}

	public List<UrlVO> getUrlList(long cat_no) {
		return null;
	}

	public List<SearchUrlVO> searchUrl(String userid, String urlname) {
		return null;
	}
	
	// 카테고리 편집 관련
	public Integer checkCategoryName(String userid, String cat_name) {
		return null;
	}

	public Integer addCategory(String userid, String cat_name) {
		return null;
	}

	public void deleteCategory(long cat_no) {
		
	}
	
	// URL 편집 관련
	public Integer checkUrlName(long cat_no, String url_name) {
		return null;
	}

	public Integer addUrl(long cat_no, UrlVO vo) {
		return null;
	}

	public Integer editUrl(long cat_no, UrlVO vo) {
		return null;
	}

	public Integer deleteUrl(long url_num) {
		return null;
	}
	
	// 공지 게시판 리스트 조회 및 페이징 관련
	public List<NoticeVO> getNoticePagingList(NoticePagingVO vo) {
		return null;
	}

	public HashMap<String, Object> getNoticePagingListCnt(NoticePagingVO vo) {
		return null;
	}

	public List<NoticeVO> getSearchNoticeByNamePaging(NoticePagingVO vo, String searchName) {
		return null;
	}

	public List<NoticeVO> getSearchNoticeByTitlePaging(NoticePagingVO vo, String searchName) {
		return null;
	}

	public HashMap<String, Object> getSearchNoticeByNamePagingCnt(NoticePagingVO paging, String searchName) {
		return null;
	}

	public HashMap<String, Object> getSearchNoticeByTitlePagingCnt(NoticePagingVO paging, String searchName) {
		return null;
	}
	
	// 공지 게시판 글 상세조회 및 편집 관련
	public NoticeVO getNoticeContents(long notice_num) {
		return null;
	}

	public Integer insertNotice(NoticeVO vo) {
		return null;
	}

	public Integer insertNoticeWithAttach(NoticeVO vo) {
		return null;
	}

	public Integer editNotice(NoticeVO vo) {
		return null;
	}

	public Integer deleteNotice(long notice_num) {
		return null;
	}

}
