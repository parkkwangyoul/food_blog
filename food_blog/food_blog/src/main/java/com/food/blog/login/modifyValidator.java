package com.food.blog.login;

import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class modifyValidator implements Validator{
	
	@Resource 
	private LoginService loginService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserInfo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserInfo userInfo = (UserInfo) target;
		String userId = userInfo.getUserId();
		String name = userInfo.getName();
		String password = userInfo.getPassword();
		String confirmPassword = userInfo.getConfirmPassword();
		String emailAddress = userInfo.getEmailAddress();
		String blogAddress = userInfo.getBlogAddress();
		String beforeBlogAddress = userInfo.getBeforeBlogAddress();


		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "create.userId.emptyOrError");

		if (userId.length() > 20) { 
			errors.rejectValue("userId", "create.userId.emptyOrError");
		}
		
		if (name.length() > 20) { 
			errors.rejectValue("name", "create.userId.emptyOrError");
		}
		
		if (password.length() < 8 || password.length() > 16) {
			errors.rejectValue("password", "create.password.emptyOrError");
		}
		
		if (!password.equals(confirmPassword) || confirmPassword.equals("")) {
			errors.rejectValue("confirmPassword",
					"create.confirmPassword.notEqualPassword");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "create.emailAddress.empty");
		
		if(loginService.checkExistBlogAddress(userInfo) && !blogAddress.equals(beforeBlogAddress)){
			errors.rejectValue("blogAddress", "create.blogAddress.emptyOrError");
		}

		if (Pattern
				.matches(
						"/^[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[@]{1}[-A-Za-z0-9_]+[-A-Za-z0-9_.]*[.]{1}[A-Za-z]{2,5}$/",
						emailAddress)) {
			errors.rejectValue("emailAddress",
					"create.confirmEmailAddress.notMatchPattern");
		}
		
		if(blogAddress.length() > 20){
			errors.rejectValue("blogAddress", "create.blogAddress.emptyOrError");
		}
		
	}	
}
