package com.food.blog.myblog;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyblogService {
	
	@Resource
	private MyblogDao myblogDao;
	
	@Transactional
	public UserBlogInfo getBlog(String blogAddress){
		UserBlogInfo getUserBlogInfo = myblogDao.get(blogAddress);
		
		if(getUserBlogInfo != null){
			return getUserBlogInfo;
		} else {
			getUserBlogInfo = new UserBlogInfo();
			return getUserBlogInfo;			
		}
	}
	
	public void join(UserBlogInfo userBlogInfo){
		myblogDao.join(userBlogInfo);
	}
	
	public boolean checkExistBlog(String blogAddress){
		int blogCheck = myblogDao.blogCheck(blogAddress);
		System.out.println("MyBlogService::"+blogCheck);
		if(blogCheck > 0){
			return true;
		} else {
			return false;
		}
	}

}
