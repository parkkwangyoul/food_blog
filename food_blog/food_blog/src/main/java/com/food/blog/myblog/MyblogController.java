package com.food.blog.myblog;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.food.blog.login.UserInfo;

@Controller
public class MyblogController {
	
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public ModelAndView loginSubmit(HttpSession session, @ModelAttribute UserInfo userInfo) {
		ModelAndView mav = new ModelAndView();
		
		System.out.println(session.getAttribute("blogAddress"));
		

		mav.setViewName("blog/blog");

		return mav;
	}
	@RequestMapping(value = "/blog", method = RequestMethod.POST)
	public ModelAndView goBlog( HttpServletRequest request, UserInfo userInfo){
		ModelAndView mav = new ModelAndView();
		
		System.out.println(userInfo);
		

		mav.setViewName("blog/blog");
		return mav;
	}
	
	/*
	@RequestMapping(value = "/blog/{userId}", method = RequestMethod.POST)
	public ModelAndView goBlog( HttpServletRequest request, UserInfo userInfo, @PathVariable String userId){
		ModelAndView mav = new ModelAndView();
		
		System.out.println(userInfo);
		

		mav.setViewName("blog/blog");
		return mav;
	}*/
	private UserInfo getSession(HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		
		return userInfo;
	}
}
