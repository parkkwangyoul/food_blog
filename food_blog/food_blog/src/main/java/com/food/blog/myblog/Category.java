package com.food.blog.myblog;

import java.util.List;
import java.util.Map;

public class Category {
	private String blogAddress;
	private String categoryId;
	private String categoryName;

	private List<CategoryDetail> categoryDetailList;

	public String getBlogAddress() {
		return blogAddress;
	}

	public void setBlogAddress(String blogAddress) {
		this.blogAddress = blogAddress;
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
		return "Category [blogAddress=" + blogAddress + ", categoryId="
				+ categoryId + ", categoryName=" + categoryName
				+ ", categoryDetailList=" + categoryDetailList + "]";
	}
}
