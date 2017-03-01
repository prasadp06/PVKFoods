package com.pvkfoods.dao;

import java.util.List;

import com.pvkfoods.DAOException;
import com.pvkfoods.dao.bean.Customer;

/**
 * 
 * @author prasadprabhakaran
 *
 */
public interface CustomerService {
	/**
	 * 
	 * @param customer
	 * @return
	 * @throws DAOException
	 */
	public boolean save(Customer customer) throws DAOException;
	
	/**
	 * 
	 * @param customer
	 * @return
	 * @throws DAOException
	 */
	public boolean update(Customer customer) throws DAOException;
	
	/**
	 * 
	 * @param customerId
	 * @return
	 * @throws DAOException
	 */
	public Customer get(Long customerId) throws DAOException;
	
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
	public List<Customer> getAll() throws DAOException;
}
