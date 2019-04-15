package com.neuedu.manager.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.manager.ex.BaseException;

public interface MyFilter {
	public void doFilter(HttpServletRequest req,HttpServletResponse resp,MyFilterChain chain) throws BaseException;
}
