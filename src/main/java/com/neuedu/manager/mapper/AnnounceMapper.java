package com.neuedu.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.manager.po.Announce;

public interface AnnounceMapper {
	/*
	 * 插入公告信息
	 */
	public void insert(Announce announce);
	
	/*
	 * 返回查找数据数量
	 */
	public int announceListCount(@Param("keyword") String keyword);
	
	/*
	 * 返回查找的数据
	 */
	public List<Announce> announceList(@Param("begin")int begin,@Param("pageSize") int pageSize,@Param("keyword")  String keyword);

	/*
	 * 删除公告信息
	 */
	public void delete(int id);
	
	/*
	 * 按id查找公告信息
	 */
	public Announce getAnnounceById(int id);
	
	/*
	 * 根据更新公告信息
	 */
	public void updateById(Announce announce);
}
