package com.food.blog.login;

import com.food.blog.myblog.UserBlogInfo;

public class UserInfo {
	private String userId;
	private String name;
	private String password;
	private String confirmPassword;
	private String emailAddress;
	private String blogAddress;
	
	private Integer type;
	private String beforeBlogAddress;
	
	private UserBlogInfo blogInfo;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getBlogAddress() {
		return blogAddress;
	}

	public void setBlogAddress(String blogAddress) {
		this.blogAddress = blogAddress;
	}

	public String getBeforeBlogAddress() {
		return beforeBlogAddress;
	}

	public void setBeforeBlogAddress(String beforeBlogAddress) {
		this.beforeBlogAddress = beforeBlogAddress;
	}

	public UserBlogInfo getBlogInfo() {
		return blogInfo;
	}

	public void setBlogInfo(UserBlogInfo blogInfo) {
		this.blogInfo = blogInfo;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", name=" + name + ", password="
				+ password + ", confirmPassword=" + confirmPassword
				+ ", emailAddress=" + emailAddress + ", blogAddress="
				+ blogAddress + ", type=" + type + ", beforeBlogAddress="
				+ beforeBlogAddress + ", blogInfo=" + blogInfo + "]";
	}
	

}
