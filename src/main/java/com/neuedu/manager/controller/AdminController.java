package com.neuedu.manager.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.neuedu.manager.ex.InvalidParamException;
import com.neuedu.manager.po.Admin;
import com.neuedu.manager.service.AdminService;
import com.neuedu.manager.service.AdminServiceImpl;
import com.neuedu.manager.util.V;
import com.neuedu.manager.web.ApiResult;
import com.neuedu.manager.web.JumpResult;
import com.neuedu.manager.web.PageData;
import com.neuedu.manager.web.Result;

public class AdminController {
	private AdminService adminService;
	private static Logger log = Logger.getLogger(AdminController.class);

	public AdminController() {
		adminService = new AdminServiceImpl();
	}
	
	/**
	 * 添加管理员信息
	 * @param req
	 * @param resp
	 * @return
	 * @throws IOException
	 */
	public JumpResult doAdd(HttpServletRequest req,HttpServletResponse resp ) throws IOException {
		String[] params = {"tel","email","real_name","pwd","work","salary"};
		String[] getParams = {"tel","email","real_name","gender","pwd","marriage","work","salary","privilege"};
		V.isEmpty(req,params);
		Admin admin = V.entity(req, Admin.class, getParams);
		adminService.save(admin);
		
		req.setAttribute("info", "添加成功");
		
		JumpResult rs = new JumpResult();
		rs.setJumpUrl("/manager/admin/doBrowse.do");
		return rs;
	}
	
	public ApiResult validTel(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"tel"};
		V.isEmpty(req,params);
		String tel = req.getParameter("tel");
		boolean hasExist = adminService.validTel(tel);
		//返回客户端的结果
		ApiResult rs = ApiResult.build();
		Map<String,Boolean> info = new HashMap<String,Boolean>();
		info.put("exist", hasExist);
		rs.setData(info);
		return rs;
	}
	/**
	 * 验证email
	 * @param req
	 * @param resp
	 * @return
	 */
	public ApiResult validEmail(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"email"};
		V.isEmpty(req,params);
		String email = req.getParameter("email");
		boolean hasExist = adminService.validEmail(email);
		//返回客户端的结果
		ApiResult rs = ApiResult.build();
		Map<String,Boolean> info = new HashMap<String,Boolean>();
		info.put("exist", hasExist);
		rs.setData(info);
		return rs;
	}
	
	/**
	 * 浏览管理员信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public Result doBrowse(HttpServletRequest req,HttpServletResponse resp) {
		String curPageStr = V.getData(req, "page", "1");
		String pageSizeStr = V.getData(req, "page_size", "5");
		String keyword = V.getData(req, "keyword", "");
		int curPage = Integer.parseInt(curPageStr);
		int pageSize = Integer.parseInt(pageSizeStr);
		
		PageData<Admin> admins = adminService.list(curPage,pageSize,keyword);
		req.setAttribute("admins", admins);
		req.setAttribute("keyword", keyword);
		log.info("返回数据：" + admins);
		Result result = Result.build().setDispatchUrl("/admin/browse.do");
		return result;
	}
	
	/**
	 * 删除管理员信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public ApiResult del(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		adminService.delete(id);
		
		return ApiResult.build();
	}
	
	/**
	 * 更新前查找用户信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public Result edit(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		int id = Integer.parseInt(req.getParameter("id"));
		Admin admin = adminService.getAdminById(id);
		req.setAttribute("admin",admin);
		
		return Result.build().setDispatchUrl("/admin/update.do");
	}
	
	/**
	 * 更新用户信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public ApiResult doUpdate(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id","tel","email","real_name","work","salary"};
		String[] getParams = {"id","tel","email","real_name","marriage","work","salary","privilege"};
		V.isEmpty(req,params);
		Admin admin = V.entity(req, Admin.class, getParams);
		//调用service的修改方法
		
		adminService.update(admin);
		return ApiResult.build();
	}
	
	/**
	 * 查看用户详细信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public Result doFind(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		int id = Integer.parseInt(req.getParameter("id"));
		Admin admin = adminService.getAdminById(id);
		req.setAttribute("admin",admin);
		
		return Result.build().setDispatchUrl("/admin/find.do");
	}
	
	public JumpResult doLogin(HttpServletRequest req,HttpServletResponse resp) throws InvalidParamException {
		String[] params = {"tel","pwd"};
		V.isEmpty(req, params);
		Admin admin = V.entity(req, Admin.class, params);
		Admin existAdmin = adminService.login(admin);
		HttpSession session = req.getSession();
		session.setAttribute("admin", existAdmin);
		JumpResult jResult = new JumpResult();
		jResult.setJumpUrl("/manager/admin/welcome.do");
		
		return jResult;
	}
}
