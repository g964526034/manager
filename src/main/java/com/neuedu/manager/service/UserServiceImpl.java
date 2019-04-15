package com.neuedu.manager.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.manager.ex.InvalidParamException;
import com.neuedu.manager.mapper.UserMapper;
import com.neuedu.manager.po.User;
import com.neuedu.manager.util.D;
import com.neuedu.manager.util.GlobalInfo;
import com.neuedu.manager.web.PageData;

public class UserServiceImpl implements UserService{
	private UserMapper userMapper;
	public UserServiceImpl() {
		SqlSession sqlSession = D.open();
		userMapper = sqlSession.getMapper(UserMapper.class);
	}
	/*
	 * 添加用户
	 * @see com.neuedu.manager.service.UserService#save(com.neuedu.manager.po.User)
	 */
	public void save(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
	}

	public boolean validId(String id) {
		User user = userMapper.getUserById(id);
		if (user != null) {
			return true;
		}
		return false;
	}
	
	public boolean validTel(String tel) {
		User user = userMapper.getUserByTel(tel);
		if (user != null) {
			return true;
		}
		return false;
	}
	
	public boolean validEmail(String email) {
		User user = userMapper.getUserByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}
	
	/*
	 * 按条件查询
	 * @see com.neuedu.manager.service.UserService#list(int, int, java.lang.String)
	 */
	public PageData<User> list(int curPage, int pageSize, String keyword) {
		int totalRecord = userMapper.userListCount(keyword);
		int begin = (curPage - 1) * pageSize;
		List<User> data = userMapper.userList(begin, pageSize, keyword);
		
		PageData<User> pageData = new PageData<User>(pageSize,curPage);
		pageData.setTotalRecord(totalRecord);
		pageData.setData(data);
		return pageData;
	}
	
	/*
	 * 按id删除住户信息
	 * @see com.neuedu.manager.service.UserService#delete(int)
	 */
	public void delete(int userId) {
		// TODO Auto-generated method stub
		userMapper.delete(userId);
	}
	
	/*
	 * 按userId查找用户
	 * @see com.neuedu.manager.service.UserService#getUserByUserId(int)
	 */
	public User getUserByUserId(int userId) {
		return userMapper.getUserByUserId(userId);
	}
	
	/*
	 * 根据userId删除数据
	 * @see com.neuedu.manager.service.UserService#update(com.neuedu.manager.po.User)
	 */
	public void update(User user) {
		userMapper.updateByUserId(user);
	}
	
	/*
	 * 根据tel与email查找用户
	 * @see com.neuedu.manager.service.UserService#existTelEmail(java.lang.String, java.lang.String)
	 */
	public boolean existTelEmail(String tel, String email) {
		if(userMapper.getUserByTel(tel) != null && userMapper.getUserByEmail(email) != null) {
			User u1 = userMapper.getUserByTel(tel);
			User u2 = userMapper.getUserByEmail(email);
			if(u1.getUserId() == u2.getUserId()) {
				return true;
			}
		} else {
			return false;
		}
		return false;
	}
	
	/*
	 * 更新密码
	 * @see com.neuedu.manager.service.UserService#updatePwd(java.lang.String, java.lang.String)
	 */
	public void updatePwd(User user) {
		// TODO Auto-generated method stub
		userMapper.updatePwd(user);
	}
	
	/*
	 * 确认是否设置密码
	 * @see com.neuedu.manager.service.UserService#existPwd(java.lang.String, java.lang.String)
	 */
	public boolean existPwd(String tel, String email) {
		if(!userMapper.getPwd(tel, email).getPwd().equals("")) {
			return true;
		}
		return false;
	}
	
	/*
	 * 手机号登录
	 * @see com.neuedu.manager.service.UserService#telLogin(com.neuedu.manager.po.User)
	 */
	public User telLogin(User user) throws InvalidParamException {
		User existUser = userMapper.getUserByTel(user.getTel());
		if(existUser == null) {
			throw new InvalidParamException(GlobalInfo.USER_INFO_ERROR_CODE, GlobalInfo.USER_INFO_ERROR_MSG);
		}
		if(!existUser.getPwd().equals(user.getPwd())) {
			throw new InvalidParamException(GlobalInfo.USER_INFO_ERROR_CODE, GlobalInfo.USER_INFO_ERROR_MSG);
		}
		return existUser;
	}
	
	/*
	 * email登录
	 * @see com.neuedu.manager.service.UserService#emailLogin(com.neuedu.manager.po.User)
	 */
	public User emailLogin(User user) throws InvalidParamException {
		User existUser = userMapper.getUserByEmail(user.getEmail());
		if(existUser == null) {
			throw new InvalidParamException(GlobalInfo.USER_INFO_ERROR_CODE, GlobalInfo.USER_INFO_ERROR_MSG);
		}
		if(!existUser.getPwd().equals(user.getPwd())) {
			throw new InvalidParamException(GlobalInfo.USER_INFO_ERROR_CODE, GlobalInfo.USER_INFO_ERROR_MSG);
		}
		return existUser;
	}
	public void changePwd(String tel, String email, String pwd,String newpwd) {
		// TODO Auto-generated method stub
		userMapper.changePwd(tel, email, pwd, newpwd);
	}
}
