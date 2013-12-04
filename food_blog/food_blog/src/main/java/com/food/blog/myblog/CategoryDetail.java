package com.food.blog.myblog;

public class CategoryDetail {
	private String id;
	private String detailId;
	private String detailName;
	private String detailLinkName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public String getDetailLinkName() {
		return detailLinkName;
	}

	public void setDetailLinkName(String detailLinkName) {
		this.detailLinkName = detailLinkName;
	}

	public String getDetailName() {
		return detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	@Override
	public String toString() {
		return "CategoryDetail [id=" + id + ", detailId=" + detailId
				+ ", detailName=" + detailName + ", detailLinkName="
				+ detailLinkName + "]";
	}

}
