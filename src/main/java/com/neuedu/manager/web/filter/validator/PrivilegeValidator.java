package com.neuedu.manager.web.filter.validator;

import com.neuedu.manager.ex.InvalidParamException;

public interface PrivilegeValidator {
	public void valid(Object visitor,String uri) throws InvalidParamException;
}
