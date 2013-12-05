package com.food.blog.myblog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.blog.login.UserInfo;

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
	
	public void join(String blogAddress, String name){
		UserBlogInfo userBlogInfo = new UserBlogInfo();
		String temp = name+"의 블로그";
		
		userBlogInfo.setBlogAddress(blogAddress);
		userBlogInfo.setBlogName(temp);
		userBlogInfo.setType(1);
		
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

	public List<Category> getUserCategory(String blogAddress) {
		
		List<Category> list = myblogDao.getUserCategory(blogAddress);
		
		return list;
	}

	public List<Content> getContentList(String categoryId, String detailId, String blogAddress) {
		ContentFilter contentFilter = new ContentFilter(categoryId, detailId, blogAddress);
		
		List<Content> list = myblogDao.getContentList(contentFilter);
		
		return list;
	}

	public UserBlogInfo getBlogByUserId(String userId) {
		
		return myblogDao.getBlogByUserId(userId);		
	}
	
	public void updateUserBlogInfo(String blogAddress, String name, Integer type, String beforeBlogAddress){
		UserBlogInfo temp = new UserBlogInfo();
		String tp = name+"의 블로그";
		
		temp.setBlogAddress(blogAddress);
		temp.setBlogName(tp);
		temp.setType(type);
		temp.setBeforeBlogAddress(beforeBlogAddress);
		
		
		myblogDao.update(temp);
	}

}
