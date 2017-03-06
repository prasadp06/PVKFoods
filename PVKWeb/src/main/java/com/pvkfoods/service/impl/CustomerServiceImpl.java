package com.pvkfoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.pvkfoods.bl.CustomerManager;
import com.pvkfoods.dto.beans.Customer;
import com.pvkfoods.dto.request.CustomerRequest;
import com.pvkfoods.dto.request.CustomerResponse;
import com.pvkfoods.exception.BusinessException;
import com.pvkfoods.service.CustomerService;
import com.pvkfoods.service.ServiceException;

/**
 * 
 * @author prasadprabhakaran
 *
 */
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	@Qualifier("customerManager")
	CustomerManager customerManager; 
	
	public Long addCustomer(CustomerRequest customer) throws ServiceException {
		try {
			System.out.println("Inside Save "+ customer.getCustomer().getCustomerName() );
			return new Long(1010L);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException("ERR002","Customer Service Error");
		}
		
	}

	public CustomerResponse getCustomer(Long id) {
		CustomerResponse dto = new CustomerResponse();
		return dto;
	}

	public CustomerResponse getCustomers() throws ServiceException {
		CustomerResponse dto = new CustomerResponse();
		
		if(customerManager ==null){
			System.out.println("Customer Manager is NULL ");
			throw new ServiceException("ERR002","Customer Service Not Initilized");
		}
		
		try {
			
			List<Customer> customers = customerManager.getCustomers();
			dto.getCustomers().addAll(customers);
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException("ERR002","Customer Service Error");
		} catch(Exception e){
			e.printStackTrace();
			throw new ServiceException("ERR002","Customer Service Unknown Exception");
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

	public CustomerManager getCustomerManager() {
		return customerManager;
	}

	public void setCustomerManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}

}
