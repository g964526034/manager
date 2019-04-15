package com.neuedu.manager.po;

import java.util.Date;

public class UserCost {
	private Long id;
	private Cost cost;
	private User user;
	private Double costNum;
	private Double totalCost;
	private Date createTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cost getCost() {
		return cost;
	}
	public void setCost(Cost cost) {
		this.cost = cost;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getCostNum() {
		return costNum;
	}
	public void setCostNum(Double costNum) {
		this.costNum = costNum;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "UserCost [id=" + id + ", cost=" + cost + ", user=" + user + ", costNum=" + costNum + ", totalCost="
				+ totalCost + ", createTime=" + createTime + "]";
	}
	
	
	
}
