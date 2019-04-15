package com.neuedu.manager.service;

import com.neuedu.manager.po.Fix;
import com.neuedu.manager.web.PageData;

public interface FixService {
	/**
	 * 添加报修信息
	 * @param Fix
	 */
	public void save(Fix fix);
	
	/**
	 * 管理员查询报修信息
	 * @param curPage
	 * @param pageSize
	 * @param keyword
	 * @return
	 */
	public PageData<Fix> list(int curPage, int pageSize, String keyword);
	
	/**
	 * 删除报修信息
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 住户查询报修信息
	 * @param curPage
	 * @param pageSize
	 * @param keyword
	 * @return
	 */
	public PageData<Fix> userList(Long userId,int curPage, int pageSize, String keyword);
	
	/**
	 * 根据id查找报修信息
	 * @param id
	 * @return
	 */
	public Fix getFixById(int id);
	
	/**
	 * 更新报修信息
	 * @param Fix
	 */
	public void update(Fix fix);
	
	/**
	 * 回复报修信息
	 * @param Fix
	 */
	public void response(Fix fix);
	
	/**
	 * 管理员删除
	 * @param Fix
	 */
	public void adminDel(Long id);
}
