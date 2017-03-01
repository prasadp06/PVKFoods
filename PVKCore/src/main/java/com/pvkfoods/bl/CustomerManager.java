package com.pvkfoods.bl;

import java.util.List;

import com.pvkfoods.dao.bean.Customer;
import com.pvkfoods.exception.BusinessException;

public interface CustomerManager {
	List<Customer> getCustomers() throws BusinessException;
	
}
