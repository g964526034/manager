package com.neuedu.manager.service;

import com.neuedu.manager.po.UserCost;
import com.neuedu.manager.web.PageData;

public interface UserCostService {
	/**
	 * 添加缴费信息
	 * @param userCost
	 */
	public void save(UserCost userCost);
	
	/**
	 * 浏览缴费信息
	 * @param curPage
	 * @param pageSize
	 * @param keyword
	 * @return
	 */
	public PageData<UserCost> list(int curPage, int pageSize, String keyword);
	
	/**
	 * 删除缴费信息
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 住户查询缴费信息
	 * @param userId
	 * @param curPage
	 * @param pageSize
	 * @param keyword
	 * @return
	 */
	public PageData<UserCost> userList(Long userId,int curPage, int pageSize, String keyword);
	
	/**
	 * 查看缴费记录是否存在
	 * @param userId
	 * @param costId
	 * @return
	 */
	public boolean existUserCost(int userId,int costId);
}
