package com.neuedu.manager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.neuedu.manager.po.Admin;
import com.neuedu.manager.po.Announce;
import com.neuedu.manager.po.Complain;
import com.neuedu.manager.po.User;
import com.neuedu.manager.service.ComplainService;
import com.neuedu.manager.service.ComplainServiceImpl;
import com.neuedu.manager.util.V;
import com.neuedu.manager.web.ApiResult;
import com.neuedu.manager.web.JumpResult;
import com.neuedu.manager.web.PageData;
import com.neuedu.manager.web.Result;

public class ComplainController {
	private ComplainService complainService;
	private static Logger log = Logger.getLogger(ComplainController.class);
	
	public ComplainController() {
		complainService = new ComplainServiceImpl();
	}
	
	/**
	 * 添加投诉信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public JumpResult doAdd(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"title"};
		String[] getParams = {"title","comp_message"};
		V.isEmpty(req,params);
		Complain complain = V.entity(req, Complain.class, getParams);
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		complain.setUser(user);
		complainService.save(complain);
		
		req.setAttribute("info", "添加成功");
		
		JumpResult rs = new JumpResult();
		rs.setJumpUrl("/manager/complain/doUserBrowse.do");
		return rs;
	}
	
	/**
	 * 管理员浏览投诉信息
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
		
		PageData<Complain> complains = complainService.list(curPage, pageSize, keyword);
		req.setAttribute("complains", complains);
		req.setAttribute("keyword", keyword);
		log.info("返回数据：" + complains);
		Result result = Result.build().setDispatchUrl("/complain/browse.do");
		return result;
	}
	
	/**
	 * 住户浏览投诉信息
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
		
		PageData<Complain> complains = complainService.userList(userId, curPage, pageSize, keyword);
		req.setAttribute("complains", complains);
		req.setAttribute("keyword", keyword);
		log.info("返回数据：" + complains);
		Result result = Result.build().setDispatchUrl("/complain/userBrowse.do");
		return result;
	}
	
	/**
	 * 删除投诉信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public ApiResult userDel(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		complainService.delete(id);
		
		return ApiResult.build();
	}
	
	public Result userEdit(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		int id = Integer.parseInt(req.getParameter("id"));
		Complain complain = complainService.getComplainById(id);
		req.setAttribute("complain",complain);
		
		return Result.build().setDispatchUrl("/complain/update.do");
	}
	
	public ApiResult doUpdate(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id","title"};
		String[] getParams = {"id","title","comp_message","solution"};
		V.isEmpty(req,params);
		Complain complain = V.entity(req, Complain.class, getParams);
		//调用service的修改方法
		
		complainService.update(complain);
		return ApiResult.build();
	}
	
	public Result doUserFind(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		int id = Integer.parseInt(req.getParameter("id"));
		Complain complain = complainService.getComplainById(id);
		req.setAttribute("complain",complain);
		
		return Result.build().setDispatchUrl("/complain/userFind.do");
	}
	
	public Result edit(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		int id = Integer.parseInt(req.getParameter("id"));
		Complain complain = complainService.getComplainById(id);
		req.setAttribute("complain",complain);
		
		return Result.build().setDispatchUrl("/complain/response.do");
	}
	
	public ApiResult doResponse(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id","response"};
		String[] getParams = {"id","response"};
		V.isEmpty(req,params);
		Complain complain = V.entity(req, Complain.class, getParams);
		HttpSession session = req.getSession();
		Admin admin = (Admin)session.getAttribute("admin");
		complain.setAdmin(admin);
		
		complainService.response(complain);
		return ApiResult.build();
	}
	
	public Result doFind(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		int id = Integer.parseInt(req.getParameter("id"));
		Complain complain = complainService.getComplainById(id);
		req.setAttribute("complain",complain);
		
		return Result.build().setDispatchUrl("/complain/find.do");
	}
	
	public ApiResult adminDel(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		String idStr = req.getParameter("id");
		Long id = Long.parseLong(idStr);
		complainService.adminDel(id);
		
		return ApiResult.build();
	}
}
