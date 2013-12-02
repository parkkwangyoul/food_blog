package com.food.blog.myblog;

public class UserBlogInfo {
	String blogAddress;
	String blogName;
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
	@Override
	public String toString() {
		return "UserBlogInfo [blogAddress=" + blogAddress + ", blogName="
				+ blogName + "]";
	}
}
