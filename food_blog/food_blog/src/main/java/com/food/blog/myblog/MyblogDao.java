package com.food.blog.myblog;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.food.blog.login.UserInfo;

@Repository
public class MyblogDao extends SqlSessionDaoSupport {
	public UserBlogInfo get(String blogAddress){
		return getSqlSession().selectOne("myblogInfoMapper.getBlogInfo", blogAddress);
	}
	
	public void join(UserBlogInfo userBlogInfo){
		getSqlSession().insert("myblogInfoMapper.join", userBlogInfo);
	}
	
	public int blogCheck(String blogAddress){
		return (Integer) getSqlSession().selectOne("myblogInfoMapper.blogCheck", blogAddress);
	}

	public List<Category> getUserCategory(UserInfo userInfo) {
		return getSqlSession().selectList("myblogInfoMapper.getUserCategory", userInfo);
	}

	public List<Content> getContentList(ContentFilter contentFilter) {
		return getSqlSession().selectList("boardMapper.getContentList", contentFilter);
	}

	public UserBlogInfo getBlogByUserId(String userId) {
		return getSqlSession().selectOne("myblogInfoMapper.getBlogByUserId", userId);
	}

}
