package com.neuedu.manager.web.filter.validator;

import org.apache.log4j.Logger;

import com.neuedu.manager.ex.InvalidParamException;
import com.neuedu.manager.po.Admin;
import com.neuedu.manager.util.CodeMap;
import com.neuedu.manager.util.GlobalInfo;
import com.neuedu.manager.util.PrivilegeConfig;

public class AdminValidator implements PrivilegeValidator{
	private static Logger log = Logger.getLogger(AdminValidator.class);
	public void valid(Object visitor, String uri) throws InvalidParamException {
		Admin admin = (Admin)visitor;
		if(admin.getPrivilege() == CodeMap.SUPER_ADMIN) {
			log.info("管理员不验证权限");
			return;
		}
		
		//验证角色权限
		if(admin.getPrivilege() == CodeMap.NORMAIL_ADMIN) {
			if(PrivilegeConfig.NORMAIL_ADMIN_PRI.contains(uri)) {
				log.info("normal权限验证 通过");
				return;
			}
		} else if(admin.getPrivilege() == CodeMap.FIX_ADMIN) {
			//System.out.println(admin.getPrivilege());
			if(PrivilegeConfig.FIX_ADMIN_PRI.contains(uri)) {
				log.info("fix权限验证 通过");
				return;
			} else {
				throw new InvalidParamException(GlobalInfo.USER_INFO_ERROR_CODE, GlobalInfo.NO_PRIVILEGE_MSG);
			}
		} else {
			throw new InvalidParamException(GlobalInfo.USER_INFO_ERROR_CODE, GlobalInfo.NO_PRIVILEGE_MSG);
		}
	}
}
