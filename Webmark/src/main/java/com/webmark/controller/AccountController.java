package com.webmark.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webmark.logic.Account;
import com.webmark.logic.Category;
import com.webmark.model.AccountVO;
import com.webmark.model.CategoryVO;

@Controller
public class AccountController {

	@Autowired
	Account account;
	@Autowired
	Category category;
	
	@RequestMapping(value="/account/login.html")
	public ModelAndView login(@Valid @ModelAttribute AccountVO user, BindingResult br, HttpSession session) {
		
		ModelAndView mav;
		
		if(br.hasErrors()) {
			mav = new ModelAndView("account/loginForm");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		
		AccountVO login = account.login(user);
		if(login != null) {
			mav = new ModelAndView("redirect:/mark/markList.jsp");
			session.setAttribute("account", login);
			List<CategoryVO> list = category.getList(login.getUserid());
			session.setAttribute("categoryList", list);
			session.setMaxInactiveInterval(24*60*60);
			return mav;
			
		} else {
			mav = new ModelAndView("account/loginForm");
			mav.addObject(new AccountVO());
			mav.addObject("loginError", user.getUserid());
			return mav;
		}
	}
	
	@RequestMapping(value="/account/logout.html")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView("account/loginForm");
		session.invalidate();
		mav.addObject(new AccountVO());
		return mav;
	}
}
