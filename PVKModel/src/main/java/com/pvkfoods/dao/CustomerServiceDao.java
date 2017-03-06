package com.pvkfoods.dao;

import java.util.List;

import com.pvkfoods.DAOException;
import com.pvkfoods.dao.bean.CustomerBean;

/**
 * 
 * @author prasadprabhakaran
 *
 */
public interface CustomerServiceDao {
	/**
	 * 
	 * @param customer
	 * @return
	 * @throws DAOException
	 */
	public boolean save(CustomerBean customer) throws DAOException;
	
	/**
	 * 
	 * @param customer
	 * @return
	 * @throws DAOException
	 */
	public boolean update(CustomerBean customer) throws DAOException;
	
	/**
	 * 
	 * @param customerId
	 * @return
	 * @throws DAOException
	 */
	public CustomerBean get(Long customerId) throws DAOException;
	
	/**
	 * 
	 * @param customerId
	 * @return
	 * @throws DAOException
	 */
	public boolean delete(Long customerId) throws DAOException;
	
	/**
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<CustomerBean> getAll() throws DAOException;
}
