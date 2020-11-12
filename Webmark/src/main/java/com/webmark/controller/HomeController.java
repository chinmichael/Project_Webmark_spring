package com.webmark.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webmark.logic.Account;
import com.webmark.model.AccountLoginVO;
import com.webmark.model.AccountRegVO;

@Controller
public class HomeController {
	
	@Autowired
	Account account;
	
	@RequestMapping(value="/home/loginForm.html")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("account/loginForm");
		mav.addObject(new AccountLoginVO());
		return mav;
	}
	
	@RequestMapping(value="/home/joinForm.html")
	public ModelAndView joinForm() {
		ModelAndView mav = new ModelAndView("account/joinForm");
		mav.addObject(new AccountRegVO());
		return mav;
	}
	
	@RequestMapping(value="/home/accountHome.html")
	public ModelAndView accountHome(HttpSession session) {
		ModelAndView mav = new ModelAndView("account/accountHome");
		AccountLoginVO login = (AccountLoginVO) session.getAttribute("account");
		Integer[] result = account.countActivity(login.getUserid());
		mav.addObject("categoryCnt", result[0]);
		mav.addObject("bookmarkCnt", result[1]);
		return mav;
	}
	
	@RequestMapping(value="/home/accountManage.html")
	public ModelAndView accountManage(String message) {
		ModelAndView mav = new ModelAndView("account/accountManage");
		if(message != null) {
			mav.addObject("message", message);
		}
		mav.addObject(new AccountRegVO());
		return mav;
	}
	

}
