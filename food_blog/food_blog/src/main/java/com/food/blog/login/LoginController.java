package com.food.blog.login;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Result;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.food.blog.myblog.MyblogService;
import com.food.blog.myblog.UserBlogInfo;


@Controller
public class LoginController {
	
	static Logger logger = Logger.getLogger("LoginController");

	@Resource
	private LoginService loginService;
	
	@Resource
	private MyblogService myblogService;
	
	@Resource
	private LoginValidator loginValidator;
	
	@RequestMapping(value = "/login/", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session,
			HttpServletRequest request, @ModelAttribute UserInfo userInfo) {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("login/login");
		return mav;
	}
	
	
	@RequestMapping(value = "/login/", method = RequestMethod.POST)
	public ModelAndView loginSubmit(HttpSession session,
			HttpServletRequest request, @ModelAttribute UserInfo userInfo) {
		ModelAndView mav = new ModelAndView();
		UserInfo loginUserInfo = loginService.login(userInfo);

		if (loginUserInfo.getUserId() != null) {
			session.setAttribute("userInfo", loginUserInfo);
			
			UserBlogInfo blogInfo = myblogService.getBlogByUserId(loginUserInfo.getUserId());
			
			logger.debug("Login Success!!");
			mav.setView(new RedirectView("/food_blog/blog/" + blogInfo.getBlogAddress() + "/"));
		} else {
			logger.debug("Login fail because UserInfo is not exist");
			mav.setViewName("login/loginFail");
		}

		return mav;
	}
	
	@RequestMapping(value = "/login/logout/", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session){ 
		ModelAndView mav = new ModelAndView();
		
		UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
		
		if(userInfo != null){
			session.removeAttribute("userInfo");
			session.setAttribute("userInfo", null);
		}else
			logger.debug("로그인 상태가 아닙니다.");
		
		mav.setView(new RedirectView("/food_blog/"));
		
		return mav;
	}

	
	/**
	 * 회원가입 페이지
	 * @param userInfo
	 */
	@RequestMapping(value = "/join/", method = RequestMethod.GET)
	public ModelAndView join(@ModelAttribute UserInfo userInfo){		
		ModelAndView mav = new ModelAndView();

		mav.setViewName("login/create");
		return mav; 
	}
	
	/**
	 * 회원가입 양식 submit
	 * @param userInfo
	 */
	@RequestMapping(value = "/join/", method = RequestMethod.POST)
	public ModelAndView joinSubmit(@ModelAttribute UserInfo userInfo, BindingResult result, Map<String, BindingResult> model){	
		ModelAndView mav = new ModelAndView();
		
		
		
		loginValidator.validate(userInfo, result);
		
		model.put(BindingResult.class.getName() + ".loginValidator", result);
		if(!result.hasErrors()){		
			loginService.join(userInfo);
			mav.setView(new RedirectView("/food_blog/"));
		} else {			
			
			mav.addObject("userInfo", new UserInfo());
			mav.setViewName("login/create");
		}
		
		return mav; 
	}
}
