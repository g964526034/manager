package com.neuedu.manager.po;

import java.util.Date;

public class Fix {
	private Long id;
	private User user;
	private String title;
	private String fixMessage;
	private Date createTime;
	private Admin admin;
	private String response;
	private int solution;
	private int condition;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFixMessage() {
		return fixMessage;
	}
	public void setFixMessage(String fixMessage) {
		this.fixMessage = fixMessage;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public int getSolution() {
		return solution;
	}
	public void setSolution(int solution) {
		this.solution = solution;
	}
	public int getCondition() {
		return condition;
	}
	public void setCondition(int condition) {
		this.condition = condition;
	}
	@Override
	public String toString() {
		return "Fix [id=" + id + ", user=" + user + ", title=" + title + ", fixMessage=" + fixMessage + ", createTime="
				+ createTime + ", admin=" + admin + ", response=" + response + ", solution=" + solution + ", condition="
				+ condition + "]";
	}
	
	
}
