package com.neuedu.manager.util;

public class GlobalInfo {
	//请求成功
	public static final int SUCCESS_CODE = 200;
	public static final String SUCCESS_MSG = "success";
	
	public static final int INVALID_PARAM_CODE = 1000;
	public static final String INVALID_PARAM_MSG= "请求参数异常";
	
	//文件类型不合法
	public static final int INVALID_IMGTYPE_CODE = 1001;
	public static final String INVALID_IMGTYPE_MSG= "文件类型不合法";
	
	
	/**
	 * 用户模块
	 */
	//用户名或密码不正确
	public static final int USER_INFO_ERROR_CODE = 2000;
	public static final String USER_INFO_ERROR_MSG = "用户名或密码不正确";
	
	//用户没有登录
	public static final int USER_NO_LOGIN_CODE = 2001;
	public static final String USER_NO_LOGIN_MSG = "未登录";
	//没有操作权限
	public static final int NO_PRIVILEGE_CODE = 2002;
	public static final String NO_PRIVILEGE_MSG = "没有操作权限";
	
}
