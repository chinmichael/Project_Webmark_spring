package com.webmark.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webmark.logic.Url;
import com.webmark.model.AccountVO;
import com.webmark.model.UrlVO;

@Controller
public class UrlController {
	
	@Autowired
	Url url;
	
	@RequestMapping(value="/url/urlList.html")
	public ModelAndView urlList (HttpSession session, long cat_no) {
		ModelAndView mav = new ModelAndView("mark/markList");
		
		AccountVO account = (AccountVO) session.getAttribute("account");
		String userid = account.getUserid();
		Integer check = url.checkId(userid, cat_no);
		
		if(check == 1) {
			List<UrlVO> list = url.getList(cat_no);
			mav.addObject("urlList", list);
			mav.addObject("cat_no", cat_no);	
		}
		return mav;
	}
}
