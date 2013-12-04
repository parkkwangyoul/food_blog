package com.food.blog.myblog.board;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.food.blog.login.UserInfo;
import com.food.blog.myblog.Content;

@Controller
public class BoardController {
	
	@Resource
	private BoardService boardService;
	
	/**
	 * 글 작성
	 */
	
	@RequestMapping(value = "/blog/write", method = RequestMethod.POST)
	public ModelAndView writeContent(HttpSession session, @ModelAttribute UserInfo userInfo, @ModelAttribute Content content) {
		ModelAndView mav = new ModelAndView();
		userInfo = getSession(session);
		content.setWriteUser(userInfo.getName());
		content.setBlogAddress(userInfo.getBlogAddress());
		
		System.out.println(content.toString());
		
		boardService.joinContent(content);
		
		mav.setView(new RedirectView("/food_blog/blog"));

		return mav;
	}
	
	/**
	 * write입장
	 */
	@RequestMapping(value = "/blog/write", method = RequestMethod.GET)
	public ModelAndView writeTest(HttpSession session, @ModelAttribute UserInfo userInfo, @ModelAttribute Content content) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("blog/write");

		return mav;
	}
	
	private UserInfo getSession(HttpSession session) {
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		
		return userInfo;
	}
}
