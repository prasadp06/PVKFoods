package com.pvkfoods.dao;

import java.util.List;

import com.pvkfoods.DAOException;
import com.pvkfoods.dao.bean.ProductBean;

/**
 * 
 * @author prasadprabhakaran
 *
 */
public interface ProductServiceDao {
	/**
	 * 
	 * @param customer
	 * @return
	 * @throws DAOException
	 */
	public boolean save(ProductBean product) throws DAOException;
	
	/**
	 * 
	 * @param customer
	 * @return
	 * @throws DAOException
	 */
	public boolean update(ProductBean product) throws DAOException;
	
	/**
	 * 
	 * @param customerId
	 * @return
	 * @throws DAOException
	 */
	public ProductBean get(Long prodcutId) throws DAOException;
	
	/**
	 * 
	 * @param customerId
	 * @return
	 * @throws DAOException
	 */
	public boolean delete(Long productId) throws DAOException;
	
	/**
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ProductBean> getAll() throws DAOException;
	
	/**
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<ProductBean> searchProdcut(String productName) throws DAOException;
}
