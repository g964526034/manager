package com.neuedu.manager.service;

import com.neuedu.manager.po.Cost;
import com.neuedu.manager.web.PageData;

public interface CostService {
	/**
	 * 添加费用信息
	 * @param cost
	 */
	public void save(Cost cost);
	
	/**
	 * 浏览费用信息
	 * @param curPage
	 * @param pageSize
	 * @param keyword
	 * @return
	 */
	public PageData<Cost> list(int curPage, int pageSize, String keyword);
	
	/**
	 * 删除费用信息
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 根据id查找费用单价
	 * @param id
	 * @return
	 */
	public Double getPriceById(Long id);
}
