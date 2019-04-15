package com.neuedu.manager.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.manager.mapper.AnnounceMapper;
import com.neuedu.manager.po.Announce;
import com.neuedu.manager.util.D;
import com.neuedu.manager.web.PageData;

public class AnnounceServiceImpl implements AnnounceService{
	private AnnounceMapper announceMapper;
	public AnnounceServiceImpl() {
		SqlSession sqlSession = D.open();
		announceMapper = sqlSession.getMapper(AnnounceMapper.class);
	}
	/*
	 * 添加公告信息
	 * @see com.neuedu.manager.service.AnnounceService#save(com.neuedu.manager.po.Announce)
	 */
	public void save(Announce announce) {
		// TODO Auto-generated method stub
		announceMapper.insert(announce);
		
	}
	
	/*
	 * 浏览公告信息
	 * @see com.neuedu.manager.service.AnnounceService#list(int, int, java.lang.String)
	 */
	public PageData<Announce> list(int curPage, int pageSize, String keyword) {
		int totalRecord = announceMapper.announceListCount(keyword);
		int begin = (curPage - 1) * pageSize;
		List<Announce> data = announceMapper.announceList(begin, pageSize, keyword);
		
		PageData<Announce> pageData = new PageData<Announce>(pageSize,curPage);
		pageData.setTotalRecord(totalRecord);
		pageData.setData(data);
		return pageData;
	}
	
	/*
	 * 删除公告信息
	 * @see com.neuedu.manager.service.AnnounceService#delete(int)
	 */
	public void delete(int id) {
		// TODO Auto-generated method stub
		announceMapper.delete(id);
	}
	
	/*
	 * 根据id查号公告信息
	 * @see com.neuedu.manager.service.AnnounceService#getAnnounceById(int)
	 */
	public Announce getAnnounceById(int id) {
		
		return announceMapper.getAnnounceById(id);
	}
	
	/*
	 * 更新公告信息
	 * @see com.neuedu.manager.service.AnnounceService#update(com.neuedu.manager.po.Announce)
	 */
	public void update(Announce announce) {
		// TODO Auto-generated method stub
		announceMapper.updateById(announce);
	}

}
