package com.food.blog.myblog.board;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.blog.myblog.Content;

@Service
public class BoardService {
	
	@Resource
	private BoardDao boardDao;
	
	@Transactional
	public Content getContent(String blogAddress){
		Content content = boardDao.getContent(blogAddress);
		
		if(content != null){
			return content;
		} else {
			content = new Content();
			return content;
		}
	}
	
	public void joinContent(Content content){
		boardDao.joinContent(content);
	}
	
	
}
