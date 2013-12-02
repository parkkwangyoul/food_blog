package com.food.blog.myblog;

public class UserBlogInfo {
	String blogAddress;
	String blogName;
	int type=1;// 기본 게시판 유형은 1번유형
	
	public String getBlogAddress() {
		return blogAddress;
	}
	public void setBlogAddress(String blogAddress) {
		this.blogAddress = blogAddress;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "UserBlogInfo [blogAddress=" + blogAddress + ", blogName="
				+ blogName + ", type=" + type + "]";
	}
	
}
