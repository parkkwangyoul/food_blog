package com.food.blog.myblog;

public class Comment {
	private int pn;
	private String content;
	private String writeUser;
	private String writeDate;
	private int boardPn;
	
	public int getPn() {
		return pn;
	}
	public void setPn(int pn) {
		this.pn = pn;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteUser() {
		return writeUser;
	}
	public void setWriteUser(String writeUser) {
		this.writeUser = writeUser;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public int getBoardPn() {
		return boardPn;
	}
	public void setBoardPn(int boardPn) {
		this.boardPn = boardPn;
	}
	@Override
	public String toString() {
		return "Comment [pn=" + pn + ", content=" + content + ", writeUser="
				+ writeUser + ", writeDate=" + writeDate + ", boardPn="
				+ boardPn + "]";
	}
	
}
