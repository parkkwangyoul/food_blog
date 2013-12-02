package com.food.blog.myblog;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.food.blog.login.UserInfo;

@Controller
public class MyblogController {
	
	@RequestMapping(value = "/blog/blog", method = RequestMethod.GET)
	public ModelAndView loginSubmit(@ModelAttribute UserInfo userInfo) {
		ModelAndView mav = new ModelAndView();
		

		mav.setViewName("blog/blog");

		return mav;
	}
}
