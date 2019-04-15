package com.neuedu.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.manager.po.Admin;


public interface AdminMapper {
	/*
	 * 插入管理员信息
	 */
	public void insert(Admin admin);
	
	/*
	 * 根据电话号码查找管理员
	 */
	public Admin getAdminByTel(String tel);
	
	/*
	 * 根据email查找管理员
	 */
	public Admin getAdminByEmail(String email);
	
	/*
	 * 返回查找数据数量
	 */
	public int adminListCount(@Param("keyword") String keyword);
	
	/*
	 * 返回查找的数据
	 */
	public List<Admin> adminList(@Param("begin")int begin,@Param("pageSize") int pageSize,@Param("keyword")  String keyword);

	/*
	 * 删除管理员信息
	 */
	public void delete(int id);
	
	/*
	 * 按id查找管理员信息
	 */
	public Admin getAdminById(int id);
	
	/*
	 * 根据id更新管理员信息
	 */
	public void updateById(Admin admin);
}
