package com.neuedu.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neuedu.manager.po.User;

public interface UserMapper {
	/*
	 * 插入教师信息
	 */
	public void insert(User user);
	
	/*
	 * 根据身份证号查找用户
	 */
	public User getUserById(String id);
	
	/*
	 * 根据电话号码查找用户
	 */
	public User getUserByTel(String tel);
	
	/*
	 * 根据email查找用户
	 */
	public User getUserByEmail(String email);
	
	/*
	 * 返回查找数据数量
	 */
	public int userListCount(@Param("keyword") String keyword);
	
	/*
	 * 返回查找的数据
	 */
	public List<User> userList(@Param("begin")int begin,@Param("pageSize") int pageSize,@Param("keyword")  String keyword);
	
	/*
	 * 删除住户信息
	 */
	public void delete(int userId);
	
	/*
	 * 按user_id查找用户信息
	 */
	public User getUserByUserId(int userId);
	
	/*
	 * 根据userId更新用户信息
	 */
	public void updateByUserId(User user);
	
	/*
	 * 更新密码
	 */
	public void updatePwd(User user);
	
	/*
	 * 查找是否已有密码
	 */
	public User getPwd(@Param("tel")String tel,@Param("email")String email);
	
	/*
	 * 修改密码
	 */
	public void changePwd(@Param("tel")String tel,@Param("email")String email,@Param("pwd")String pwd,@Param("newpwd")String newpwd);
}
