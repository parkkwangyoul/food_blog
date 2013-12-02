package com.food.blog.myblog;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.food.blog.login.UserInfo;

@Controller
public class MyblogController {
	
	@Resource
	private MyblogService myblogService;
	
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public ModelAndView loginSubmit(HttpSession session, @ModelAttribute UserInfo userInfo) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("blog/blog");

		return mav;
	}
	@RequestMapping(value = "/blog", method = RequestMethod.POST)
	public ModelAndView goBlog(HttpSession session, HttpServletRequest request, @ModelAttribute  UserInfo userInfo){
		ModelAndView mav = new ModelAndView();
		userInfo = getSession(session);
		System.out.println("MyblogController::"+userInfo);
		
		

		mav.setViewName("blog/blog");
		return mav;
	}
	
	/**
	 * 주소로 블로그 블러오기
	 */
	@RequestMapping(value = "/blog/{blogAddress}", method = RequestMethod.GET)
	public ModelAndView goBlogByBlogAddress(HttpSession session, HttpServletRequest request, 
			UserInfo userInfo, @PathVariable String blogAddress){
		ModelAndView mav = new ModelAndView();
		System.out.println(blogAddress);
		UserBlogInfo getUserBlogInfo = myblogService.getBlog(blogAddress);
		
		if(getUserBlogInfo.getBlogAddress() != null)
		{
			System.out.println("Get BlogInfo Success!!");
			mav.setViewName("blog/blog");
		}
		else{
			System.out.println("Get Fail BlogInfo...");
			session.setAttribute("userBlogInfo", getUserBlogInfo);
			mav.setView(new RedirectView("/food_blog/"));
		}		
		return mav;
	}
	
	/**
	 * write부분 태스트용
	 */
	@RequestMapping(value = "/blog/write", method = RequestMethod.GET)
	public ModelAndView writeTest(HttpSession session, @ModelAttribute UserInfo userInfo) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("blog/write");

		return mav;
	}
	
	private UserInfo getSession(HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		
		return userInfo;
	}
}
