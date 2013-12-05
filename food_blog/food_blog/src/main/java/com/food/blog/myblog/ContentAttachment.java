package com.food.blog.myblog;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ContentAttachment {


	private Integer seq;
	private Integer boardPn;
	private String fileName;
	private String filePath;
	private String fileExtension;
	private String mimeType;
	private long fileSize;
	
	
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}	

	public Integer getBoardPn() {
		return boardPn;
	}
	public void setBoardPn(Integer boardPn) {
		this.boardPn = boardPn;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileExtension() {
		return fileExtension;
	}
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	private CommonsMultipartFile commonsMultipartFile;


	public CommonsMultipartFile getCommonsMultipartFile() {
		return commonsMultipartFile;
	}
	public void setCommonsMultipartFile(CommonsMultipartFile commonsMultipartFile) {
		this.commonsMultipartFile = commonsMultipartFile;
	}
	public ContentAttachment(CommonsMultipartFile commonsMultipartFile) {
		super();
		this.commonsMultipartFile = commonsMultipartFile;
		
		setFileName(commonsMultipartFile.getOriginalFilename());
		setFileExtension(getExtension(commonsMultipartFile.getOriginalFilename()));
		setMimeType(commonsMultipartFile.getContentType());
		setFileSize(commonsMultipartFile.getSize());
	}
	
	public ContentAttachment() {
	}
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getExtension(String fileName) {
	    String ext = null;
	    int i = fileName.lastIndexOf('.');

	    if (i > 0 &&  i < fileName.length() - 1) {
	        ext = fileName.substring(i+1).toLowerCase();
	    }
	    return ext;
	}
}
