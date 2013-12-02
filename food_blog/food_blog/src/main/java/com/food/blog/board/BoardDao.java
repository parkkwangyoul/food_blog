package com.food.blog.board;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BoardDao extends SqlSessionDaoSupport {
	public Content getContent(String blogAddress){
		return getSqlSession().selectOne("boardMapper.getContent", blogAddress);
	}

}
