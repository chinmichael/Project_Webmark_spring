package com.webmark.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webmark.dao.WebmarkDAO;
import com.webmark.model.NoticePagingVO;
import com.webmark.model.NoticeVO;

@Service
public class NoticeImpl implements Notice {
	
	@Autowired
	private WebmarkDAO dao;
	
	public List<NoticeVO> getPagingList(NoticePagingVO vo) {
		List<NoticeVO> list = new Vector<NoticeVO>();
		list = dao.getNoticePagingList(vo);
		return list;
	}

	public HashMap<String, Object> getPagingCnt(NoticePagingVO vo) {
		HashMap<String, Object> noticePagingListCnt = new HashMap<String, Object>();
		Long totalPage = dao.getNoticePagingListCnt(vo);
		if(totalPage == null) totalPage = (long) 0;
		vo.setTotalPage(totalPage);
		noticePagingListCnt.put("totalPage", totalPage); // 참고한 블로거가 이걸 도대체 왜 한거지...
		return noticePagingListCnt;
	}

	public List<NoticeVO> getSearchPaging(NoticePagingVO vo, boolean searchType) {
		List<NoticeVO> list = new Vector<NoticeVO>();
		if(searchType) {
			list = dao.getSearchNoticeByTitlePaging(vo);
		} else {
			list = dao.getSearchNoticeByNamePaging(vo);
		}
		return list;
	}

	public HashMap<String, Object> getSearchCnt(NoticePagingVO vo, boolean searchType) {
		HashMap<String, Object> searchNoticePagingCnt = new HashMap<String, Object>();
		Long totalPage;
		if(searchType) {
			totalPage = dao.getSearchNoticeByTitlePagingCnt(vo);
		} else {
			totalPage = dao.getSearchNoticeByNamePagingCnt(vo);
		}
		if(totalPage == null) totalPage = (long) 0;
		vo.setTotalPage(totalPage);
		searchNoticePagingCnt.put("totalPage", totalPage); // 참고한 블로거가 이걸 도대체 왜 한거지...
		
		return searchNoticePagingCnt;
	}

	public NoticeVO getContents(long notice_num) {
		return dao.getNoticeContents(notice_num);
	}

	public Integer add(NoticeVO vo) {
		Integer result = 0;
		if(vo.getNotice_attach() == null || vo.getNotice_attach().isEmpty()) {
			result = dao.addNotice(vo);
		} else {
			result = dao.addNoticeWithAttach(vo);
		}
		return result;
	}

	public Integer edit(NoticeVO vo) {
		return dao.editNotice(vo); //작성자 확인 어디서 할까 고민하다 그냥 컨트롤러에서 하지머
	}

	public Integer delete(long notice_num) {
		return dao.deleteNotice(notice_num); //작성자 확인 어디서 할까 고민하다 그냥 컨트롤러에서 하지머
	}

}
