package com.neuedu.manager.ex;

public class InvalidParamException extends BaseException{
	
	public InvalidParamException() {
	}
	
	public InvalidParamException(String msg) {
		super(msg);
	}
	
	public InvalidParamException(int code,String msg) {
		super(code,msg);
	}
}
