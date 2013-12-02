package com.food.blog;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.food.blog.login.LoginService;
import com.food.blog.login.UserInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Resource
	private LoginService loginService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home( HttpSession session, @ModelAttribute UserInfo userInfo){
		ModelAndView mav = new ModelAndView();

		mav.addObject("userInfo", userInfo);
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView loginSubmit(HttpSession session, HttpServletRequest request, @ModelAttribute UserInfo userInfo){
		ModelAndView mav = new ModelAndView();
		UserInfo loginUserInfo = loginService.login(userInfo);
		session.setAttribute("abc", loginUserInfo);
		
		System.out.println(loginUserInfo.toString());
		
		if (loginUserInfo.getUserId() != null) {
			session.setAttribute("userInfo", loginUserInfo);
			
			logger.debug("Login Success!!");
			mav.setView(new RedirectView("/food_blog/"));
		} else {
			logger.debug("Login fail because UserInfo is not exist");
			mav.setViewName("login/loginFail");
		}

		return mav; 
	}
}
