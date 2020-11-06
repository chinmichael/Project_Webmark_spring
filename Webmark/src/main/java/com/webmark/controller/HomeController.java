package com.webmark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webmark.model.AccountRegVO;
import com.webmark.model.AccountVO;

@Controller
public class HomeController {
	
	@RequestMapping(value="/home/loginForm.html")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("account/loginForm");
		mav.addObject(new AccountVO());
		return mav;
	}
	
	@RequestMapping(value="/home/joinForm.html")
	public ModelAndView joinForm() {
		ModelAndView mav = new ModelAndView("account/joinForm");
		mav.addObject(new AccountRegVO());
		return mav;
	}
	

}
