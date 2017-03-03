package com.pvkfoods.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvkfoods.DAOException;
import com.pvkfoods.dao.CustomerServiceDao;
import com.pvkfoods.dao.bean.Customer;
import com.pvkfoods.dao.mapper.CustomerServiceMapper;

@Service
public class CustomerServiceDaoImpl implements CustomerServiceDao {
	
	@Autowired
	private static SqlSessionFactoryBean sqlSessionFactory;
	
	@Autowired
	CustomerServiceMapper cusMapper;

	@Override
	public boolean save(Customer customer) throws DAOException {
		try {
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
	public boolean update(Customer customer) throws DAOException {
		SqlSession session = null;
		try {
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
	public Customer get(Long customerId) throws DAOException {
		try {
			
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
	public List<Customer> getAll() throws DAOException {
		try {
			return cusMapper.getAllCustomers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Error While Accessing Data", e);
		}finally {
			
		}
	}

	

}
