package com.neuedu.manager.service;



import com.neuedu.manager.ex.InvalidParamException;
import com.neuedu.manager.po.User;
import com.neuedu.manager.web.PageData;

public interface UserService {
	/**
	 * 添加数据
	 * @param user
	 */
	public void save(User user);
	
	/**
	 * 判断身份证号是否合法
	 * @param id
	 * @return
	 */
	public boolean validId(String id);
	
	/**
	 * 判断电话号码是否合法
	 * @param tel
	 * @return
	 */
	public boolean validTel(String tel);
	
	/**
	 * 判断email是否合法
	 * @param tel
	 * @return
	 */
	public boolean validEmail(String email);
	
	/**
	 * 浏览住户信息
	 * @param curPage
	 * @param pageSize
	 * @param key
	 * @return
	 */
	public PageData<User> list(int curPage,int pageSize,String keyword);
	
	/**
	 * 删除住户信息
	 * @param userId
	 */
	public void delete(int userId);
	
	/**
	 * 按id查找住户
	 * @param userId
	 * @return
	 */
	public User getUserByUserId(int userId);
	
	/**
	 * 根据userId删除数据
	 * @param user
	 */
	public void update(User user);
	
	/**
	 * 根据tel与email查找住户
	 * @param tel
	 * @param email
	 * @return
	 */
	public boolean existTelEmail(String tel,String email);
	
	/**
	 * 更新密码
	 * @param tel
	 * @param email
	 */
	public void updatePwd(User user);
	
	/**
	 * 查看是否设置过密码
	 * @param tel
	 * @param email
	 * @return
	 */
	public boolean existPwd(String tel,String email);
	
	/**
	 * 手机号登录
	 * @param user
	 * @return
	 * @throws InvalidParamException
	 */
	public User telLogin(User user) throws InvalidParamException;
	
	/**
	 * email登录
	 * @param user
	 * @return
	 * @throws InvalidParamException
	 */
	public User emailLogin(User user) throws InvalidParamException;
	
	/**
	 * 修改密码
	 * @param tel
	 * @param email
	 * @param pwd
	 */
	public void changePwd(String tel,String email,String pwd,String newpwd);
}
