package com.neuedu.manager.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class D {
	private static Logger Log = Logger.getLogger(D.class);
	private static ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.info("数据库连接失败!");
			throw new RuntimeException("数据库连接失败!",e);
		}
		
	}
	
	public static SqlSession open() {
		SqlSession sqlSession = local.get();
		if(sqlSession == null) {
			sqlSession = sqlSessionFactory.openSession();
			local.set(sqlSession);
			Log.info("创建数据库..");
		}
		return sqlSession;
	}
	
	public static void close() {
		SqlSession sqlSession = local.get();
		if(sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
			
			local.remove();
			Log.info("关闭数据库连接..");
		}
	}
	
	public static void rollBack() {
		SqlSession sqlSession = local.get();
		if(sqlSession != null) {
			sqlSession.rollback();
			sqlSession.close();
			
			local.remove();
			Log.info("出现异常，数据回滚..");
		}
	}
}
