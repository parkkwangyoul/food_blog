package com.food.blog.board;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao extends SqlSessionDaoSupport {
	public Content getContent(String blogAddress){
		return getSqlSession().selectOne("boardMapper.getContent", blogAddress);
	}
	
	public void joinContent(Content content){
		getSqlSession().insert("boardMapper.joinContent", content);
	}

}
