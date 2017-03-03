package com.pvkfoods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.pvkfoods.bl.CustomerManager;
import com.pvkfoods.dto.request.CustomerRequest;
import com.pvkfoods.dto.request.CustomerResponse;
import com.pvkfoods.exception.BusinessException;
import com.pvkfoods.service.CustomerService;

/**
 * 
 * @author prasadprabhakaran
 *
 */
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerManager customerManager; 
	
	public Long addCustomer(CustomerRequest customer) {
		try {
			System.out.println("Inside Save "+ customer.getCustomer().getCustomerName() );
			return new Long(1010L);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public CustomerResponse getCustomer(Long id) {
		CustomerResponse dto = new CustomerResponse();
		return dto;
	}

	public CustomerResponse getCustomers() {
		CustomerResponse dto = new CustomerResponse();
		
		try {
		
			dto.getCustomers().addAll(customerManager.getCustomers());
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}

	

	public Long modifyCustomer(CustomerRequest customer) {
		System.out.println("Inside Modify "+ customer.getCustomer().getCustomerName());
		// TODO Auto-generated method stub
		return new Long(100);
	}

	public boolean deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
