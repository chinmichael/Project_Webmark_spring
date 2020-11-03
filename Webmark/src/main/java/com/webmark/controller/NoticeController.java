package com.webmark.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.webmark.logic.Notice;
import com.webmark.logic.PagingMap;
import com.webmark.model.NoticePagingVO;
import com.webmark.model.NoticeVO;

@Controller
public class NoticeController {
	
	@Autowired
	Notice notice;
	
	@Autowired
	@Qualifier("noticePaging")
	private PagingMap paging;
	
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
		mav.addObject("currentPage", page);
		
		return mav;
	}
	
	@RequestMapping(value="/notice/noticeSearch.html")
	public ModelAndView noticeSearch (HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("mark/markNotice");
		
		String page = request.getParameter("page");
		if(page == null) {
			page = "1";
		}
		long initPage = Long.parseLong(page);
		String searchName = request.getParameter("searchName");
		Integer searchType = Integer.parseInt(request.getParameter("searchType"));

		
		NoticePagingVO vo = new NoticePagingVO();
		vo.setPage(initPage);
		vo.setSearchName(searchName);
		vo.setSearchType(searchType);
		
		List<NoticeVO> list = notice.getSearchPaging(vo);
		HashMap<String, Object> searchCnt = paging.getSearchCnt(vo);
		HashMap<String, Object> resMap = paging.getResMap(vo, searchCnt);
		
		mav.addObject("pagingList", list);
		mav.addObject("resMap", resMap);
		mav.addObject("searchName", searchName);
		mav.addObject("searchType", searchType);
		mav.addObject("currentPage", page);
		
		return mav;
	}
	
	@RequestMapping(value="/notice/noticeContents.html")
	public ModelAndView noticeContents (Long noticeNum, Long currentPage, String searchName, Integer searchType, String message) {
		ModelAndView mav = new ModelAndView("mark/noticeBoard");
		NoticeVO vo = notice.getContents(noticeNum);
		mav.addObject("noticeCon", vo);
		mav.addObject("currentPage", currentPage);
		
		if(searchName != null) {
			mav.addObject("searchName", searchName);
			mav.addObject("searchType", searchType);
		}
		
		if(message != null) {
			mav.addObject("message", message);
		}
		
		return mav;
	}
	
	@RequestMapping(value="/notice/noticeWrite.html")
	public ModelAndView noticeWrite(HttpServletRequest request) throws IOException {
		String uploadPath = "C:\\webmark\\upload\\notice";
		int size = 10 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
		
		NoticeVO vo = new NoticeVO();
		vo.setUserid(multi.getParameter("noticeWriter"));
		vo.setNotice_title(multi.getParameter("noticeTitle"));
		vo.setNotice_contents(multi.getParameter("noticeContents"));
		
		boolean flg = false;

		if (multi.getFilesystemName("noticeAttach") != null) {
			String attach = multi.getFilesystemName("noticeAttach");
			vo.setNotice_attach(attach);
			flg = true;
		}
		
		Integer result = notice.add(vo, flg);
		ModelAndView mav = new ModelAndView("redirect:/notice/noticeList.html");
		
		if(result != 1) {
			mav.addObject("message", "Input Error");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/notice/noticeEditReady.html")
	public ModelAndView noticeEditReady(Long noticeNum, Long page, String searchName, Integer searchType) {
		ModelAndView mav = new ModelAndView("mark/noticeEdit");
		
		mav.addObject("currentPage", page);
		if(searchName != null) {
			mav.addObject("searchName", searchName);
			mav.addObject("searchType", searchType);
		}
		NoticeVO vo = notice.getContents(noticeNum);
		mav.addObject("noticeCon", vo);
		
		return mav;
	}
	
	@RequestMapping(value="/notice/noticeEdit.html")
	public ModelAndView noticeEdit(HttpServletRequest request) throws IOException {		
		String uploadPath = "C:\\webmark\\upload\\notice";
		int size = 10 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
		
		NoticeVO vo = new NoticeVO();
		vo.setNotice_num(Long.parseLong(multi.getParameter("noticeNumEdit")));
		vo.setUserid(multi.getParameter("noticeWriterE"));
		vo.setNotice_title(multi.getParameter("noticeTitleE"));
		vo.setNotice_contents(multi.getParameter("noticeContentsE"));
		
		if(multi.getParameter("noticeAttachFlg").equals("true")) {
			if(multi.getParameter("noticeBeforeAttach") != null) {
				String savedPath = "C:\\webmark\\upload\\notice";
				String filename = multi.getParameter("noticeBeforeAttach");
				String path = savedPath.trim() + "//" + filename.trim();
				File file = new File(path);
				if(file.exists()) {
					file.delete();
				}
			}
			
			if(multi.getFilesystemName("noticeAttachE") != null) {
				String attach = multi.getFilesystemName("noticeAttachE");
				vo.setNotice_attach(attach);
			}
		} else {
			vo.setNotice_attach(multi.getParameter("noticeBeforeAttach"));
		}
		
		ModelAndView mav = new ModelAndView("redirect:/notice/noticeContents.html");
		
		if(!multi.getParameter("searchName").isEmpty()) {
			mav.addObject("searchName", multi.getParameter("searchName"));
			mav.addObject("searchType", multi.getParameter("searchType"));
		}
		mav.addObject("currentPage", multi.getParameter("currentPage"));
		Integer result = notice.edit(vo);
		if(result != 1) {
			mav.addObject("message", "Update Error");
		}
		
		mav.addObject("noticeNum", vo.getNotice_num());
		
		return mav;
	}
	
	@RequestMapping(value="/notice/noticeDel.html")
	public ModelAndView noticeDel(HttpServletRequest request) {
		ModelAndView mav = null;
		
		if(!request.getParameter("searchName").isEmpty()) {
			mav = new ModelAndView("redirect:/notice/noticeSearch.html");
			mav.addObject("searchName", request.getParameter("searchName"));
			mav.addObject("searchType", request.getParameter("searchType"));
		} else {
			mav = new ModelAndView("redirect:/notice/noticeList.html");
		}
		mav.addObject("page", request.getParameter("page"));
		
		notice.delete(Long.parseLong(request.getParameter("noticeNum")));
		
		return mav;
	}
}
