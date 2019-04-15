package com.neuedu.manager.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.neuedu.manager.ex.BaseException;
import com.neuedu.manager.ex.InvalidParamException;
import com.neuedu.manager.po.Admin;
import com.neuedu.manager.po.User;
import com.neuedu.manager.util.GlobalInfo;
import com.neuedu.manager.web.filter.validator.AdminValidator;
import com.neuedu.manager.web.filter.validator.PrivilegeValidator;
import com.neuedu.manager.web.filter.validator.UserValidator;

public class PrivilegeFilter implements MyFilter{
	private static Logger log = Logger.getLogger(PrivilegeFilter.class);
	
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, MyFilterChain chain) throws BaseException {
		HttpSession session = req.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		User user = (User) session.getAttribute("user");
		String uri = (String) req.getAttribute("cur_url");
		PrivilegeValidator validator = null;
		if(admin != null) {
			validator = new AdminValidator();
			validator.valid(admin, uri);
		} else if(user != null){
			validator = new UserValidator();
			validator.valid(user, uri);
		} else {
			throw new InvalidParamException(GlobalInfo.USER_NO_LOGIN_CODE,GlobalInfo.USER_NO_LOGIN_MSG);
		}
		
		
		
		
		
//		//验证是否有操作权限
//		if(admin.getPrivilege() == CodeMap.SUPER_ADMIN) {
//			log.info("管理员不验证权限");
//			chain.doFilter(req, resp);
//			return;
//		}
//		
//		//验证角色权限
//		if(admin.getPrivilege() == CodeMap.NORMAIL_ADMIN) {
//			if(PrivilegeConfig.NORMAIL_ADMIN_PRI.contains(uri)) {
//				log.info("normal权限验证 通过");
//				chain.doFilter(req, resp);
//				return;
//			}
//		} else if(admin.getPrivilege() == CodeMap.FIX_ADMIN) {
//			//System.out.println(admin.getPrivilege());
//			if(PrivilegeConfig.FIX_ADMIN_PRI.contains(uri)) {
//				log.info("fix权限验证 通过");
//				chain.doFilter(req, resp);
//				return;
//			} else {
//				throw new InvalidParamException(GlobalInfo.USER_INFO_ERROR_CODE, GlobalInfo.NO_PRIVILEGE_MSG);
//			}
//		} else {
//			throw new InvalidParamException(GlobalInfo.USER_INFO_ERROR_CODE, GlobalInfo.NO_PRIVILEGE_MSG);
//		}
	}
	
}
