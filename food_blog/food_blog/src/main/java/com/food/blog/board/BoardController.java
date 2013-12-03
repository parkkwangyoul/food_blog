package com.food.blog.board;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.food.blog.login.UserInfo;

@Controller
public class BoardController {
	
	@Resource
	private BoardService boardService;
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public ModelAndView writeContent(HttpSession session, @ModelAttribute Content content) {
		ModelAndView mav = new ModelAndView();
		System.out.println("BoardController::writeContent()");
		
		
		mav.setViewName("blog/write");

		return mav;
	}
}
