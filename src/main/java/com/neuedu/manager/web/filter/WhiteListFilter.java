package com.neuedu.manager.web.filter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.neuedu.manager.ex.BaseException;



public class WhiteListFilter implements MyFilter{
	private static Logger log = Logger.getLogger(WhiteListFilter.class);
	
	private static List<String> whiteList = new ArrayList<String>();
	static {
		whiteList.add("user/register");
		whiteList.add("user/doRegister");
		whiteList.add("user/emaillogin");
		whiteList.add("user/doEmaillogin");
		whiteList.add("user/tellogin");
		whiteList.add("user/doTellogin");
		whiteList.add("user/validId");
		whiteList.add("user/validTel");
		whiteList.add("user/validEmail");
		whiteList.add("user/existTelEmail");
		whiteList.add("user/existPwd");
		whiteList.add("user/changepwd");
		whiteList.add("user/doChangepwd");
		
		whiteList.add("admin/login");
		whiteList.add("admin/doLogin");
		whiteList.add("admin/validTel");
		whiteList.add("admin/validEmail");
		
		whiteList.add("user_cost/validUserCost");
	}
	
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, MyFilterChain chain) throws BaseException {
		String uri = (String) req.getAttribute("cur_url");
		if(whiteList.contains(uri)) {
			log.info("白名单验证通过，无需后续验证");
			return;
		}
		chain.doFilter(req, resp);
	}

}
