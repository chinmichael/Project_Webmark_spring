package com.webmark.dao;

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
	public List<SearchUrlVO> searchUrl(SearchUrlVO vo);
	
	// 카테고리 편집 관련
	public Long checkCategoryName(CategoryVO vo);
	public Integer addCategory(CategoryVO vo);
	
	public Integer deleteCategory (long cat_no);
	
	// URL 편집 관련
	public Long checkUrlName(UrlVO vo);
	
	public Integer addUrl(UrlVO vo);
	public Integer editUrl(UrlVO vo);
	
	public Integer deleteUrl(long url_num);
	
	// 공지 게시판 리스트 조회 및 페이징 관련
	public List<NoticeVO> getNoticePagingList(NoticePagingVO vo);
	public Long getNoticePagingListCnt (NoticePagingVO vo);
	
	public List<NoticeVO> getSearchNoticeByNamePaging (NoticePagingVO vo);
	public List<NoticeVO> getSearchNoticeByTitlePaging (NoticePagingVO vo);
	
	public Long getSearchNoticeByNamePagingCnt(NoticePagingVO paging);
	public Long getSearchNoticeByTitlePagingCnt(NoticePagingVO paging);
	
	// 공지 게시판 글 상세조회 및 편집 관련
	public NoticeVO getNoticeContents (long notice_num);
	public Integer addNotice (NoticeVO vo);
	public Integer addNoticeWithAttach (NoticeVO vo);
	public Integer editNotice (NoticeVO vo);
	public Integer deleteNotice (long notice_num);
	
}
