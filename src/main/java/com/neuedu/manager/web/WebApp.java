package com.neuedu.manager.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.manager.ex.BaseException;
import com.neuedu.manager.util.D;
import com.neuedu.manager.util.NameUtil;
import com.neuedu.manager.web.filter.LogFilter;
import com.neuedu.manager.web.filter.MyFilter;
import com.neuedu.manager.web.filter.MyFilterChain;
import com.neuedu.manager.web.filter.PrivilegeFilter;
import com.neuedu.manager.web.filter.WhiteListFilter;
@WebServlet(urlPatterns= {"*.do","*.json"})
public class WebApp extends HttpServlet	{
	private static Logger log = Logger.getLogger(WebApp.class);
	
	private static final String PROJECT_NAME = "/manager/";
	private static final String CTR_PKG = "com.neuedu.manager.controller";
	private static ObjectMapper objMapper = new ObjectMapper();
	
	//http://localhost:8080/215/goods/add
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String uri = req.getRequestURI();
		String type = "do";
		if(uri.endsWith(".json")) {
			type = "json";
		}
		
		uri = uri.replace(PROJECT_NAME, "").replace(".do", "").replace(".json", "");
		String[] uris = uri.split("/");
		
		req.setAttribute("cur_url", uri);
		try {
			MyFilterChain chain = new MyFilterChain();
			MyFilter logFilter = new LogFilter();
			MyFilter whiteListFilter = new WhiteListFilter();
			MyFilter privilegeFilter = new PrivilegeFilter();
			
			chain.addFilter(logFilter)
				.addFilter(whiteListFilter)
				.addFilter(privilegeFilter);
			chain.doFilter(req, resp);
			
			
			//
			if(uris.length < 2) {
				throw new RuntimeException("请求地址错误");
			}
			String className = CTR_PKG + "." + NameUtil.toCamel(uris[0],true) + "Controller";
			String methodName = NameUtil.toCamel(uris[1],false);
			
			Class clz = Class.forName(className);
			Object instance = clz.newInstance();
			Method method = clz.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			Object returnResult = method.invoke(instance, req,resp);
			//把结果转发到指定页面
			if(returnResult != null) {
				//转发逻辑
				if(returnResult instanceof Result) {
					Result rs = (Result)returnResult;
					req.getRequestDispatcher(rs.getDispatchUrl()).forward(req, resp);
				}
				//跳转逻辑
				if(returnResult instanceof JumpResult) {
					JumpResult rs = (JumpResult) returnResult;
					resp.sendRedirect(rs.getJumpUrl());
				}
				//json处理逻辑
				if(returnResult instanceof ApiResult) {
					ApiResult rs = (ApiResult)returnResult;
					
					String rsStr = objMapper.writeValueAsString(rs);
					resp.getWriter().print(rsStr);
					
				}
			}
		} catch (NoSuchMethodException e) {
			//e.printStackTrace();
			//如果请求方法不存在，则直接渲染jsp页面
			req.getRequestDispatcher("/WEB-INF/jsp/" + uri + ".jsp").forward(req, resp);
		} catch (InvocationTargetException e) {
			Throwable target = e.getTargetException();
			if(target instanceof BaseException) {
				BaseException myException = (BaseException) target;
				//普通请求的异常处理
				if(type.equals("do")) {
					String pageName = uris[1].replace("do", "").toLowerCase();
					String info = myException.getMessage();
					req.setAttribute("errInfo", info);
					log.info("返回：" + info );
					req.getRequestDispatcher("/WEB-INF/jsp/"+ uris[0] + "/" + pageName +".jsp").forward(req, resp);
				}
				
				//ajax请求的异常处理
				if(type.equals("json")) {
					ApiResult rs = ApiResult.build();
					rs.setCode(myException.getCode());
					rs.setMsg(myException.getMessage());
					String rsStr = objMapper.writeValueAsString(rs);
					resp.getWriter().print(rsStr);
				}
			} else {
				e.printStackTrace();
			}
			
			D.rollBack();
		} catch (Exception e) {
			e.printStackTrace();
			D.rollBack();
			resp.sendError(500,e.getMessage());
		} finally {
			D.close();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
