package com.neuedu.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.manager.po.Fix;

public interface FixMapper {
	/*
	 * 添加投诉信息
	 */
	public void insert(Fix fix);
	
	/*
	 * 返回查找数据数量
	 */
	public int fixListCount(@Param("keyword") String keyword);
	
	/*
	 * 返回查找的数据
	 */
	public List<Fix> fixList(@Param("begin")int begin,@Param("pageSize") int pageSize,@Param("keyword")  String keyword);
	
	
	/*
	 * 返回查找数据数量
	 */
	public int userFixListCount(@Param("userId") Long userId,@Param("keyword") String keyword);
	
	/*
	 * 返回查找的数据
	 */
	public List<Fix> userFixList(@Param("userId") Long userId, @Param("begin")int begin,@Param("pageSize") int pageSize,@Param("keyword")  String keyword);
	
	/*
	 * 删除管理员信息
	 */
	public void delete(int id);
	
	/*
	 * 根据id查找投诉信息
	 */
	public Fix getFixById(int id);
	
	/*
	 * 住户更新投诉信息
	 */
	public void updateById(Fix fix);
	
	/*
	 * 管理员回复投诉信息
	 */
	public void responseById(Fix fix);
	
	/*
	 * 
	 */
	public void adminDel(Long id);
}
