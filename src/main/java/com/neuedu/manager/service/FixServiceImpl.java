package com.neuedu.manager.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.manager.mapper.FixMapper;
import com.neuedu.manager.po.Admin;
import com.neuedu.manager.po.Fix;
import com.neuedu.manager.util.D;
import com.neuedu.manager.web.PageData;

public class FixServiceImpl implements FixService{
	private FixMapper fixMapper;
	public FixServiceImpl() {
		SqlSession sqlSession = D.open();
		fixMapper = sqlSession.getMapper(FixMapper.class);
	}
	
	/*
	 * 添加报修信息
	 * @see com.neuedu.manager.service.FixService#save(com.neuedu.manager.po.Fix)
	 */
	public void save(Fix fix) {
		// TODO Auto-generated method stub
		fixMapper.insert(fix);
	}
	
	/*
	 * 查询报修信息
	 * @see com.neuedu.manager.service.FixService#list(int, int, java.lang.String)
	 */
	public PageData<Fix> list(int curPage, int pageSize, String keyword) {
		int totalRecord = fixMapper.fixListCount(keyword);
		int begin = (curPage - 1) * pageSize;
		Admin admin = new Admin();
		admin.setRealName("");
		List<Fix> data = fixMapper.fixList(begin, pageSize, keyword);
		for(Fix c:data) {
			if(c.getAdmin()!=null) {
				continue;
			} else {
				c.setAdmin(admin);
			}
		}
		PageData<Fix> pageData = new PageData<Fix>(pageSize,curPage);
		pageData.setTotalRecord(totalRecord);
		pageData.setData(data);
		return pageData;
	}
	
	/*
	 * 删除报修信息
	 * @see com.neuedu.manager.service.FixService#delete(int)
	 */
	public void delete(int id) {
		// TODO Auto-generated method stub
		fixMapper.delete(id);
	}
	
	/*
	 * 住户查看报修信息
	 * @see com.neuedu.manager.service.FixService#userList(java.lang.Long, int, int, java.lang.String)
	 */
	public PageData<Fix> userList(Long userId,int curPage, int pageSize, String keyword) {
		int totalRecord = fixMapper.userFixListCount(userId, keyword);
		int begin = (curPage - 1) * pageSize;
		Admin admin = new Admin();
		admin.setRealName("");
		List<Fix> data = fixMapper.userFixList(userId, begin, pageSize, keyword);
		for(Fix c:data) {
			if(c.getAdmin()!=null) {
				continue;
			} else {
				c.setAdmin(admin);
			}
		}
		PageData<Fix> pageData = new PageData<Fix>(pageSize,curPage);
		pageData.setTotalRecord(totalRecord);
		pageData.setData(data);
		return pageData;
	}
	/*
	 * 更新前查找报修信息
	 * @see com.neuedu.manager.service.FixService#getFixById(int)
	 */
	public Fix getFixById(int id) {
		Admin admin = new Admin();
		admin.setRealName("");
		Fix fix = fixMapper.getFixById(id);
		if(fix.getAdmin() == null) {
			fix.setAdmin(admin);
		}
		return fix;
	}
	
	/*
	 * 更新报修信息
	 * @see com.neuedu.manager.service.FixService#update(com.neuedu.manager.po.Fix)
	 */
	public void update(Fix fix) {
		// TODO Auto-generated method stub
		fixMapper.updateById(fix);
	}
	
	/*
	 * 回复报修信息
	 * @see com.neuedu.manager.service.FixService#response(com.neuedu.manager.po.Fix)
	 */
	public void response(Fix fix) {
		// TODO Auto-generated method stub
		fixMapper.responseById(fix);
	}
	
	/*
	 * 管理员删除
	 * @see com.neuedu.manager.service.FixService#adminDel(com.neuedu.manager.po.Fix)
	 */
	public void adminDel(Long id) {
		// TODO Auto-generated method stub
		fixMapper.adminDel(id);
	}
}
