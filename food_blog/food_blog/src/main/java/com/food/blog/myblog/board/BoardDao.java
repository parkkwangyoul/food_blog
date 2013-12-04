package com.food.blog.myblog.board;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.food.blog.myblog.Content;

@Repository
public class BoardDao extends SqlSessionDaoSupport {
	public Content getContent(String blogAddress){
		return getSqlSession().selectOne("boardMapper.getContent", blogAddress);
	}
	
	public void joinContent(Content content){
		getSqlSession().insert("boardMapper.joinContent", content);
	}

}
