package com.neuedu.manager.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.neuedu.manager.po.Complain;
import com.neuedu.manager.po.Cost;
import com.neuedu.manager.po.User;
import com.neuedu.manager.po.UserCost;
import com.neuedu.manager.service.CostService;
import com.neuedu.manager.service.CostServiceImpl;
import com.neuedu.manager.service.UserCostService;
import com.neuedu.manager.service.UserCostServiceImpl;
import com.neuedu.manager.service.UserService;
import com.neuedu.manager.service.UserServiceImpl;
import com.neuedu.manager.util.V;
import com.neuedu.manager.web.ApiResult;
import com.neuedu.manager.web.JumpResult;
import com.neuedu.manager.web.PageData;
import com.neuedu.manager.web.Result;

public class UserCostController {
	private UserCostService userCostService;
	private UserService userService;
	private CostService costService;
	private static Logger log = Logger.getLogger(UserCostController.class);
	
	public UserCostController() {
		userCostService = new UserCostServiceImpl();
		userService = new UserServiceImpl();
		costService = new CostServiceImpl();
	}
	
	public Result edit(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"user_id"};
		V.isEmpty(req,params);
		int userId = Integer.parseInt(req.getParameter("user_id"));
		User user = userService.getUserByUserId(userId);
		req.setAttribute("user",user);
		PageData<Cost> costs = costService.list(1, 100, "");
		req.setAttribute("costs", costs.getData());
		Object obj = req.getAttribute("cost");
		return Result.build().setDispatchUrl("/user_cost/add.do");
	}
	
	public JumpResult doAdd(HttpServletRequest req,HttpServletResponse resp ) {
		
		String[] params = {"cost_num"};
		V.isEmpty(req, params);
		UserCost userCost = V.entity(req, UserCost.class, params);
		Long userId = Long.parseLong(req.getParameter("user_id"));
		User user = new User();
		user.setUserId(userId);
		userCost.setUser(user);
		Long costId = Long.parseLong(req.getParameter("cost_name")) ;
		Cost cost = new Cost();
		cost.setId(costId);
		userCost.setCost(cost);
		userCostService.save(userCost);
		req.setAttribute("info", "添加成功");
		
		JumpResult rs = new JumpResult();
		rs.setJumpUrl("/manager/user_cost/doBrowse.do");
		return rs;
	}
	
	public Result doBrowse(HttpServletRequest req,HttpServletResponse resp) {
		String curPageStr = V.getData(req, "page", "1");
		String pageSizeStr = V.getData(req, "page_size", "5");
		String keyword = V.getData(req, "keyword", "");
		int curPage = Integer.parseInt(curPageStr);
		int pageSize = Integer.parseInt(pageSizeStr);
		
		PageData<UserCost> userCosts = userCostService.list(curPage, pageSize, keyword);
		req.setAttribute("userCosts", userCosts);
		req.setAttribute("keyword", keyword);
		log.info("返回数据：" + userCosts);
		Result result = Result.build().setDispatchUrl("/user_cost/browse.do");
		return result;
	}
	
	public ApiResult del(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		userCostService.delete(id);
		
		return ApiResult.build();
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
		
		PageData<UserCost> userCosts = userCostService.userList(userId, curPage, pageSize, keyword);
		req.setAttribute("userCosts", userCosts);
		req.setAttribute("keyword", keyword);
		log.info("返回数据：" + userCosts);
		Result result = Result.build().setDispatchUrl("/user_cost/userBrowse.do");
		return result;
	}
	
	/**
	 * 查看缴费记录是否存在
	 * @param req
	 * @param resp
	 * @return
	 */
	public ApiResult validUserCost(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"user_id","cost_name"};
		V.isEmpty(req,params);
		int userId = Integer.parseInt(req.getParameter("user_id"));
		int costId = Integer.parseInt(req.getParameter("cost_name"));
		boolean hasExist = userCostService.existUserCost(userId, costId);
		ApiResult rs = ApiResult.build();
		Map<String,Boolean> info = new HashMap<String,Boolean>();
		info.put("exist", hasExist);
		rs.setData(info);
		return rs;
	}
}
