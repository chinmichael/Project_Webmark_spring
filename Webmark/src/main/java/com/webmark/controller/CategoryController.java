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
import com.webmark.model.AccountLoginVO;
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
		
		AccountLoginVO user = (AccountLoginVO) session.getAttribute("account");
		String cat_name = request.getParameter("addCategoryName");
		
		CategoryVO vo = new CategoryVO();
		vo.setUserid(user.getUserid());
		vo.setCat_name(cat_name);
		
		Long result = category.add(vo);
		if(result != -1) {
			mav = new ModelAndView("redirect:/url/urlList.html");
			session.removeAttribute("categoryList");
			List<CategoryVO> list = category.getList(user.getUserid());
			session.setAttribute("categoryList", list);
			mav.addObject("cat_no", result);
			
		} else {
			mav = new ModelAndView("mark/markList");
			mav.addObject("message", "This category name is not available.");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/category/delCategory.html")
	public ModelAndView delCategory(HttpSession session, Long delCategoryGroup) {
		ModelAndView mav = new ModelAndView("redirect:/mark/markList.jsp");
		Integer result = category.delete(delCategoryGroup);
		if(result != 1) {
			mav.addObject("message", "Delete Error");
		} 
		
		session.removeAttribute("categoryList");
		AccountLoginVO user = (AccountLoginVO) session.getAttribute("account");
		List<CategoryVO> list = category.getList(user.getUserid());
		session.setAttribute("categoryList", list);
		
		return mav;
	}
}
