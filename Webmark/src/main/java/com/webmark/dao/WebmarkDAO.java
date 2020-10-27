package com.webmark.dao;

import java.util.HashMap;
import java.util.List;

import com.webmark.model.AccountVO;
import com.webmark.model.CategoryVO;
import com.webmark.model.NoticePagingVO;
import com.webmark.model.NoticeVO;
import com.webmark.model.SearchUrlVO;
import com.webmark.model.UrlVO;

public interface WebmarkDAO {
	
	// 로그인 관련
	public AccountVO loginById (AccountVO vo);
	public AccountVO loginByEmail (AccountVO vo);
	
	// 카테고리, URL 조회 관련
	public String categoryCheckId (long cat_no);
	
	public List<CategoryVO> getCategoryList (String userid);
	public List<UrlVO> getUrlList (long cat_no);
	public List<SearchUrlVO> searchUrl(String userid, String urlname);
	
	// 카테고리 편집 관련
	public Integer checkCategoryName(String userid, String cat_name);
	public Integer addCategory(String userid, String cat_name);
	
	public void deleteCategory (long cat_no);
	
	// URL 편집 관련
	public Integer checkUrlName(long cat_no, String url_name);
	
	public Integer addUrl(long cat_no, UrlVO vo);
	public Integer editUrl(long cat_no, UrlVO vo);
	
	public Integer deleteUrl(long url_num);
	
	// 공지 게시판 리스트 조회 및 페이징 관련
	public List<NoticeVO> getNoticePagingList(NoticePagingVO vo);
	public HashMap<String, Object> getNoticePagingListCnt (NoticePagingVO vo);
	
	public List<NoticeVO> getSearchNoticeByNamePaging (NoticePagingVO vo, String searchName);
	public List<NoticeVO> getSearchNoticeByTitlePaging (NoticePagingVO vo, String searchName);
	
	public HashMap<String, Object> getSearchNoticeByNamePagingCnt(NoticePagingVO paging, String searchName);
	public HashMap<String, Object> getSearchNoticeByTitlePagingCnt(NoticePagingVO paging, String searchName);
	
	// 공지 게시판 글 상세조회 및 편집 관련
	public NoticeVO getNoticeContents (long notice_num);
	public Integer insertNotice (NoticeVO vo);
	public Integer insertNoticeWithAttach (NoticeVO vo);
	public Integer editNotice (NoticeVO vo);
	public Integer deleteNotice (long notice_num);
	
}
