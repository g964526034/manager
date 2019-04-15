package com.neuedu.manager.service;

import com.neuedu.manager.ex.InvalidParamException;
import com.neuedu.manager.po.Admin;
import com.neuedu.manager.web.PageData;

public interface AdminService {
	/**
	 * 添加管理员
	 * @param admin
	 */
	public void save(Admin admin);
	
	/**
	 * 判断电话号码是否合法
	 * @param tel
	 * @return
	 */
	public boolean validTel(String tel);
	
	/**
	 * 判断email是否合法
	 * @param tel
	 * @return
	 */
	public boolean validEmail(String email);
	
	/**
	 * 浏览管理员信息
	 * @param curPage
	 * @param pageSize
	 * @param key
	 * @return
	 */
	public PageData<Admin> list(int curPage,int pageSize,String keyword);
	
	/**
	 * 删除管理员信息
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 按id查找管理员信息
	 * @param id
	 * @return
	 */
	public Admin getAdminById(int id);
	
	/**
	 * 更新管理员信息
	 * @param admin
	 */
	public void update(Admin admin);
	
	/**
	 * 管理员登录
	 * @param admin
	 * @return
	 */
	public Admin login(Admin admin) throws InvalidParamException;
}
