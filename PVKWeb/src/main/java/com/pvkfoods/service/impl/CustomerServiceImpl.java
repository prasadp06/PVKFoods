package com.pvkfoods.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.pvkfoods.bl.CustomerManager;
import com.pvkfoods.dao.bean.Customer;
import com.pvkfoods.dto.CustomerDto;
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
	
	public Long addCustomer(CustomerDto dto) {
		try {
			System.out.println("Inside Save "+ dto.getCustomerId() +"|" + dto.getCustomerName());
			return new Long(1010L);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public CustomerDto getCustomer(Long id) {
		CustomerDto dto = new CustomerDto(1010L,"Test Customer");
		return dto;
	}

	public ArrayList<CustomerDto> getCustomers() {
		ArrayList<CustomerDto> customers = new ArrayList<CustomerDto>();
		
		try {
			List<Customer> daoCustomers = customerManager.getCustomers();
			addToList(customers, daoCustomers);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customers;
	}

	private void addToList(ArrayList<CustomerDto> customers, List<Customer> daoCustomers) {
		CustomerDto dto; 
		if(daoCustomers != null && daoCustomers.size()>0){
			for(Customer dao : daoCustomers){
				dto = new CustomerDto(dao.getCustomerId(), dao.getCustomerName());
				customers.add(dto);
			}
		}
		
		
	}

	public Long modifyCustomer(CustomerDto dto) {
		System.out.println("Inside Modify "+ dto.getCustomerId() +"|" + dto.getCustomerName());
		// TODO Auto-generated method stub
		return new Long(100);
	}

	public Long deleteCustomer(CustomerDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
