package com.neuedu.manager.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.manager.mapper.CostMapper;
import com.neuedu.manager.po.Cost;
import com.neuedu.manager.util.D;
import com.neuedu.manager.web.PageData;

public class CostServiceImpl implements CostService{
	private CostMapper costMapper;
	public CostServiceImpl() {
		SqlSession sqlSession = D.open();
		costMapper = sqlSession.getMapper(CostMapper.class);
	}
	/*
	 * 添加费用信息
	 * @see com.neuedu.manager.service.CostService#save(com.neuedu.manager.po.Cost)
	 */
	public void save(Cost cost) {
		// TODO Auto-generated method stub
		costMapper.insert(cost);
	}
	
	/*
	 * 浏览费用信息
	 * @see com.neuedu.manager.service.CostService#list(int, int, java.lang.String)
	 */
	public PageData<Cost> list(int curPage, int pageSize, String keyword) {
		int totalRecord = costMapper.costListCount(keyword);
		int begin = (curPage - 1) * pageSize;
		List<Cost> data = costMapper.costList(begin, pageSize, keyword);
		
		PageData<Cost> pageData = new PageData<Cost>(pageSize,curPage);
		pageData.setTotalRecord(totalRecord);
		pageData.setData(data);
		return pageData;
	}
	
	/*
	 * 删除费用信息
	 * @see com.neuedu.manager.service.CostService#delete(int)
	 */
	public void delete(int id) {
		// TODO Auto-generated method stub
		costMapper.delete(id);
	}
	
	/*
	 * 根据id查找费用信息
	 * @see com.neuedu.manager.service.CostService#getPriceById(int)
	 */
	public Double getPriceById(Long id) {
		Double rs = costMapper.getPriceById(id);
		if(rs == null) {
		}
		return rs;
	}

}
