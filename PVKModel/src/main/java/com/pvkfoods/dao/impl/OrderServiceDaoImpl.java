package com.pvkfoods.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvkfoods.DAOException;
import com.pvkfoods.dao.OrderServiceDao;
import com.pvkfoods.dao.bean.OrderBean;
import com.pvkfoods.dao.mapper.OrderServiceMapper;

/**
 * 
 * @author prasadprabhakaran
 *
 */
@Service
public class OrderServiceDaoImpl implements OrderServiceDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	OrderServiceMapper orderMapper;
	
	@Override
	public List<OrderBean> getAll() throws DAOException {
		try {
			orderMapper = sqlSession.getMapper(OrderServiceMapper.class);
			return orderMapper.getAllOrders();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Error While Accessing Data", e);
		}finally {
			
		}
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
