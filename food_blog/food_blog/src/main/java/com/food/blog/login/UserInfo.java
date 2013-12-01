package com.food.blog.login;

public class UserInfo {
	private String userId;
	private String name;
	private String password;
	private String confirmPassword;
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	private String emailAddress;
	private String blogAddress;
	
	
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
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", name=" + name + ", password="
				+ password + ", confirmPassword=" + confirmPassword
				+ ", emailAddress=" + emailAddress + ", blogAddress="
				+ blogAddress + "]";
	}
}
