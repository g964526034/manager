package com.neuedu.manager.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.manager.mapper.ComplainMapper;
import com.neuedu.manager.po.Admin;
import com.neuedu.manager.po.Complain;
import com.neuedu.manager.util.D;
import com.neuedu.manager.web.PageData;

public class ComplainServiceImpl implements ComplainService{
	private ComplainMapper complainMapper;
	public ComplainServiceImpl() {
		SqlSession sqlSession = D.open();
		complainMapper = sqlSession.getMapper(ComplainMapper.class);
	}
	
	/*
	 * 添加投诉信息
	 * @see com.neuedu.manager.service.ComplainService#save(com.neuedu.manager.po.Complain)
	 */
	public void save(Complain complain) {
		// TODO Auto-generated method stub
		complainMapper.insert(complain);
	}
	
	/*
	 * 查询投诉信息
	 * @see com.neuedu.manager.service.ComplainService#list(int, int, java.lang.String)
	 */
	public PageData<Complain> list(int curPage, int pageSize, String keyword) {
		int totalRecord = complainMapper.complainListCount(keyword);
		int begin = (curPage - 1) * pageSize;
		Admin admin = new Admin();
		admin.setRealName("");
		List<Complain> data = complainMapper.complainList(begin, pageSize, keyword);
		for(Complain c:data) {
			if(c.getAdmin()!=null) {
				continue;
			} else {
				c.setAdmin(admin);
			}
		}
		PageData<Complain> pageData = new PageData<Complain>(pageSize,curPage);
		pageData.setTotalRecord(totalRecord);
		pageData.setData(data);
		return pageData;
	}
	
	/*
	 * 删除投诉信息
	 * @see com.neuedu.manager.service.ComplainService#delete(int)
	 */
	public void delete(int id) {
		// TODO Auto-generated method stub
		complainMapper.delete(id);
	}
	
	/*
	 * 住户查看投诉信息
	 * @see com.neuedu.manager.service.ComplainService#userList(java.lang.Long, int, int, java.lang.String)
	 */
	public PageData<Complain> userList(Long userId,int curPage, int pageSize, String keyword) {
		int totalRecord = complainMapper.userComplainListCount(userId, keyword);
		int begin = (curPage - 1) * pageSize;
		Admin admin = new Admin();
		admin.setRealName("");
		List<Complain> data = complainMapper.userComplainList(userId, begin, pageSize, keyword);
		for(Complain c:data) {
			if(c.getAdmin()!=null) {
				continue;
			} else {
				c.setAdmin(admin);
			}
		}
		PageData<Complain> pageData = new PageData<Complain>(pageSize,curPage);
		pageData.setTotalRecord(totalRecord);
		pageData.setData(data);
		return pageData;
	}
	/*
	 * 更新前查找投诉信息
	 * @see com.neuedu.manager.service.ComplainService#getComplainById(int)
	 */
	public Complain getComplainById(int id) {
		Admin admin = new Admin();
		admin.setRealName("");
		Complain complain = complainMapper.getComplainById(id);
		if(complain.getAdmin() == null) {
			complain.setAdmin(admin);
		}
		return complain;
	}
	
	/*
	 * 更新投诉信息
	 * @see com.neuedu.manager.service.ComplainService#update(com.neuedu.manager.po.Complain)
	 */
	public void update(Complain complain) {
		// TODO Auto-generated method stub
		complainMapper.updateById(complain);
	}
	
	/*
	 * 回复投诉信息
	 * @see com.neuedu.manager.service.ComplainService#response(com.neuedu.manager.po.Complain)
	 */
	public void response(Complain complain) {
		// TODO Auto-generated method stub
		complainMapper.responseById(complain);
	}
	
	/*
	 * 管理员删除
	 * @see com.neuedu.manager.service.ComplainService#adminDel(com.neuedu.manager.po.Complain)
	 */
	public void adminDel(Long id) {
		// TODO Auto-generated method stub
		complainMapper.adminDel(id);
	}
	
}
