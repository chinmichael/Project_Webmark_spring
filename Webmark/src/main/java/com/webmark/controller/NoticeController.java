package com.webmark.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webmark.logic.Notice;
import com.webmark.logic.Paging;
import com.webmark.model.NoticePagingVO;
import com.webmark.model.NoticeVO;

@Controller
public class NoticeController {
	
	@Autowired
	Notice notice;
	
	@Autowired
	@Qualifier("noticePaging")
	private Paging paging;
	
	@RequestMapping(value="/notice/noticeList.html")
	public ModelAndView noticeList (Long page) {
		ModelAndView mav = new ModelAndView("mark/markNotice");
		if(page == null) {
			page = (long) 1;
		}
		long initPage = page;
		NoticePagingVO vo = new NoticePagingVO();
		vo.setPage(initPage);
		List<NoticeVO> list = notice.getPagingList(vo);
		HashMap<String, Object> pagingListCnt = paging.getPagingCnt(vo);
		HashMap<String, Object> resMap = paging.getResMap(vo, pagingListCnt);

		mav.addObject("pagingList", list);
		mav.addObject("resMap", resMap);

		return mav;
	}
}
