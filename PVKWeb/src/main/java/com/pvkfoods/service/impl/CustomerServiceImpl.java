package com.pvkfoods.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.pvkfoods.dto.CustomerDto;
import com.pvkfoods.service.CustomerService;

/**
 * 
 * @author prasadprabhakaran
 *
 */
public class CustomerServiceImpl implements CustomerService {

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
		CustomerDto dto = new CustomerDto(1010L,"Test Customer");
		customers.add(dto);
		return customers;
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
