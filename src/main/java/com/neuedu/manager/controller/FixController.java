package com.neuedu.manager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.neuedu.manager.po.Admin;
import com.neuedu.manager.po.Fix;
import com.neuedu.manager.po.User;
import com.neuedu.manager.service.FixService;
import com.neuedu.manager.service.FixServiceImpl;
import com.neuedu.manager.util.V;
import com.neuedu.manager.web.ApiResult;
import com.neuedu.manager.web.JumpResult;
import com.neuedu.manager.web.PageData;
import com.neuedu.manager.web.Result;

public class FixController {
	private FixService fixService;
	private static Logger log = Logger.getLogger(FixController.class);
	
	public FixController() {
		fixService = new FixServiceImpl();
	}
	
	/**
	 * 添加报修信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public JumpResult doAdd(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"title"};
		String[] getParams = {"title","fix_message"};
		V.isEmpty(req,params);
		Fix fix = V.entity(req, Fix.class, getParams);
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		fix.setUser(user);
		fixService.save(fix);
		
		req.setAttribute("info", "添加成功");
		
		JumpResult rs = new JumpResult();
		rs.setJumpUrl("/manager/fix/doUserBrowse.do");
		return rs;
	}
	
	/**
	 * 管理员浏览报修信息
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
		
		PageData<Fix> fixs = fixService.list(curPage, pageSize, keyword);
		req.setAttribute("fixs", fixs);
		req.setAttribute("keyword", keyword);
		log.info("返回数据：" + fixs);
		Result result = Result.build().setDispatchUrl("/fix/browse.do");
		return result;
	}
	
	/**
	 * 住户浏览报修信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public Result doUserBrowse(HttpServletRequest req,HttpServletResponse resp) {
		String curPageStr = V.getData(req, "page", "1");
		String pageSizeStr = V.getData(req, "page_size", "5");
		String keyword = V.getData(req, "keyword", "");
		int curPage = Integer.parseInt(curPageStr);
		int pageSize = Integer.parseInt(pageSizeStr);
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("user");
		Long userId = user.getUserId();
		
		PageData<Fix> fixs = fixService.userList(userId, curPage, pageSize, keyword);
		req.setAttribute("fixs", fixs);
		req.setAttribute("keyword", keyword);
		log.info("返回数据：" + fixs);
		Result result = Result.build().setDispatchUrl("/fix/userBrowse.do");
		return result;
	}
	
	/**
	 * 删除报修信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public ApiResult userDel(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		fixService.delete(id);
		
		return ApiResult.build();
	}
	
	public Result userEdit(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		int id = Integer.parseInt(req.getParameter("id"));
		Fix fix = fixService.getFixById(id);
		req.setAttribute("fix",fix);
		
		return Result.build().setDispatchUrl("/fix/update.do");
	}
	
	public ApiResult doUpdate(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id","title"};
		String[] getParams = {"id","title","fix_message","solution"};
		V.isEmpty(req,params);
		Fix fix = V.entity(req, Fix.class, getParams);
		//调用service的修改方法
		
		fixService.update(fix);
		return ApiResult.build();
	}
	
	public Result doUserFind(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		int id = Integer.parseInt(req.getParameter("id"));
		Fix fix = fixService.getFixById(id);
		req.setAttribute("fix",fix);
		
		return Result.build().setDispatchUrl("/fix/userFind.do");
	}
	
	public Result edit(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		int id = Integer.parseInt(req.getParameter("id"));
		Fix fix = fixService.getFixById(id);
		req.setAttribute("fix",fix);
		
		return Result.build().setDispatchUrl("/fix/response.do");
	}
	
	public ApiResult doResponse(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id","response"};
		String[] getParams = {"id","response"};
		V.isEmpty(req,params);
		Fix fix = V.entity(req, Fix.class, getParams);
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		fix.setAdmin(admin);
		
		fixService.response(fix);
		return ApiResult.build();
	}
	
	public Result doFind(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		int id = Integer.parseInt(req.getParameter("id"));
		Fix fix = fixService.getFixById(id);
		req.setAttribute("fix",fix);
		
		return Result.build().setDispatchUrl("/fix/find.do");
	}
	
	public ApiResult adminDel(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		String idStr = req.getParameter("id");
		Long id = Long.parseLong(idStr);
		fixService.adminDel(id);
		
		return ApiResult.build();
	}
}
