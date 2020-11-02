package com.webmark.logic;

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
	

	public List<NoticeVO> getSearchPaging(NoticePagingVO vo) {
		List<NoticeVO> list = new Vector<NoticeVO>();
		if(vo.isSearchType()) {
			list = dao.getSearchNoticeByTitlePaging(vo);
		} else {
			list = dao.getSearchNoticeByNamePaging(vo);
		}
		return list;
	}

	public NoticeVO getContents(long notice_num) {
		return dao.getNoticeContents(notice_num);
	}

	public Integer add(NoticeVO vo, boolean flg) {
		Integer result = 0;
		if(flg) {
			result = dao.addNoticeWithAttach(vo);
		} else {
			result = dao.addNotice(vo);
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
