package com.pvkfoods.bl;

import java.util.List;

import com.pvkfoods.dto.beans.Customer;
import com.pvkfoods.exception.BusinessException;

/**
 * 
 * @author prasadprabhakaran
 *
 */
public interface CustomerManager {
	/**
	 * 
	 * @return
	 * @throws BusinessException
	 */
	List<Customer> getCustomers() throws BusinessException;
	
}
