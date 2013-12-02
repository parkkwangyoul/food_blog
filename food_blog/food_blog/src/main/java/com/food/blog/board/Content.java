package com.food.blog.board;

public class Content {
	private int pn;
	private int type;
	private String content;
	private String writeUser;
	private String writeDate;
	private int star;
	private int usestar;//0->미사용, 1-> 사용
	private int usecomment;//0->미사용, 1-> 사용
	private String blogAddress;
	
	public int getPn() {
		return pn;
	}
	public void setPn(int pn) {
		this.pn = pn;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getUsestar() {
		return usestar;
	}
	public void setUsestar(int usestar) {
		this.usestar = usestar;
	}
	public int getUsecomment() {
		return usecomment;
	}
	public void setUsecomment(int usecomment) {
		this.usecomment = usecomment;
	}
	public String getBlogAddress() {
		return blogAddress;
	}
	public void setBlogAddress(String blogAddress) {
		this.blogAddress = blogAddress;
	}
	@Override
	public String toString() {
		return "Content [pn=" + pn + ", type=" + type + ", content=" + content
				+ ", writeUser=" + writeUser + ", writeDate=" + writeDate
				+ ", star=" + star + ", usestar=" + usestar + ", usecomment="
				+ usecomment + ", blogAddress=" + blogAddress + "]";
	}

}
