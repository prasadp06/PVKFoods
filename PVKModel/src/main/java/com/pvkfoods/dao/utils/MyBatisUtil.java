package com.pvkfoods.dao.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author prasadprabhakaran
 *
 */
public class MyBatisUtil {
	
	@Autowired
	private static SqlSessionFactoryBean sqlSessionFactory;
	
	public static SqlSessionFactory getSessionFactory() throws Exception{
		return sqlSessionFactory.getObject();
	}

	/**
	 * @param sqlSessionFactory the sqlSessionFactory to set
	 */
	public static void setSqlSessionFactory(SqlSessionFactoryBean sqlSessionFactory) {
		MyBatisUtil.sqlSessionFactory = sqlSessionFactory;
	}
	
	
}
