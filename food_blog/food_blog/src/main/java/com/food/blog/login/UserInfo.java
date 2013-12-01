package com.food.blog.login;

public class UserInfo {
	private String userId;
	private String name;
	private String password;
	private String emailAddress;
	
	private String realUserImage;
	private String saveUserImage;
	
	
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
	
	public String getRealUserImage() {
		return realUserImage;
	}
	public void setRealUserImage(String realUserImage) {
		this.realUserImage = realUserImage;
	}
	
	public String getSaveUserImage() {
		return saveUserImage;
	}
	public void setSaveUserImage(String saveUserImage) {
		this.saveUserImage = saveUserImage;
	}
	
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", name=" + name + ", password="
				+ password + ", emailAddress=" + emailAddress
				+ ", realUserImage=" + realUserImage + ", saveUserImage="
				+ saveUserImage + "]";
	}
}
