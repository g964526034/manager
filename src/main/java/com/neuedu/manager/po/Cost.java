package com.neuedu.manager.po;

import java.util.Date;

public class Cost {
	private Long id;
	private String costName;
	private Double price;
	private Date createTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCostName() {
		return costName;
	}
	public void setCostName(String costName) {
		this.costName = costName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Cost [id=" + id + ", costName=" + costName + ", price=" + price + ", createTime=" + createTime + "]";
	}
	
	
	
}
