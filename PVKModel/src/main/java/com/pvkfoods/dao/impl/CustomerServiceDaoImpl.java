package com.pvkfoods.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvkfoods.DAOException;
import com.pvkfoods.dao.CustomerServiceDao;
import com.pvkfoods.dao.bean.CustomerBean;
import com.pvkfoods.dao.mapper.CustomerServiceMapper;

@Service
public class CustomerServiceDaoImpl implements CustomerServiceDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	CustomerServiceMapper cusMapper;
	
	private void initMapper(){
		cusMapper = sqlSession.getMapper(CustomerServiceMapper.class);
	}
	
	@Override
	public boolean save(CustomerBean customer) throws DAOException {
		try {
			initMapper();
			cusMapper.saveCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Error While Accessing Data", e);
		}finally {
		}
		return true;
	}

	@Override
	public boolean update(CustomerBean customer) throws DAOException {
		SqlSession session = null;
		try {
			initMapper();
			cusMapper.updateCustomer(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Error While Accessing Data", e);
		}finally {
			if(session!=null){
				session.close();
			}
		}
		return true;
	}

	@Override
	public CustomerBean get(Long customerId) throws DAOException {
		try {
			initMapper();
			return cusMapper.getCustomer(customerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Error While Accessing Data", e);
		}finally {
			
		}
	}

	@Override
	public boolean delete(Long customerId) throws DAOException {
		try {
			initMapper();
			cusMapper.deleteCustomer(customerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Error While Accessing Data", e);
		}finally {
			
		}
		return true;
	}

	@Override
	public List<CustomerBean> getAll() throws DAOException {
		try {
			initMapper();
			return cusMapper.getAllCustomers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Error While Accessing Data", e);
		}finally {
			
		}
	}

	

}
