package com.food.blog.myblog;

import java.util.List;

public class Category {
	private String userId;
	private String categoryId;
	private String categoryName;

	private List<CategoryDetail> categoryDetailList;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<CategoryDetail> getCategoryDetailList() {
		return categoryDetailList;
	}

	public void setCategoryDetailList(List<CategoryDetail> categoryDetailList) {
		this.categoryDetailList = categoryDetailList;
	}

	@Override
	public String toString() {
		return "Category [userId=" + userId + ", categoryId=" + categoryId
				+ ", categoryName=" + categoryName + ", categoryDetailList="
				+ categoryDetailList + "]";
	}
}
