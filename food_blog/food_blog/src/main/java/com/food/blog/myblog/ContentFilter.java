package com.food.blog.myblog;

public class ContentFilter {
	private String categoryId;
	private String detailId;
	private String blogAddress;

	public ContentFilter(String categoryId, String detailId, String blogAddress) {
		super();
		this.categoryId = categoryId;
		this.detailId = detailId;
		this.blogAddress = blogAddress;
	}

	public ContentFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	@Override
	public String toString() {
		return "ContentFilter [blogAddress=" + blogAddress + ", categoryId="
				+ categoryId + ", detailId=" + detailId + "]";
	}

}
