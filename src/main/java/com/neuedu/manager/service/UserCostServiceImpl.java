package com.neuedu.manager.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neuedu.manager.mapper.CostMapper;
import com.neuedu.manager.mapper.UserCostMapper;
import com.neuedu.manager.po.Complain;
import com.neuedu.manager.po.Cost;
import com.neuedu.manager.po.UserCost;
import com.neuedu.manager.util.D;
import com.neuedu.manager.web.PageData;

public class UserCostServiceImpl implements UserCostService{
	private UserCostMapper userCostMapper;
	private CostMapper costMapper;
	public UserCostServiceImpl() {
		SqlSession sqlSession = D.open();
		costMapper = sqlSession.getMapper(CostMapper.class);
		userCostMapper = sqlSession.getMapper(UserCostMapper.class);
	}
	
	public void save(UserCost userCost) {
		double price = costMapper.getPriceById(userCost.getCost().getId());
		double totalCost = price * userCost.getCostNum();
		userCost.setTotalCost(totalCost);
		userCostMapper.insert(userCost);
	}

	public PageData<UserCost> list(int curPage, int pageSize, String keyword) {
		int totalRecord = userCostMapper.userCostListCount(keyword);
		int begin = (curPage - 1) * pageSize;
		List<UserCost> data = userCostMapper.userCostList(begin, pageSize, keyword);
		PageData<UserCost> pageData = new PageData<UserCost>(pageSize,curPage);
		pageData.setTotalRecord(totalRecord);
		pageData.setData(data);
		return pageData;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		userCostMapper.delete(id);
	}

	public PageData<UserCost> userList(Long userId, int curPage, int pageSize, String keyword) {
		int totalRecord = userCostMapper.uUserCostListCount(userId, keyword);
		int begin = (curPage - 1) * pageSize;
		List<UserCost> data = userCostMapper.uUserCostList(userId, begin, pageSize, keyword);
		
		PageData<UserCost> pageData = new PageData<UserCost>(pageSize,curPage);
		pageData.setTotalRecord(totalRecord);
		pageData.setData(data);
		return pageData;
	}

	public boolean existUserCost(int userId, int costId) {
		UserCost userCost = userCostMapper.getUserCost(userId, costId);
		if(userCost != null) {
			return true;
		}
		return false;
	}

}
