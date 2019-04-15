package com.neuedu.manager.service;

import com.neuedu.manager.po.Announce;
import com.neuedu.manager.web.PageData;

public interface AnnounceService {
	/**
	 * 添加公告信息
	 * @param announce
	 */
	public void save(Announce announce);
	
	/**
	 * 浏览公告信息
	 * @param curPage
	 * @param pageSize
	 * @param keyword
	 * @return
	 */
	public PageData<Announce> list(int curPage, int pageSize, String keyword);
	
	/**
	 * 删除公告信息
	 * @param id
	 */
	public void delete(int id);
	
	/**
	 * 按id查找公告信息
	 * @param id
	 * @return
	 */
	public Announce getAnnounceById(int id);
	
	/**
	 * 更新公告信息
	 * @param admin
	 */
	public void update(Announce announce);
}
