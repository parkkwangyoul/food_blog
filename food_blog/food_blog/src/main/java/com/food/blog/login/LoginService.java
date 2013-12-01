package com.food.blog.login;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {
	
	@Resource
	private LoginDao loginDao;
	
	
	@Transactional
	public UserInfo login(UserInfo userInfo){
		UserInfo loginUserInfo = loginDao.get(userInfo);
		
		if( loginUserInfo != null ){			
			return loginUserInfo;
		}else{
			loginUserInfo = new UserInfo();
			
			return loginUserInfo;
		}			
	}
	
	public void join(UserInfo userInfo){
		loginDao.join(userInfo);
	}
}
