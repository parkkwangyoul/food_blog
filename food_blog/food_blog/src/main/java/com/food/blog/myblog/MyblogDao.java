package com.food.blog.myblog;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

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

}
