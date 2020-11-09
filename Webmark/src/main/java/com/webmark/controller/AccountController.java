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
import com.webmark.logic.Mail;
import com.webmark.model.AccountRegVO;
import com.webmark.model.AccountVO;
import com.webmark.model.CategoryVO;
import com.webmark.model.PassMailVO;

@Controller
public class AccountController {

	@Autowired
	Account account;
	@Autowired
	Category category;
	@Autowired
	Mail mail;
	
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
	
	@RequestMapping(value="/account/join.html")
	public ModelAndView join (@Valid @ModelAttribute AccountRegVO reg, BindingResult br, HttpSession session) {
		ModelAndView mav = new ModelAndView("account/joinForm");
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		
		Integer overlayCheck = account.checkIdAndEmail(reg); // 0 = 중복 없음 , 1 = 아이디 중복, 2 = 메일 중복, 3 = 둘다 중복
		switch(overlayCheck) {
		case 1:
			mav.addObject("duplicationId", "error");
			mav.getModel().putAll(br.getModel());
			return mav;
		case 2:
			mav.addObject("duplicationMail", "error");
			mav.getModel().putAll(br.getModel());
			return mav;
		case 3:
			mav.addObject("duplicationId", "error");
			mav.addObject("duplicationMail", "error");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		
		if(!reg.getConfirm().equals(reg.getUserpw())) {
			mav.addObject("confirmError", "error");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		String pw = reg.getUserpw();
		Integer result = account.joinNewAccount(reg);
		if(result == 1) {
			mav = new ModelAndView("redirect:/mark/markList.jsp");
			AccountVO user = new AccountVO();
			user.setUserid(reg.getUserid());
			user.setUserpw(pw);
			AccountVO login = account.login(user);
			session.setAttribute("account", login);
			List<CategoryVO> list = category.getList(login.getUserid());
			session.setAttribute("categoryList", list);
			session.setMaxInactiveInterval(24*60*60);
			return mav;
			
		} else {
			mav.addObject("message", "Join Error occured");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
	}
	
	@RequestMapping(value="/account/findByMail")
	public ModelAndView findByMail (String email) {
		ModelAndView mav = new ModelAndView("account/sendFindMailForm");
		if(email.isEmpty()) {
			mav.addObject("mailError", "Please input your e-mail");
			return mav;
		}
		String result = account.readyFindMail(email);
		if(result.equals("0")) {
			mav.addObject("mailError", "This e-mail is not available");
			return mav;
		}
		PassMailVO vo = new PassMailVO();
		vo.setTo(email);
		vo.setSubject("Webmark 계정 재설정");
		vo.setContents(result);
		mav = new ModelAndView("cover");
		mail.sendPassMail(vo);
		
		return mav;
	}
	
	@RequestMapping(value="/account/resetForm")
	public ModelAndView resetForm (String key) {
		ModelAndView mav = new ModelAndView("account/resetPassForm");
		mav.addObject(new AccountRegVO());
		return mav;
	}
}
