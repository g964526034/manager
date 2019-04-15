package com.neuedu.manager.web.filter;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.neuedu.manager.ex.BaseException;

public class LogFilter implements MyFilter {
	private static Logger log = Logger.getLogger(LogFilter.class);

	public void doFilter(HttpServletRequest req, HttpServletResponse resp, MyFilterChain chain) throws BaseException {
		String uri = req.getRequestURI();
		String ip = req.getRemoteAddr();
		log.info("ip" + ip + ",请求地址：" + uri);
		log.info("请求参数：----begin");
		Enumeration<String> names = req.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			log.info(name + ":" + req.getParameter(name));
		}
		log.info("请求参数：----end");
		
		chain.doFilter(req, resp);
	}
	
	
}
