package com.neuedu.manager.util;

import java.util.ArrayList;
import java.util.List;

public class PrivilegeConfig {
	public static List<String> USER_PRI = new ArrayList<String>();
	public static List<String> NORMAIL_ADMIN_PRI = new ArrayList<String>();
	public static List<String> FIX_ADMIN_PRI = new ArrayList<String>();
	static {
		USER_PRI.add("user/welcome");
		USER_PRI.add("complain/add");
		USER_PRI.add("complain/doAdd");
		USER_PRI.add("complain/doUserBrowse");
		USER_PRI.add("complain/userBrowse");
		USER_PRI.add("complain/userDel");
		USER_PRI.add("complain/doUserFind");
		USER_PRI.add("complain/userFind");
		USER_PRI.add("complain/userEdit");
		USER_PRI.add("complain/doUpdate");
		USER_PRI.add("complain/update");
		USER_PRI.add("fix/add");
		USER_PRI.add("fix/doAdd");
		USER_PRI.add("fix/doUserBrowse");
		USER_PRI.add("fix/userBrowse");
		USER_PRI.add("fix/userDel");
		USER_PRI.add("fix/doUserFind");
		USER_PRI.add("fix/userFind");
		USER_PRI.add("fix/userEdit");
		USER_PRI.add("fix/doUpdate");
		USER_PRI.add("fix/update");
		USER_PRI.add("user_cost/doUserBrowse");
		USER_PRI.add("user_cost/userBrowse");
		USER_PRI.add("announce/doUserBrowse");
		USER_PRI.add("announce/userBrowse");
		USER_PRI.add("announce/doUserFind");
		USER_PRI.add("announce/userFind");
		USER_PRI.add("cost/doUserBrowse");
		USER_PRI.add("cost/userBrowse");
		
		NORMAIL_ADMIN_PRI.add("admin/welcome");
		NORMAIL_ADMIN_PRI.add("admin/find");
		NORMAIL_ADMIN_PRI.add("user/add");
		NORMAIL_ADMIN_PRI.add("user/browse");
		
		FIX_ADMIN_PRI.add("admin/welcome");
		FIX_ADMIN_PRI.add("admin/find");
		FIX_ADMIN_PRI.add("announce/add");
		FIX_ADMIN_PRI.add("announce/doAdd");
		FIX_ADMIN_PRI.add("announce/doBrowse");
		FIX_ADMIN_PRI.add("announce/browse");
		FIX_ADMIN_PRI.add("announce/edit");
		FIX_ADMIN_PRI.add("announce/update");
		FIX_ADMIN_PRI.add("announce/doUpdate");
		FIX_ADMIN_PRI.add("announce/del");
		FIX_ADMIN_PRI.add("announce/doFind");
		FIX_ADMIN_PRI.add("announce/find");
		FIX_ADMIN_PRI.add("fix/response");
		FIX_ADMIN_PRI.add("fix/browse");
	}
}
