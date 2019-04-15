package com.neuedu.manager.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.neuedu.manager.po.Cost;
import com.neuedu.manager.service.CostService;
import com.neuedu.manager.service.CostServiceImpl;
import com.neuedu.manager.util.V;
import com.neuedu.manager.web.ApiResult;
import com.neuedu.manager.web.JumpResult;
import com.neuedu.manager.web.PageData;
import com.neuedu.manager.web.Result;

public class CostController {
	private CostService costService;
	private static Logger log = Logger.getLogger(CostController.class);
	
	public CostController() {
		costService = new CostServiceImpl();
	}
	
	/**
	 * 添加费用信息
	 * @param req
	 * @param resp
	 * @return
	 * @throws IOException
	 */
	public JumpResult doAdd(HttpServletRequest req,HttpServletResponse resp ) throws IOException {
		String[] params = {"cost_name","price"};
		String[] getParams = {"cost_name","price"};
		V.isEmpty(req,params);
		Cost cost = V.entity(req, Cost.class, getParams);
		costService.save(cost);
		
		req.setAttribute("info", "添加成功");
		
		JumpResult rs = new JumpResult();
		rs.setJumpUrl("/manager/cost/doBrowse.do");
		return rs;
	} 
	
	/**
	 * 浏览费用信息
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
		
		PageData<Cost> costs = costService.list(curPage,pageSize,keyword);
		req.setAttribute("costs", costs);
		req.setAttribute("keyword", keyword);
		log.info("返回数据：" + costs);
		Result result = Result.build().setDispatchUrl("/cost/browse.do");
		return result;
	}
	
	/**
	 * 删除费用信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public ApiResult del(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		costService.delete(id);
		
		return ApiResult.build();
	}
	
	public ApiResult findPrice(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		long id = Long.parseLong(req.getParameter("id"));
		Double price = costService.getPriceById(id);
		
		return ApiResult.build().setData(price);
	}
	
	/**
	 * 住户浏览费用信息
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
		
		PageData<Cost> costs = costService.list(curPage,pageSize,keyword);
		req.setAttribute("costs", costs);
		req.setAttribute("keyword", keyword);
		log.info("返回数据：" + costs);
		Result result = Result.build().setDispatchUrl("/cost/userBrowse.do");
		return result;
	}
}
