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

		if (getUserBlogInfo.getBlogAddress() != null) {
			mav.addObject("blogInfo", getUserBlogInfo);
			mav.addObject("categoryList", myblogService.getUserCategory(userInfo));
			
			mav.setViewName("blog/blog");
		} else {
			session.setAttribute("userBlogInfo", getUserBlogInfo);
			mav.setView(new RedirectView("/food_blog/"));
		}
		return mav;
	}

	@RequestMapping(value = "/{blogAddress}", method = RequestMethod.POST)
	public ModelAndView goBlogByBlogAddressPost(HttpSession session,
			HttpServletRequest request, UserInfo userInfo,
			@PathVariable String blogAddress) {
		
		ModelAndView mav = new ModelAndView();
		userInfo = getSession(session);
		UserBlogInfo getUserBlogInfo = myblogService.getBlog(blogAddress);

		if (getUserBlogInfo.getBlogAddress() != null) {
			mav.addObject("blogInfo", getUserBlogInfo);
			mav.addObject("categoryList", myblogService.getUserCategory(userInfo));
			
			mav.setViewName("blog/blog");
		} else {
			session.setAttribute("userBlogInfo", getUserBlogInfo);
			mav.setView(new RedirectView("/food_blog/"));
		}
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

		mav.addObject("categoryList", myblogService.getUserCategory(userInfo));
		mav.addObject("contentList",
				myblogService.getContentList(categoryId, detailId, blogAddress));
		mav.addObject("blogInfo", getUserBlogInfo);

		mav.setViewName("blog/blog");

		return mav;
	}

	private UserInfo getSession(HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

		return userInfo;
	}
}
