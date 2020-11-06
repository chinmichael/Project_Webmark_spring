package com.webmark.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webmark.model.AccountRegVO;
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
	public AccountVO getLogin(String userid) {
		return session.selectOne(mn + "getLogin", userid);
	}
	
	public String findPass (String userid) {
		return session.selectOne(mn + "findPass", userid);
	}
	
	public String findSalt (String userid) {
		return session.selectOne(mn + "findSalt", userid);
	}

	// 회원등록, 회원정보 변경 관련
	public String checkId(String userid) {
		return session.selectOne(mn + "checkId", userid);
	}

	public String checkEmail(String email) {
		return session.selectOne(mn + "checkEmail", email);
	}

	public Integer joinAccount(AccountRegVO vo) {
		return session.insert(mn + "joinAccount", vo);
	}
	
	public Integer addSalt(AccountRegVO vo) {
		return session.insert(mn + "addSalt", vo);
	}

	public Integer changeAccountInfo(AccountRegVO vo) {
		return session.update(mn + "changeAccountInfo", vo);
	}

	public Integer changeToAdmin(String userid) {
		return session.update(mn + "changeToAdmin", userid);
	}

	public Integer deleteAccount(String userid) {
		return session.delete(mn + "deleteAccount", userid);
	}

	// 카테고리, URL 조회 관련
	public List<CategoryVO> getCategoryList(String userid) {
		return session.selectList(mn + "getCategoryList", userid);
	}
	
	public String categoryCheckId(long cat_no) {
		return session.selectOne(mn + "categoryCheckId", cat_no);
	}

	public List<UrlVO> getUrlList(long cat_no) {
		return session.selectList(mn + "getUrlList", cat_no);
	}

	public List<SearchUrlVO> searchUrl(SearchUrlVO vo) {
		return session.selectList(mn + "searchUrl", vo);
	}
	
	// 카테고리 편집 관련
	public Long checkCategoryName(CategoryVO vo) {
		return session.selectOne(mn + "checkCategoryName", vo);
	}

	public Integer addCategory(CategoryVO vo) {
		return session.insert(mn + "addCategory", vo); // 성공시 1 반환
	}

	public Integer deleteCategory(long cat_no) {
		return session.delete(mn + "deleteCategory", cat_no);
	}
	
	// URL 편집 관련
	public Long checkUrlName(UrlVO vo) {
		return session.selectOne(mn + "checkUrlName", vo);
	}

	public Integer addUrl(UrlVO vo) {
		return session.insert(mn + "addUrl", vo);
	}

	public Integer editUrl(UrlVO vo) {
		return session.update(mn + "editUrl", vo);
	}

	public Integer deleteUrl(long url_num) {
		return session.delete(mn + "deleteUrl", url_num);
	}
	
	// 공지 게시판 리스트 조회 및 페이징 관련
	public List<NoticeVO> getNoticePagingList(NoticePagingVO vo) {
		return session.selectList(mn + "getNoticePagingList", vo);
	}

	public Long getNoticePagingListCnt(NoticePagingVO vo) {
		return session.selectOne(mn + "getNoticePagingListCnt", vo);
	}

	public List<NoticeVO> getSearchNoticeByNamePaging(NoticePagingVO vo) {
		return session.selectList(mn + "getSearchNoticeByNamePaging", vo);
	}

	public List<NoticeVO> getSearchNoticeByTitlePaging(NoticePagingVO vo) {
		return session.selectList(mn + "getSearchNoticeByTitlePaging", vo);
	}

	public Long getSearchNoticeByNamePagingCnt(NoticePagingVO vo) {
		return session.selectOne(mn + "getSearchNoticeByNamePagingCnt", vo);
	}

	public Long getSearchNoticeByTitlePagingCnt(NoticePagingVO vo) {
		return session.selectOne(mn + "getSearchNoticeByTitlePagingCnt", vo);
	}
	
	// 공지 게시판 글 상세조회 및 편집 관련
	public NoticeVO getNoticeContents(long notice_num) {
		return session.selectOne(mn + "getNoticeContents", notice_num);
	}

	public Integer addNotice(NoticeVO vo) {
		return session.insert(mn + "insertNotice", vo);
	}

	public Integer addNoticeWithAttach(NoticeVO vo) {
		return session.insert(mn + "insertNoticeWithAttach", vo);
	}

	public Integer editNotice(NoticeVO vo) {
		return session.update(mn + "editNotice", vo);
	}

	public Integer deleteNotice(long notice_num) {
		return session.delete(mn + "deleteNotice", notice_num);
	}

}
