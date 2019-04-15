package com.neuedu.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.manager.po.Complain;

public interface ComplainMapper {
	/*
	 * 添加投诉信息
	 */
	public void insert(Complain complain);
	
	/*
	 * 返回查找数据数量
	 */
	public int complainListCount(@Param("keyword") String keyword);
	
	/*
	 * 返回查找的数据
	 */
	public List<Complain> complainList(@Param("begin")int begin,@Param("pageSize") int pageSize,@Param("keyword")  String keyword);
	
	
	/*
	 * 返回查找数据数量
	 */
	public int userComplainListCount(@Param("userId") Long userId,@Param("keyword") String keyword);
	
	/*
	 * 返回查找的数据
	 */
	public List<Complain> userComplainList(@Param("userId") Long userId, @Param("begin")int begin,@Param("pageSize") int pageSize,@Param("keyword")  String keyword);
	
	/*
	 * 删除管理员信息
	 */
	public void delete(int id);
	
	/*
	 * 根据id查找投诉信息
	 */
	public Complain getComplainById(int id);
	
	/*
	 * 住户更新投诉信息
	 */
	public void updateById(Complain complain);
	
	/*
	 * 管理员回复投诉信息
	 */
	public void responseById(Complain complain);
	
	/*
	 * 
	 */
	public void adminDel(Long id);
}
