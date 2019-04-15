package com.neuedu.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.manager.po.Cost;

public interface CostMapper {
	/*
	 * 插入费用信息
	 */
	public void insert(Cost cost);
	
	/*
	 * 返回查找数据数量
	 */
	public int costListCount(@Param("keyword") String keyword);
	
	/*
	 * 返回查找的数据
	 */
	public List<Cost> costList(@Param("begin")int begin,@Param("pageSize") int pageSize,@Param("keyword")  String keyword);

	/*
	 * 删除费用信息
	 */
	public void delete(int id);
	
	/*
	 * 根据id查找费用金额
	 */
	public Double getPriceById(Long id);
}
