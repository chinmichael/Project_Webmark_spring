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
import com.webmark.model.AccountLoginVO;
import com.webmark.model.AccountPassVO;
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
	public ModelAndView login(@Valid @ModelAttribute AccountLoginVO user, BindingResult br, HttpSession session) {
		
		ModelAndView mav;
		
		if(br.hasErrors()) {
			mav = new ModelAndView("account/loginForm");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		
		AccountLoginVO login = account.login(user);
		if(login != null) {
			mav = new ModelAndView("redirect:/mark/markList.jsp");
			session.setAttribute("account", login);
			List<CategoryVO> list = category.getList(login.getUserid());
			session.setAttribute("categoryList", list);
			session.setMaxInactiveInterval(24*60*60);
			return mav;
			
		} else {
			mav = new ModelAndView("account/loginForm");
			mav.addObject(new AccountLoginVO());
			mav.addObject("loginError", user.getUserid());
			return mav;
		}
	}
	
	@RequestMapping(value="/account/logout.html")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView("account/loginForm");
		session.invalidate();
		mav.addObject(new AccountLoginVO());
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
			AccountLoginVO user = new AccountLoginVO();
			user.setUserid(reg.getUserid());
			user.setUserpw(pw);
			AccountLoginVO login = account.login(user);
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
		mav = new ModelAndView("redirect:/account/resetConfirmForm.jsp");
		mav.addObject("changePassMsg", "We sent password change address to your E-mail. Please confirm.");
		mail.sendPassMail(vo);
		
		return mav;
	}
	
	@RequestMapping(value="/account/resetForm")
	public ModelAndView resetForm (String key) {
		ModelAndView mav = null;
		Integer check = account.checkPassKeyTime(key);
		if(check != 1) {
			mav = new ModelAndView("redirect:/account/resetConfirmForm.jsp");
			mav.addObject("changePassMsg", "This url is not available.");
			return mav;
		}
		mav = new ModelAndView("account/resetPassForm");
		mav.addObject(new AccountPassVO());
		mav.addObject("key", key);
		return mav;
	}
	
	@RequestMapping(value="/account/changePass")
	public ModelAndView changePass (@Valid @ModelAttribute AccountPassVO vo, BindingResult br) {
		ModelAndView mav = new ModelAndView("account/resetPassForm");
		
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		if(account.checkKeyAndId(vo) != 1) {
			mav.addObject("idError", "error");
			return mav;
		}
		if(!vo.getUserpw().equals(vo.getConfirm())) {
			mav.getModel().putAll(br.getModel());
			mav.addObject("confirmError", "error");
			return mav;
		}
		mav = new ModelAndView("redirect:/account/resetConfirmForm.jsp");
		if(account.changePass(vo) != 1) {
			mav.addObject("changePassMsg", "Error has occured. Please contact the administrator.");
			return mav;
		}
		mav.addObject("changePassMsg", "Password change is complete. Please log-in with the changed password.");
		
		return mav;
	}
	
	@RequestMapping(value="/account/changeAccount.html")
	public ModelAndView changeAccount(@Valid @ModelAttribute AccountRegVO info, BindingResult br, HttpSession session) {
		ModelAndView mav = new ModelAndView("account/accountManage");
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		if(account.checkEmail(info) != 1) {
			mav.getModel().putAll(br.getModel());
			mav.addObject("duplicationMail", "error");
			return mav;
		}
		if(account.changeAccount(info) == 1) {
			mav.setViewName("redirect:/home/accountManage.html");
			mav.addObject("message", "Change Success");
			AccountVO login = account.getChangedInfo(info.getUserid());
			session.setAttribute("account", login);
			session.setMaxInactiveInterval(24*60*60);
		} else {
			mav.addObject("message", "Account Change Error");
		}
		return mav;
	}
	
	@RequestMapping(value="/account/dropAccount.html")
	public ModelAndView dropAccount(String userpw, HttpSession session) {
		ModelAndView mav = new ModelAndView("account/accountDrop");
		AccountVO login = (AccountVO)session.getAttribute("account");
		login.setUserpw(userpw);
		Integer result = account.deleteUser(login);
		
		if(result == 1) {
			mav.setViewName("redirect:/cover.jsp");
			session.invalidate();
		} else {
			mav.addObject("passError", "error");
		}
		return mav;
	}
	
	@RequestMapping(value="/account/permissionCheck.html")
	public ModelAndView permissionCheck(String userid) {
		ModelAndView mav = new ModelAndView("account/accountPermission");
		if(account.checkPermissionId(userid) == 1) {
			mav.addObject("upgradeId", userid);
		} else {
			mav.addObject("idError", userid);
		}
		return mav;
	}
	
	@RequestMapping(value="/account/permissionSet.html")
	public ModelAndView permissionSet (String upgradeId) {
		ModelAndView mav = new ModelAndView("redirect:/account/accountPermission.jsp");
		Integer result = account.changeRight(upgradeId);
		if(result == 1) {
			mav.addObject("message", "Change Success");
		} else {
			mav.addObject("message", "Change Error");
		}
		return mav;
	}
}
