package com.neuedu.manager.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.neuedu.manager.ex.InvalidParamException;
import com.neuedu.manager.po.User;
import com.neuedu.manager.service.UserService;
import com.neuedu.manager.service.UserServiceImpl;
import com.neuedu.manager.util.V;
import com.neuedu.manager.web.ApiResult;
import com.neuedu.manager.web.JumpResult;
import com.neuedu.manager.web.PageData;
import com.neuedu.manager.web.Result;

public class UserController {
	private UserService userService;
	private static Logger log = Logger.getLogger(UserController.class);
	
	public UserController() {
		userService = new UserServiceImpl();
	}
	/**
	 * 添加用户
	 * @param req
	 * @param resp
	 * @return
	 * @throws IOException
	 */
	public JumpResult doAdd(HttpServletRequest req,HttpServletResponse resp ) throws IOException {
		resp.getWriter().print("hello world");
		String[] params = {"name","id","gender","tel","email","house_message","house_situation"};
		String[] getParams = {"name","id","gender","nation","tel","email","house_message","house_situation","park_message","more"};
		V.isEmpty(req,params);
		User user = V.entity(req, User.class, getParams);
		userService.save(user);
		
		req.setAttribute("info", "添加成功");
		// 跳转的地址
		JumpResult rs = new JumpResult();
		rs.setJumpUrl("/manager/user/doBrowse.do");
		return rs;
	}
	/**
	 * 验证身份证号
	 * @param req
	 * @param resp
	 * @return
	 */
	public ApiResult validId(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"id"};
		V.isEmpty(req,params);
		String id = req.getParameter("id");
		boolean hasExist = userService.validId(id);
		ApiResult rs = ApiResult.build();
		Map<String,Boolean> info = new HashMap<String,Boolean>();
		info.put("exist", hasExist);
		rs.setData(info);
		return rs;
	}
	/**
	 * 验证电话号码
	 * @param req
	 * @param resp
	 * @return
	 */
	public ApiResult validTel(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"tel"};
		V.isEmpty(req,params);
		String tel = req.getParameter("tel");
		boolean hasExist = userService.validTel(tel);
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
		boolean hasExist = userService.validEmail(email);
		//返回客户端的结果
		ApiResult rs = ApiResult.build();
		Map<String,Boolean> info = new HashMap<String,Boolean>();
		info.put("exist", hasExist);
		rs.setData(info);
		return rs;
	}
	
	/**
	 * 浏览用户信息
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
		
		PageData<User> users = userService.list(curPage,pageSize,keyword);
		req.setAttribute("users", users);
		req.setAttribute("keyword", keyword);
		log.info("返回数据：" + users);
		Result result = Result.build().setDispatchUrl("/user/browse.do");
		return result;
	}
	
	/**
	 * 删除用户信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public ApiResult del(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"user_id"};
		V.isEmpty(req,params);
		String userIdStr = req.getParameter("user_id");
		int userId = Integer.parseInt(userIdStr);
		userService.delete(userId);
		
		return ApiResult.build();
	}
	
	/**
	 * 更新前查找用户信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public Result edit(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"user_id"};
		V.isEmpty(req,params);
		int userId = Integer.parseInt(req.getParameter("user_id"));
		User user = userService.getUserByUserId(userId);
		req.setAttribute("user",user);
		
		return Result.build().setDispatchUrl("/user/update.do");
	}
	
	/**
	 * 更新用户信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public ApiResult doUpdate(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"user_id","name","id","tel","email","house_message","house_situation"};
		String[] getParams = {"user_id","name","id","nation","tel","email","house_message","house_situation","park_message","more"};
		V.isEmpty(req,params);
		User user = V.entity(req, User.class, getParams);
		//调用service的修改方法
		
		userService.update(user);
		return ApiResult.build();
	}
	
	/**
	 * 查看用户详细信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public Result doFind(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"user_id"};
		V.isEmpty(req,params);
		int userId = Integer.parseInt(req.getParameter("user_id"));
		User user = userService.getUserByUserId(userId);
		req.setAttribute("user",user);
		
		return Result.build().setDispatchUrl("/user/find.do");
	}
	
	/**
	 * 用户注册
	 * @param req
	 * @param resp
	 * @return
	 */
	public Result doRegister(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"tel","email","pwd"};
		String[] getParams = {"tel","email","pwd"};
		V.isEmpty(req,params);
		User user = V.entity(req, User.class, getParams);
		userService.updatePwd(user);
		
		req.setAttribute("info", "添加成功");
		Result rs = Result.build().setDispatchUrl("/user/register.do");
		return rs;
	}
	
	/**
	 * 验证住户是否存在
	 * @param req
	 * @param resp
	 * @return
	 */
	public ApiResult existTelEmail(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"tel","email"};
		V.isEmpty(req,params);
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		boolean hasExist = userService.existTelEmail(tel, email);
		//返回客户端的结果
		ApiResult rs = ApiResult.build();
		Map<String,Boolean> info = new HashMap<String,Boolean>();
		info.put("exist", hasExist);
		rs.setData(info);
		return rs;
	}
	
	/**
	 * 验证是否设置过密码
	 * @param req
	 * @param resp
	 * @return
	 */
	public ApiResult existPwd(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"tel","email"};
		V.isEmpty(req,params);
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		boolean hasExist = userService.existPwd(tel, email);
		//返回客户端的结果
		ApiResult rs = ApiResult.build();
		Map<String,Boolean> info = new HashMap<String,Boolean>();
		info.put("exist", hasExist);
		rs.setData(info);
		return rs;
	}
	
	/**
	 * 手机号码登录
	 * @param req
	 * @param resp
	 * @return
	 * @throws InvalidParamException
	 */
	public JumpResult doTellogin(HttpServletRequest req,HttpServletResponse resp) throws InvalidParamException {
		String[] params = {"tel","pwd"};
		V.isEmpty(req, params);
		User user = V.entity(req, User.class, params);
		User existUser = userService.telLogin(user);
		HttpSession session = req.getSession();
		session.setAttribute("user", existUser);
		JumpResult jResult = new JumpResult();
		jResult.setJumpUrl("/manager/user/welcome.do");
		
		return jResult;
	}
	
	/**
	 * 电子邮箱登录
	 * @param req
	 * @param resp
	 * @return
	 * @throws InvalidParamException
	 */
	public JumpResult doEmaillogin(HttpServletRequest req,HttpServletResponse resp) throws InvalidParamException {
		String[] params = {"email","pwd"};
		V.isEmpty(req, params);
		User user = V.entity(req, User.class, params);
		User existUser = userService.emailLogin(user);
		HttpSession session = req.getSession();
		session.setAttribute("user", existUser);
		JumpResult jResult = new JumpResult();
		jResult.setJumpUrl("/manager/user/welcome.do");
		
		return jResult;
	}
	
	public Result doChangepwd(HttpServletRequest req,HttpServletResponse resp) {
		String[] params = {"tel","email","pwd","newpwd"};
		V.isEmpty(req,params);
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String newpwd = req.getParameter("newpwd");
		userService.changePwd(tel, email, pwd, newpwd);
		
		req.setAttribute("info", "添加成功");
		Result rs = Result.build().setDispatchUrl("/user/changepwd.do");
		return rs;
	}
}
