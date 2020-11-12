package com.webmark.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webmark.logic.Url;
import com.webmark.model.AccountLoginVO;
import com.webmark.model.SearchUrlVO;
import com.webmark.model.UrlVO;

@Controller
public class UrlController {
	
	@Autowired
	Url url;
	
	@RequestMapping(value="/url/urlList.html")
	public ModelAndView urlList (HttpSession session, long cat_no) {
		ModelAndView mav = new ModelAndView("mark/markList");
		
		AccountLoginVO account = (AccountLoginVO) session.getAttribute("account");
		String userid = account.getUserid();
		Integer check = url.checkId(userid, cat_no);
		
		if(check == 1) {
			List<UrlVO> list = url.getList(cat_no);
			mav.addObject("urlList", list);
			mav.addObject("cat_no", cat_no);	
		}
		return mav;
	}
	
	@RequestMapping(value="/url/searchUrl.html")
	public ModelAndView searchUrl (HttpSession session, String urlSearch) {
		ModelAndView mav = new ModelAndView("mark/markList");

		AccountLoginVO user = (AccountLoginVO) session.getAttribute("account");
		SearchUrlVO vo = new SearchUrlVO();
		vo.setUrl_name(urlSearch);
		vo.setUserid(user.getUserid());
		List<SearchUrlVO> list = url.search(vo);
		if(list.isEmpty()) {
			mav.addObject("message", "There is no search result");
		} else {
			mav.addObject("urlList", list);
		}

		return mav;
	}
	
	@RequestMapping(value="/url/addUrl.html")
	public ModelAndView addUrl (HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/url/urlList.html");
		String tag = request.getParameter("urlTag") == null ? "none" : request.getParameter("urlTag");
		long cat_no = Long.parseLong(request.getParameter("cat_no"));
		
		UrlVO vo = new UrlVO();
		vo.setUrl_address(request.getParameter("urlLink"));
		vo.setUrl_name(request.getParameter("urlName"));
		vo.setUrl_access(request.getParameter("AccessUrl"));
		vo.setTag(tag);
		vo.setCat_check(cat_no);
		vo.setCat_no(cat_no);
		
		Integer result = url.add(vo);
		if(result != 1) {
			mav = new ModelAndView("mark/markList");
			mav.addObject("message", "URL name is already in this category");
			List<UrlVO> list = url.getList(cat_no);
			mav.addObject("urlList", list);
		}
		mav.addObject("cat_no", cat_no);
		
		return mav;
	}
	
	@RequestMapping(value="/url/editUrl.html")
	public ModelAndView editUrl(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("redirect:/url/urlList.html");
		String tag = request.getParameter("urlTagE") == null ? "none" : request.getParameter("urlTagE");

		UrlVO vo = new UrlVO();
		vo.setUrl_num(Long.parseLong(request.getParameter("url_num")));
		vo.setUrl_address(request.getParameter("urlLinkE"));
		vo.setUrl_name(request.getParameter("urlNameE"));
		vo.setUrl_access(request.getParameter("accessUrlE"));
		vo.setTag(tag);
		vo.setCat_check(Long.parseLong(request.getParameter("categorySelectE")));
		vo.setCat_no(Long.parseLong(request.getParameter("cat_no")));
		
		Integer result = url.edit(vo);
		if(result != 1) {
			mav = new ModelAndView("mark/markList");
			mav.addObject("message", "This url name is already in category.");
			mav.addObject("cat_no", vo.getCat_no());
			List<UrlVO> list = url.getList(vo.getCat_no());
			mav.addObject("urlList", list);
			return mav;
		}
		mav.addObject("cat_no", vo.getCat_check());

		return mav;
	}
	
	@RequestMapping(value="/url/delUrl.html")
	public ModelAndView delUrl (Long url_num, Long cat_no) {
		ModelAndView mav = new ModelAndView("redirect:/url/urlList.html");
		Integer result = url.delete(url_num);
		if(result != 1) {
			mav = new ModelAndView("mark/markList");
			mav.addObject("message", "Delete Error");
			List<UrlVO> list = url.getList(cat_no);
			mav.addObject("urlList", list);
		}
		mav.addObject("cat_no", cat_no);
		
		return mav;
	}
	
	
}
