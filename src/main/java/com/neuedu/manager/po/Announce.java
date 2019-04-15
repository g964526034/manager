package com.neuedu.manager.po;

import java.util.Date;

public class Announce {
	private Long id;
	private Admin admin;
	private String title;
	private String content; 
	private Date createTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Override
	public String toString() {
		return "Announce [id=" + id + ", admin=" + admin + ", title=" + title + ", content=" + content + ", createTime="
				+ createTime + "]";
	}
	
	
	
}
