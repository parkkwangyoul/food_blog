package com.food.blog.myblog;

import java.util.List;

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
@RequestMapping(value = "/blog")
public class MyblogController {

	@Resource
	private MyblogService myblogService;

	/**
	 * 주소로 블로그 블러오기
	 */
	@RequestMapping(value = "/{blogAddress}", method = RequestMethod.GET)
	public ModelAndView goBlogByBlogAddress(HttpSession session,
			HttpServletRequest request, UserInfo userInfo,
			@PathVariable String blogAddress) {
		
		ModelAndView mav = new ModelAndView();
		userInfo = getSession(session);
		UserBlogInfo getUserBlogInfo = myblogService.getBlog(blogAddress);
		
		mav.addObject("blogInfo", getUserBlogInfo);
		mav.addObject("contentList",
				myblogService.getContentList(null, null, blogAddress));
		mav.addObject("categoryList", myblogService.getUserCategory(blogAddress));
		
		mav.setViewName("blog/blog");
		
		return mav;
	}

	@RequestMapping(value = "/{blogAddress}", method = RequestMethod.POST)
	public ModelAndView goBlogByBlogAddressPost(HttpSession session,
			HttpServletRequest request, UserInfo userInfo,
			@PathVariable String blogAddress) {
		
		ModelAndView mav = new ModelAndView();
		userInfo = getSession(session);
		UserBlogInfo getUserBlogInfo = myblogService.getBlog(blogAddress);
		
		mav.addObject("blogInfo", getUserBlogInfo);
		mav.addObject("contentList",
				myblogService.getContentList(null, null, blogAddress));
		mav.addObject("categoryList", myblogService.getUserCategory(blogAddress));
		
		mav.setViewName("blog/blog");
		return mav;
	}	
	
	@RequestMapping(value = "/{blogAddress}/{categoryId}", method = RequestMethod.GET)
	public ModelAndView blogCategory(HttpSession session,
			@ModelAttribute UserInfo userInfo,
			@PathVariable String blogAddress, @PathVariable String categoryId) {
		
		ModelAndView mav = new ModelAndView();
		userInfo = getSession(session);
		UserBlogInfo getUserBlogInfo = myblogService.getBlog(blogAddress);

		mav.addObject("categoryList", myblogService.getUserCategory(blogAddress));
		mav.addObject("contentList",
				myblogService.getContentList(categoryId, null, blogAddress));
		mav.addObject("blogInfo", getUserBlogInfo);
		
		mav.addObject("categoryId", categoryId);

		mav.setViewName("blog/blog");

		return mav;
	}

	@RequestMapping(value = "/{blogAddress}/{categoryId}/{detailId}", method = RequestMethod.GET)
	public ModelAndView blogCategoryDetail(HttpSession session,
			@ModelAttribute UserInfo userInfo,
			@PathVariable String blogAddress, @PathVariable String categoryId,
			@PathVariable String detailId) {
		
		ModelAndView mav = new ModelAndView();
		userInfo = getSession(session);
		UserBlogInfo getUserBlogInfo = myblogService.getBlog(blogAddress);

		mav.addObject("categoryList", myblogService.getUserCategory(blogAddress));
		mav.addObject("contentList",
				myblogService.getContentList(categoryId, detailId, blogAddress));
		mav.addObject("blogInfo", getUserBlogInfo);
		
		mav.addObject("categoryId", categoryId);
		mav.addObject("detailId", detailId);

		mav.setViewName("blog/blog");

		return mav;
	}

	private UserInfo getSession(HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

		return userInfo;
	}
}
