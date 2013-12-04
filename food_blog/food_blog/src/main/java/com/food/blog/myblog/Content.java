package com.food.blog.myblog;

import java.util.List;

public class Content extends Category {
	private int pn;
	private int type;
	private String title;
	private String content;
	private String writeUser;
	private String writeDate;
	private int star;

	private boolean useStar;
	private boolean useComment;

	private String blogAddress;

	private List<Comment> commentList;

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

	public String getBlogAddress() {
		return blogAddress;
	}

	public void setBlogAddress(String blogAddress) {
		this.blogAddress = blogAddress;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isUseStar() {
		return useStar;
	}

	public void setUseStar(boolean useStar) {
		this.useStar = useStar;
	}

	public boolean isUseComment() {
		return useComment;
	}

	public void setUseComment(boolean useComment) {
		this.useComment = useComment;
	}

	@Override
	public String toString() {
		return "Content [pn=" + pn + ", type=" + type + ", title=" + title
				+ ", content=" + content + ", writeUser=" + writeUser
				+ ", writeDate=" + writeDate + ", star=" + star + ", useStar="
				+ useStar + ", useComment=" + useComment + ", blogAddress="
				+ blogAddress + ", commentList=" + commentList + "]";
	}	
}
