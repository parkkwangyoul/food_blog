package com.food.blog.login;

import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {

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
		String password = userInfo.getPassword();


		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "create.userId.emptyOrError");

		if (userId.length() > 20) {
			errors.rejectValue("userId", "create.userId.emptyOrError");
		}
		/*
		if (loginService.checkExistUserId(userInfo)){
			errors.rejectValue("userId", "create.userId.existUserId");
		}*/

		if (password.length() < 8 || password.length() > 16) {
			errors.rejectValue("password", "create.password.emptyOrError");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "create.emailAddress.empty");
	}
}
