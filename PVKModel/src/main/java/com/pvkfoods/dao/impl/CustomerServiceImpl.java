package com.pvkfoods.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.pvkfoods.DAOException;
import com.pvkfoods.dao.CustomerService;
import com.pvkfoods.dao.bean.Customer;
import com.pvkfoods.dao.mapper.CustomerServiceMapper;
import com.pvkfoods.dao.utils.MyBatisUtil;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	private static SqlSessionFactoryBean sqlSessionFactory;
	
	CustomerServiceMapper cusMapper;

	@Override
	public boolean save(Customer customer) throws DAOException {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSessionFactory().openSession();
			cusMapper = session.getMapper(CustomerServiceMapper.class);
			cusMapper.saveCustomer(customer);
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
	public boolean update(Customer customer) throws DAOException {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSessionFactory().openSession();
			cusMapper = session.getMapper(CustomerServiceMapper.class);
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
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSessionFactory().openSession();
			cusMapper = session.getMapper(CustomerServiceMapper.class);
			return cusMapper.getCustomer(customerId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Error While Accessing Data", e);
		}finally {
			if(session!=null){
				session.close();
			}
		}
	}

	@Override
	public boolean delete(Long customerId) throws DAOException {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSessionFactory().openSession();
			cusMapper = session.getMapper(CustomerServiceMapper.class);
			cusMapper.deleteCustomer(customerId);
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
	public List<Customer> getAll() throws DAOException {
		SqlSession session = null;
		try {
			session = MyBatisUtil.getSessionFactory().openSession();
			cusMapper = session.getMapper(CustomerServiceMapper.class);
			return cusMapper.getAllCustomers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DAOException("Error While Accessing Data", e);
		}finally {
			if(session!=null){
				session.close();
			}
		}
	}

}
