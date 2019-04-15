package com.neuedu.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.manager.po.UserCost;

public interface UserCostMapper {
	/**
	 * 插入住户缴费信息
	 * @param userCost
	 */
	public void insert (UserCost userCost);
	
	/*
	 * 返回查找数据数量
	 */
	public int userCostListCount(@Param("keyword") String keyword);
	
	/*
	 * 返回查找的数据
	 */
	public List<UserCost> userCostList(@Param("begin")int begin,@Param("pageSize") int pageSize,@Param("keyword")  String keyword);

	/*
	 * 删除住户缴费信息
	 */
	public void delete(int id);
	
	/*
	 * 返回查找数据数量
	 */
	public int uUserCostListCount(@Param("userId") Long userId,@Param("keyword") String keyword);
	
	/*
	 * 返回查找的数据
	 */
	public List<UserCost> uUserCostList(@Param("userId") Long userId, @Param("begin")int begin,@Param("pageSize") int pageSize,@Param("keyword")  String keyword);
	
	/*
	 * 根据userid与costid查找缴费记录
	 */
	public UserCost getUserCost(@Param("userId")int userId,@Param("costId")int costId);
}
