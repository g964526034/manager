package com.neuedu.manager.po;

import java.util.Date;

public class User {
	private Long userId;
	private String name;
	private String id;
	private int gender;
	private String nation;
	private String email;
	private String tel;
	private String houseMessage;
	private int houseSituation;
	private String parkMessage;
	private String pwd;
	private String more;
	private Date buyTime;
	
	public Date getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	public String getMore() {
		return more;
	}
	public void setMore(String more) {
		this.more = more;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getHouseMessage() {
		return houseMessage;
	}
	public void setHouseMessage(String houseMessage) {
		this.houseMessage = houseMessage;
	}
	public int getHouseSituation() {
		return houseSituation;
	}
	public void setHouseSituation(int houseSituation) {
		this.houseSituation = houseSituation;
	}
	public String getParkMessage() {
		return parkMessage;
	}
	public void setParkMessage(String parkMessage) {
		this.parkMessage = parkMessage;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", id=" + id + ", gender=" + gender + ", nation=" + nation
				+ ", email=" + email + ", tel=" + tel + ", houseMessage=" + houseMessage + ", houseSituation="
				+ houseSituation + ", parkMessage=" + parkMessage + ", pwd=" + pwd + ", more=" + more + ", buyTime="
				+ buyTime + "]";
	}
	
	
	
	
}
