package com.food.blog.myblog.board;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.food.blog.myblog.Comment;
import com.food.blog.myblog.Content;
import com.food.blog.myblog.ContentAttachment;
import com.food.blog.myblog.UserBlogInfo;

@Repository
public class BoardDao extends SqlSessionDaoSupport {
	public Content getContent(String blogAddress){
		return getSqlSession().selectOne("boardMapper.getContent", blogAddress);
	}
	
	public void joinContent(Content content){
		getSqlSession().insert("boardMapper.joinContent", content);
	}

	public void insertAttachment(ContentAttachment contentAttachment) {
		getSqlSession().insert("boardMapper.insertAttachment", contentAttachment);
	}
	
	public void updateBlogAddress(UserBlogInfo userBlogInfo){
		getSqlSession().update("boardMapper.blogAddressUpdate", userBlogInfo);
	}

	public ContentAttachment getAttchment(Integer seq) {
		return getSqlSession().selectOne("boardMapper.getAttachment", seq);
	}

	public void addComment(Comment comment) {
		getSqlSession().insert("boardMapper.addComment", comment);
	}

	public Comment getComment(Comment comment) {
		return getSqlSession().selectOne("boardMapper.getComment", comment);
	}

}
