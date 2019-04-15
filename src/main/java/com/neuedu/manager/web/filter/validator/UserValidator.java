package com.neuedu.manager.web.filter.validator;

import org.apache.log4j.Logger;

import com.neuedu.manager.ex.InvalidParamException;
import com.neuedu.manager.po.User;
import com.neuedu.manager.util.GlobalInfo;
import com.neuedu.manager.util.PrivilegeConfig;

public class UserValidator implements PrivilegeValidator{
	private static Logger log = Logger.getLogger(UserValidator.class);
	
	public void valid(Object visitor, String uri) throws InvalidParamException {
		User user = (User) visitor;
		if(user != null) {
			if(PrivilegeConfig.USER_PRI.contains(uri)) {
				log.info("住户验证通过");
				return;
			} else {
				throw new InvalidParamException(GlobalInfo.USER_INFO_ERROR_CODE, GlobalInfo.NO_PRIVILEGE_MSG);
			}
		}
	}

}
