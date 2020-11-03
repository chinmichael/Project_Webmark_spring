package com.webmark.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webmark.logic.Category;
import com.webmark.logic.Url;
import com.webmark.model.AccountVO;
import com.webmark.model.CategoryVO;
import com.webmark.model.UrlVO;

@Controller
public class CategoryController {
	
	@Autowired
	Category category;
	@Autowired
	Url url;
	
	@RequestMapping(value="/category/addCategory.html")
	public ModelAndView addCategory(HttpSession session, HttpServletRequest request) {
		
		ModelAndView mav = null;
		
		AccountVO user = (AccountVO) session.getAttribute("account");
		String userid = user.getUserid();
		String cat_name = request.getParameter("addCategoryName");
		
		CategoryVO vo = new CategoryVO();
		vo.setUserid(userid);
		vo.setCat_name(cat_name);
		
		Long result = category.add(vo);
		if(result != -1) {
			mav = new ModelAndView("redirect:/url/urlList.html");
			session.removeAttribute("categoryList");
			List<CategoryVO> list = category.getList(userid);
			session.setAttribute("categoryList", list);
			mav.addObject("cat_no", result);
			
		} else {
			mav = new ModelAndView("mark/markList");
			mav.addObject("message", "This category name is not available.");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/category/delCategory.html")
	public ModelAndView delCategory(HttpSession session, HttpServletRequest request) {
		return null;
	}
}
