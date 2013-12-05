package com.food.blog.myblog;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Content extends Category {
	private Integer pn;
	private Integer type;
	private String title;
	private String content;
	private String writeUser;
	private String writeDate;
	private Integer star;

	private Boolean useStar;
	private Boolean useComment;

	private String blogAddress;

	private List<Comment> commentList;

	/* 쿼리용 */
	private Integer detailId;

	public Integer getPn() {
		return pn;
	}

	public void setPn(Integer pn) {
		this.pn = pn;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getUseStar() {
		return useStar;
	}

	public void setUseStar(Boolean useStar) {
		this.useStar = useStar;
	}

	public Boolean getUseComment() {
		return useComment;
	}

	public void setUseComment(Boolean useComment) {
		this.useComment = useComment;
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

	public Integer getDetailId() {
		return detailId;
	}

	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}

	@Override
	public String toString() {
		return "Content [pn=" + pn + ", type=" + type + ", title=" + title
				+ ", content=" + content + ", writeUser=" + writeUser
				+ ", writeDate=" + writeDate + ", star=" + star + ", useStar="
				+ useStar + ", useComment=" + useComment + ", blogAddress="
				+ blogAddress + ", commentList=" + commentList + ", detailId="
				+ detailId + "]";
	}

	/**
	 * Files to upload
	 */
	private CommonsMultipartFile attachments[];

	/**
	 * Files already uploaded
	 */
	private List<ContentAttachment> attachmentList;

	/**
	 * 
	 */
	private Integer deleteAttachments[];

	public CommonsMultipartFile[] getAttachments() {
		return attachments;
	}

	public void setAttachments(CommonsMultipartFile[] attachments) {
		this.attachments = attachments;
	}

	public List<ContentAttachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<ContentAttachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public Integer[] getDeleteAttachments() {
		return deleteAttachments;
	}

	public void setDeleteAttachments(Integer[] deleteAttachments) {
		this.deleteAttachments = deleteAttachments;
	}
}
