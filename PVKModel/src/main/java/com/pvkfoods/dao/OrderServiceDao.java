package com.pvkfoods.dao;

import java.util.List;

import com.pvkfoods.DAOException;
import com.pvkfoods.dao.bean.OrderBean;

public interface OrderServiceDao {
	/**
	 * 
	 * @return
	 * @throws DAOException
	 */
	public List<OrderBean> getAll() throws DAOException;
}
