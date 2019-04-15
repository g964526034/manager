package com.neuedu.manager.web;

public class JumpResult implements BaseResult{
	private String jumpUrl;

	public String getJumpUrl() {
		return jumpUrl;
	}

	public void setJumpUrl(String jumpUrl) {
		this.jumpUrl = jumpUrl;
	}

	@Override
	public String toString() {
		return "JumpResult [jumpUrl=" + jumpUrl + "]";
	}
	
}
