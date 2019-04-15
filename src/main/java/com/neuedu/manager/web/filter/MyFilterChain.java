package com.neuedu.manager.web.filter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.manager.ex.BaseException;

public class MyFilterChain {
	private List<MyFilter> chain;
	private int index;
	public MyFilterChain() {
		chain = new ArrayList<MyFilter>();
	}
	
	public MyFilterChain addFilter(MyFilter filter) {
		chain.add(filter);
		return this;
	}
	
	public void doFilter(HttpServletRequest req,HttpServletResponse resp) throws BaseException {
		if(index >= chain.size())
			return;
		MyFilter myFilter = chain.get(index);
		index++;
		myFilter.doFilter(req, resp, this);
	}
}
