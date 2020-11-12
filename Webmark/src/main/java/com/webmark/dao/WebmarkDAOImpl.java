package com.webmark.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webmark.model.AccountLoginVO;
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
	public AccountLoginVO getLogin(String userid) {
		return session.selectOne(mn + "getLogin", userid);
	}
	
	public String findPass (String userid) {
		return session.selectOne(mn + "findPass", userid);
	}
	
	public String findSalt (String userid) {
		return session.selectOne(mn + "findSalt", userid);
	}
	
	public void loginTime (String userid) {
		session.update(mn + "loginTime", userid);
	}

	// 회원등록, 회원정보 변경 관련
	public String checkId(String userid) {
		return session.selectOne(mn + "checkId", userid);
	}

	public String checkEmail(String email) {
		return session.selectOne(mn + "checkEmail", email);
	}

	public Integer joinAccount(AccountVO vo) {
		return session.insert(mn + "joinAccount", vo);
	}
	
	public Integer addSalt(AccountVO vo) {
		return session.insert(mn + "addSalt", vo);
	}

	public Integer changeAccountInfo(AccountVO vo) {
		return session.update(mn + "changeAccountInfo", vo);
	}
	
	public String checkPermissionId(String userid) {
		return session.selectOne(mn + "checkPermissionId", userid);
	}
	
	public Integer changeToAdmin(String userid) {
		return session.update(mn + "changeToAdmin", userid);
	}

	public Integer deleteAccount(String userid) {
		return session.delete(mn + "deleteAccount", userid);
	}
	
	// 비밀번호 찾기 및 변경
	
	public Integer readyChangePass(AccountVO vo) {
		return session.update(mn + "readyChangePass", vo);
	}
	
	public String checkKeyTime(String key) {
		return session.selectOne(mn + "checkKeyTime", key);
	}

	public String checkPassKey(AccountVO vo) {
		return session.selectOne(mn + "checkPassKey", vo);
	}

	public Integer changePass(AccountVO vo) {
		return session.update(mn + "changePass", vo);
	}

	public Integer changeSalt(AccountVO vo) {
		return session.update(mn + "changeSalt", vo);
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
	
	// 기타
	public Integer countCategory(String userid) {
		return session.selectOne(mn + "countCategory", userid);
	}

	public Integer countUrl(String userid) {
		return session.selectOne(mn + "countUrl", userid);
	}

}
