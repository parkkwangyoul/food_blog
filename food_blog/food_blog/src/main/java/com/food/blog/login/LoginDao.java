package com.food.blog.login;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao extends SqlSessionDaoSupport {
	public UserInfo get(UserInfo userInfo){
		return getSqlSession().selectOne("loginMapper.userLogin", userInfo);
	}
	
	public void join(UserInfo userInfo){
		getSqlSession().insert("loginMapper.join", userInfo);
	}
}
