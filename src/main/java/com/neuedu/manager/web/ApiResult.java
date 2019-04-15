package com.neuedu.manager.web;

import com.neuedu.manager.util.GlobalInfo;

public class ApiResult implements BaseResult{
	private int code;
	private String msg;
	private Object data;
	
	
	public int getCode() {
		return code;
	}
	public ApiResult setCode(int code) {
		this.code = code;
		return this;
	}
	public String getMsg() {
		return msg;
	}
	public ApiResult setMsg(String msg) {
		this.msg = msg;
		return this;
	}
	public Object getData() {
		return data;
	}
	public ApiResult setData(Object data) {
		this.data = data;
		return this;
	}
	
	public static ApiResult build() {
		ApiResult rs = new ApiResult();
		rs.setCode(GlobalInfo.SUCCESS_CODE).setMsg(GlobalInfo.SUCCESS_MSG);
		return rs;
	}
	
}
