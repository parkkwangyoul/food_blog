package com.food.blog.myblog.board;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.food.blog.config.servlet.ResourceNotFoundException;
import com.food.blog.login.UserInfo;
import com.food.blog.myblog.Content;
import com.food.blog.myblog.ContentAttachment;
import com.food.blog.myblog.MyblogService;
import com.food.blog.myblog.UserBlogInfo;

@Controller
public class BoardController {

	@Resource
	private BoardService boardService;

	@Resource
	private MyblogService myblogService;

	@RequestMapping(value = "/blog/{blogAddress}/write", method = RequestMethod.POST)
	public ModelAndView writeContentPost(HttpSession session,
			@ModelAttribute UserInfo userInfo, @ModelAttribute Content content,
			@PathVariable String blogAddress) {
		ModelAndView mav = new ModelAndView();
		userInfo = getSession(session);
		content.setWriteUser(userInfo.getName());
		content.setBlogAddress(userInfo.getBlogAddress());
		
		UserBlogInfo getUserBlogInfo = myblogService.getBlog(blogAddress);

		mav.addObject("categoryList",
				myblogService.getUserCategory(blogAddress));
		
		mav.addObject("blogInfo", getUserBlogInfo);
		
		content.setBlogAddress(blogAddress);

		boardService.insertBoard(content);

		mav.setView(new RedirectView("/food_blog/blog/" + blogAddress));

		return mav;
	}

	@RequestMapping(value = "/blog/{blogAddress}/write", method = RequestMethod.GET)
	public ModelAndView writeContentGet(HttpSession session,
			@ModelAttribute UserInfo userInfo, @ModelAttribute Content content,
			@PathVariable String blogAddress) {
		ModelAndView mav = new ModelAndView();
		
		UserBlogInfo getUserBlogInfo = myblogService.getBlog(blogAddress);

		mav.addObject("categoryList",
				myblogService.getUserCategory(blogAddress));

		mav.addObject("blogInfo", getUserBlogInfo);

		mav.setViewName("blog/write");

		return mav;
	}

	@RequestMapping(value = "/blog/{blogAddress}/{categoryId}/write", method = RequestMethod.POST)
	public ModelAndView writeContentbByCategoryIdPost(HttpSession session,
			@ModelAttribute UserInfo userInfo, @ModelAttribute Content content,
			@PathVariable String blogAddress, @PathVariable String categoryId) {
		ModelAndView mav = new ModelAndView();
		userInfo = getSession(session);
		content.setWriteUser(userInfo.getName());
		content.setBlogAddress(userInfo.getBlogAddress());
		
		UserBlogInfo getUserBlogInfo = myblogService.getBlog(blogAddress);

		mav.addObject("categoryList",
				myblogService.getUserCategory(blogAddress));

		mav.addObject("blogInfo", getUserBlogInfo);

		mav.addObject("categoryId", categoryId);
		
		content.setBlogAddress(blogAddress);
		content.setCategoryId(categoryId);

		boardService.insertBoard(content);

		mav.setView(new RedirectView("/food_blog/blog/" + blogAddress + "/" + categoryId));

		return mav;
	}

	@RequestMapping(value = "/blog/{blogAddress}/{categoryId}/write", method = RequestMethod.GET)
	public ModelAndView writeConentByCateogryIdGet(HttpSession session,
			@ModelAttribute UserInfo userInfo, @ModelAttribute Content content,
			@PathVariable String blogAddress, @PathVariable String categoryId) {
		ModelAndView mav = new ModelAndView();
		
		UserBlogInfo getUserBlogInfo = myblogService.getBlog(blogAddress);		

		mav.addObject("blogInfo", getUserBlogInfo);

		mav.addObject("categoryList",
				myblogService.getUserCategory(blogAddress));

		mav.addObject("categoryId", categoryId);

		mav.setViewName("blog/write");

		return mav;
	}

	@RequestMapping(value = "/blog/{blogAddress}/{categoryId}/{detailId}/write", method = RequestMethod.POST)
	public ModelAndView writeContentbByDetailIdPost(HttpSession session,
			@ModelAttribute UserInfo userInfo, @ModelAttribute Content content,
			@PathVariable String blogAddress, @PathVariable String categoryId,
			@PathVariable String detailId) {
		ModelAndView mav = new ModelAndView();
		userInfo = getSession(session);
		content.setWriteUser(userInfo.getName());
		content.setBlogAddress(userInfo.getBlogAddress());
		
		UserBlogInfo getUserBlogInfo = myblogService.getBlog(blogAddress);		

		mav.addObject("blogInfo", getUserBlogInfo);

		mav.addObject("categoryList",
				myblogService.getUserCategory(blogAddress));

		mav.addObject("categoryId", categoryId);
		mav.addObject("detailId", detailId);
		
		content.setBlogAddress(blogAddress);
		content.setCategoryId(categoryId);
		content.setDetailId(Integer.parseInt(detailId));

		boardService.insertBoard(content);

		mav.setView(new RedirectView("/food_blog/blog/" + blogAddress + "/" + categoryId + "/" + detailId));

		return mav;
	}

	@RequestMapping(value = "/blog/{blogAddress}/{categoryId}/{detailId}/write", method = RequestMethod.GET)
	public ModelAndView writeConentByDetailIdGet(HttpSession session,
			@ModelAttribute UserInfo userInfo, @ModelAttribute Content content,
			@PathVariable String blogAddress, @PathVariable String categoryId,
			@PathVariable String detailId) {
		ModelAndView mav = new ModelAndView();
		
		UserBlogInfo getUserBlogInfo = myblogService.getBlog(blogAddress);
		
		mav.addObject("blogInfo", getUserBlogInfo);

		mav.addObject("categoryList",
				myblogService.getUserCategory(blogAddress));

		mav.addObject("categoryId", categoryId);
		mav.addObject("detailId", detailId);

		mav.setViewName("blog/write");

		return mav;
	}

	private UserInfo getSession(HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");

		return userInfo;
	}
	
	@Resource 
	DownloadView downloadView;
	
	@RequestMapping(value="/download/{seq}", method=RequestMethod.GET)
	public DownloadView showDownload(Model model, @PathVariable Integer seq) {		
		ContentAttachment attachment = boardService.getAttachment(seq);
		
		if (attachment == null || new File(attachment.getFilePath()).canRead() == false) throw new ResourceNotFoundException();
		
		model.addAttribute("attachment", attachment);
		
		return downloadView;
	}
}
