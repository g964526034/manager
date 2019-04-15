package com.neuedu.manager.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.neuedu.manager.po.Admin;
import com.neuedu.manager.po.Announce;
import com.neuedu.manager.service.AnnounceService;
import com.neuedu.manager.service.AnnounceServiceImpl;
import com.neuedu.manager.util.V;
import com.neuedu.manager.web.ApiResult;
import com.neuedu.manager.web.JumpResult;
import com.neuedu.manager.web.PageData;
import com.neuedu.manager.web.Result;

public class AnnounceController {
	private AnnounceService announceService;
	private static Logger log = Logger.getLogger(AnnounceController.class);

	public AnnounceController() {
		announceService = new AnnounceServiceImpl();
	}
	
	/**
	 * 添加公告信息
	 * @param req
	 * @param resp
	 * @return
	 * @throws IOException
	 */
	public JumpResult doAdd(HttpServletRequest req,HttpServletResponse resp ) throws IOException {
		String[] params = {"title"};
		String[] getParams = {"title","content"};
		V.isEmpty(req,params);
		Announce announce = V.entity(req, Announce.class, getParams);
		HttpSession session = req.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		//admin.setRealName("郭泰奕");
		announce.setAdmin(admin);
		announceService.save(announce);
		
		req.setAttribute("info", "添加成功");
		
		JumpResult rs = new JumpResult();
		rs.setJumpUrl("/manager/announce/doBrowse.do");
		return rs;
	}
	
	/**
	 * 浏览公告信息
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
		
		PageData<Announce> announces = announceService.list(curPage,pageSize,keyword);
		req.setAttribute("announces", announces);
		req.setAttribute("keyword", keyword);
		log.info("返回数据：" + announces);
		Result result = Result.build().setDispatchUrl("/announce/browse.do");
		return result;
	}
	
	/**
	 * 删除公告信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public ApiResult del(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		announceService.delete(id);
		
		return ApiResult.build();
	}
	
	/**
	 * 更新前查找公告信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public Result edit(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		int id = Integer.parseInt(req.getParameter("id"));
		Announce announce = announceService.getAnnounceById(id);
		req.setAttribute("announce",announce);
		
		return Result.build().setDispatchUrl("/announce/update.do");
	}
	
	public ApiResult doUpdate(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"title"};
		String[] getParams = {"id","title","content"};
		V.isEmpty(req,params);
		Announce announce = V.entity(req, Announce.class, getParams);
		//调用service的修改方法
		
		announceService.update(announce);
		return ApiResult.build();
	}
	
	public Result doFind(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		int id = Integer.parseInt(req.getParameter("id"));
		Announce announce = announceService.getAnnounceById(id);
		req.setAttribute("announce",announce);
		
		return Result.build().setDispatchUrl("/announce/find.do");
	}
	
	public Result doUserBrowse(HttpServletRequest req,HttpServletResponse resp) {
		String curPageStr = V.getData(req, "page", "1");
		String pageSizeStr = V.getData(req, "page_size", "5");
		String keyword = V.getData(req, "keyword", "");
		int curPage = Integer.parseInt(curPageStr);
		int pageSize = Integer.parseInt(pageSizeStr);
		
		PageData<Announce> announces = announceService.list(curPage,pageSize,keyword);
		req.setAttribute("announces", announces);
		req.setAttribute("keyword", keyword);
		log.info("返回数据：" + announces);
		Result result = Result.build().setDispatchUrl("/announce/userBrowse.do");
		return result;
	}
	
	public Result doUserFind(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		int id = Integer.parseInt(req.getParameter("id"));
		Announce announce = announceService.getAnnounceById(id);
		req.setAttribute("announce",announce);
		
		return Result.build().setDispatchUrl("/announce/userFind.do");
	}
}
