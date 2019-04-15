package com.neuedu.manager.service;

import com.neuedu.manager.po.Complain;
import com.neuedu.manager.web.PageData;

public interface ComplainService {
	/**
	 * 添加投诉信息
	 * @param complain
	 */
	public void save(Complain complain);
	
	/**
	 * 管理员查询投诉信息
	 * @param curPage
	 * @param pageSize
	 * @param keyword
	 * @return
	 */
	public PageData<Complain> list(int curPage, int pageSize, String keyword);
	
	/**
	 * 删除投诉信息
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 住户查询投诉信息
	 * @param userId
	 * @param curPage
	 * @param pageSize
	 * @param keyword
	 * @return
	 */
	public PageData<Complain> userList(Long userId,int curPage, int pageSize, String keyword);
	
	/**
	 * 根据id查找投诉信息
	 * @param id
	 * @return
	 */
	public Complain getComplainById(int id);
	
	/**
	 * 更新投诉信息
	 * @param complain
	 */
	public void update(Complain complain);
	
	/**
	 * 回复投诉信息
	 * @param complain
	 */
	public void response(Complain complain);
	
	/**
	 * 管理员删除
	 * @param complain
	 */
	public void adminDel(Long id);
}
