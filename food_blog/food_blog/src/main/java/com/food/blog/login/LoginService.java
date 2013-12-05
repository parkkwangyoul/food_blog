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
		System.out.println("Before Connect DB");
		UserInfo loginUserInfo = loginDao.get(userInfo);
		System.out.println("After Connect DB");
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
	
	public boolean checkExistUserId(UserInfo userInfo) {
		int userCheck = loginDao.userCheck(userInfo);
		System.out.println("ID Check : "+userCheck);
		if (userCheck > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkExistBlogAddress(UserInfo userInfo){
		int blogCheck = loginDao.blogCheck(userInfo);
		System.out.println("blog Check : "+blogCheck);
		if (blogCheck > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void userUpate(UserInfo userInfo){
		loginDao.update(userInfo);
	}
	
	
}
