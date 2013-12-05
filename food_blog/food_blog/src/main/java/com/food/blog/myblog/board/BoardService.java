package com.food.blog.myblog.board;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.food.blog.login.UserInfo;
import com.food.blog.myblog.Content;
import com.food.blog.myblog.ContentAttachment;
import com.food.blog.myblog.UserBlogInfo;
import com.food.blog.upload.UploadService;

@Service
public class BoardService {
	
	@Resource
	private BoardDao boardDao;
	
	@Resource
	private UploadService uploadService;
	
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
	
	public void insertBoard(Content content){
		boardDao.joinContent(content);
		insertAttachments(content);
	}
	
	private void insertAttachments(Content content) {
		List<ContentAttachment> files = ContentAttachments(content.getAttachments());
		content.setAttachmentList(files);
		
		for (ContentAttachment ContentAttachment : files) {
			CommonsMultipartFile uploadedFile = ContentAttachment.getCommonsMultipartFile();
			if (uploadedFile.isEmpty()) continue;
			String filePath = uploadService.transferFile(uploadedFile, "board", Integer.toString(content.getPn()));
			
			ContentAttachment.setFilePath(filePath);	
			ContentAttachment.setBoardPn(content.getPn());
			
			boardDao.insertAttachment(ContentAttachment);
		}
	}
	
	public void updateBlogAddress(String blogAddress, String name, Integer type, String beforeBlogAddress){
		UserBlogInfo temp = new UserBlogInfo();
		String tp = name+"의 블로그";
		
		temp.setBlogAddress(blogAddress);
		temp.setBlogName(tp);
		temp.setType(type);
		temp.setBeforeBlogAddress(beforeBlogAddress);		
		boardDao.updateBlogAddress(temp);
	}
	
/*	private void deleteAttachments(Content content) {
		Integer[] list = content.getDeleteAttachments();
		if (list == null) return;
		for (Integer fileSeq : list) {
			try {
				ContentAttachment attachment = boardDao.getAttachment(content.getPn(), fileSeq);
				if (content.getPn().equals(attachment.getArticleId())) {
					File file = new File(attachment.getFilePath());
					file.delete();
					
					boardDao.deleteAttachment(fileSeq);
				}
			} catch (Exception e) {
			}
		}
	
	}*/
	
	public static List<ContentAttachment> ContentAttachments(CommonsMultipartFile attachments[]) {
		ArrayList<ContentAttachment> list = new ArrayList<ContentAttachment>();
		try {
			if (attachments == null) throw new Exception();
			for (CommonsMultipartFile commonsMultipartFile : attachments) {
				list.add(new ContentAttachment(commonsMultipartFile));
			}			
		} catch (Exception e) {
		}
		return list;
	}

	public ContentAttachment getAttachment(Integer seq) {
		return boardDao.getAttchment(seq);
	}
	
	
}
