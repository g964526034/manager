package com.neuedu.manager.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.manager.ex.InvalidParamException;
import com.neuedu.manager.mapper.AdminMapper;
import com.neuedu.manager.po.Admin;
import com.neuedu.manager.util.D;
import com.neuedu.manager.util.GlobalInfo;
import com.neuedu.manager.web.PageData;

public class AdminServiceImpl implements AdminService{
	private AdminMapper adminMapper;
	public AdminServiceImpl() {
		SqlSession sqlSession = D.open();
		adminMapper = sqlSession.getMapper(AdminMapper.class);
	}
	/*
	 * 添加管理员
	 * @see com.neuedu.manager.service.AdminService#save(com.neuedu.manager.po.Admin)
	 */
	public void save(Admin admin) {
		// TODO Auto-generated method stub
		adminMapper.insert(admin);
	}
	
	/*
	 * 验证手机号是否存在
	 * @see com.neuedu.manager.service.AdminService#validTel(java.lang.String)
	 */
	public boolean validTel(String tel) {
		Admin admin = adminMapper.getAdminByTel(tel);
		if (admin != null) {
			return true;
		}
		return false;
	}
	
	/*
	 * 验证email是否存在
	 * @see com.neuedu.manager.service.AdminService#validEmail(java.lang.String)
	 */
	public boolean validEmail(String email) {
		Admin admin = adminMapper.getAdminByEmail(email);
		if (admin != null) {
			return true;
		}
		return false;
	}
	
	/*
	 * 浏览管理员信息
	 * @see com.neuedu.manager.service.AdminService#list(int, int, java.lang.String)
	 */
	public PageData<Admin> list(int curPage, int pageSize, String keyword) {
		int totalRecord = adminMapper.adminListCount(keyword);
		int begin = (curPage - 1) * pageSize;
		List<Admin> data = adminMapper.adminList(begin, pageSize, keyword);
		
		PageData<Admin> pageData = new PageData<Admin>(pageSize,curPage);
		pageData.setTotalRecord(totalRecord);
		pageData.setData(data);
		return pageData;
	}
	
	/*
	 * 删除管理员信息
	 * @see com.neuedu.manager.service.AdminService#delete(int)
	 */
	public void delete(int id) {
		// TODO Auto-generated method stub
		adminMapper.delete(id);
	}
	
	/*
	 * 按id查找管理员信息
	 * @see com.neuedu.manager.service.AdminService#getAdminById(int)
	 */
	public Admin getAdminById(int id) {
		return adminMapper.getAdminById(id);
		
	}
	
	/*
	 * 根据id删除数据
	 * @see com.neuedu.manager.service.UserService#update(com.neuedu.manager.po.User)
	 */
	public void update(Admin admin) {
		adminMapper.updateById(admin);
	}
	
	/*
	 * 管理员登录
	 * @see com.neuedu.manager.service.AdminService#login(com.neuedu.manager.po.Admin)
	 */
	public Admin login(Admin admin) throws InvalidParamException {
		Admin existAdmin = adminMapper.getAdminByTel(admin.getTel());
		if(existAdmin == null) {
			throw new InvalidParamException(GlobalInfo.USER_INFO_ERROR_CODE, GlobalInfo.USER_INFO_ERROR_MSG);
		}
		if(!existAdmin.getPwd().equals(admin.getPwd())) {
			throw new InvalidParamException(GlobalInfo.USER_INFO_ERROR_CODE, GlobalInfo.USER_INFO_ERROR_MSG);
		}
		return existAdmin;
	}
}
