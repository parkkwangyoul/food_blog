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
	/*
	@Transactional
	public boolean join(UserInfo userInfo) {		
		loginDao.join(userInfo);
		
		if(userInfo.getMyInterestListStr() != null && !userInfo.getMyInterestListStr().equals("관심사 구분은  , 로 해주시기 바랍니다.")){
			String [] interestList = userInfo.getMyInterestListStr().split(",");
			for ( int i = 0 ; i < interestList.length ; i ++ ){				
				interestService.interestCheckAndRegist(interestList[i]);
				
				interestService.insertUserInterest(userInfo, interestList[i]);
			}
		}
		
		return true;
	}

	public boolean checkExistUserId(UserInfo userInfo) {
		int userCheck = loginDao.userCheck(userInfo);
		
		if(userCheck > 0){
			return true;
		} else {
			return false;
		}
	}	
	*/
}
