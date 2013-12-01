package com.food.blog;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import com.food.blog.login.UserInfo;

@Aspect
@Component
public class ControllerAspect {

	private final Logger logger = LoggerFactory
			.getLogger(ControllerAspect.class);

	@Around("bean(*Controller)")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		String signatureString = joinPoint.getSignature().toShortString();
		logger.info(signatureString + " 시작");
		long start = System.currentTimeMillis();

		try {
			Object param[] = joinPoint.getArgs();
			boolean newParmSkip[] = new boolean[param.length];

			Class<?> targetController = joinPoint.getSignature()
					.getDeclaringType();
			Method targetMethod = findMethodByName(targetController, joinPoint
					.getSignature().getName());

			Annotation[][] annotationss = targetMethod
					.getParameterAnnotations();
			for (int i = 0; i < annotationss.length; i++) {
				Annotation annotations[] = annotationss[i];
				if (annotations.length > 0) {
					if (annotations[0].annotationType() == ModelAttribute.class
							|| annotations[0].annotationType() == RequestBody.class) {
						newParmSkip[i] = true;
					}
				} else {
					newParmSkip[i] = false;
				}
			}
			
			HttpSession session; 
			UserInfo user;

			for (int i = 0; i < param.length; i++) {
				if (newParmSkip[i] == false) {
					if (param[i] != null) {
						if (param[i].getClass() == HttpServletRequest.class){
							HttpServletRequest request = (HttpServletRequest)param[i];
							session = request.getSession();
							user = (UserInfo) session.getAttribute("userInfo");
						} else {
							user = new UserInfo();
						}
						
						if (param[i].getClass() == UserInfo.class) {
							param[i] = user;
						}
						logger.debug("Param Class : " + param[i].getClass());
					}
				}
			}

			return joinPoint.proceed(param);
		} finally {
			long finish = System.currentTimeMillis();
			logger.info(signatureString + " 종료");
			logger.info(signatureString + " 실행 시간 : " + (finish - start) + "ms");
		}
	}

	private Method findMethodByName(Class<?> target, String name) {
		Method m[] = target.getMethods();
		for (Method method : m) {
			if (method.getName().equals(name))
				return method;
		}
		return null;
	}

}