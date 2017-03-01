package com.pvkfoodsbl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvkfoods.DAOException;
import com.pvkfoods.bl.CustomerManager;
import com.pvkfoods.dao.CustomerService;
import com.pvkfoods.dao.bean.Customer;
import com.pvkfoods.exception.BusinessException;

/**
 * 
 * @author prasadprabhakaran
 *
 */
@Service
public class CustomerManagerImpl implements CustomerManager{

	@Autowired
	CustomerService customerService;
	
	public CustomerManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Customer> getCustomers() throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return customerService.getAll();
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BusinessException(e);
		}
	}

}
