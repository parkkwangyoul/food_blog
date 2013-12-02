package com.food.blog.login;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao extends SqlSessionDaoSupport {
	public UserInfo get(UserInfo userInfo){
		System.out.println("Before Connect DB");
		return getSqlSession().selectOne("loginMapper.userLogin", userInfo);
	}
	
	public void join(UserInfo userInfo){
		getSqlSession().insert("loginMapper.join", userInfo);
	}
	
	public int userCheck(UserInfo userInfo){
		return (Integer) getSqlSession().selectOne("loginMapper.userCheck", userInfo);
	}
	
	public int blogCheck(UserInfo userInfo){
		return (Integer) getSqlSession().selectOne("loginMapper.blogCheck", userInfo);
	}
}
