package com.food.blog.board;


public class BoardService {
	

	private BoardDao boardDao;
	

	public Content getContent(String blogAddress){
		Content content = boardDao.getContent(blogAddress);
		
		if(content != null){
			return content;
		} else {
			content = new Content();
			return content;
		}
	}
	
	
}
