package com.pvkfoods.bl.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pvkfoods.DAOException;
import com.pvkfoods.bl.CustomerManager;
import com.pvkfoods.dao.CustomerServiceDao;
import com.pvkfoods.dto.beans.Customer;
import com.pvkfoods.exception.BusinessException;

/**
 * 
 * @author prasadprabhakaran
 *
 */
@Service
public class CustomerManagerImpl implements CustomerManager {

	@Autowired
	CustomerServiceDao customerDaoService;
	
	public CustomerManagerImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("-----------------------------------");
		System.out.println("--------CustomerManagerImpl--------");
		System.out.println("-----------------------------------");
	}

	@Override
	public List<Customer> getCustomers() throws BusinessException {
		// TODO Auto-generated method stub
		List<Customer> customers = new ArrayList<Customer>();
		try {
			
			copyToDto(customers, customerDaoService.getAll());
			
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BusinessException(e);
		}
		
		return customers;
	}
	
	private void copyToDto(List<Customer> dto, List<com.pvkfoods.dao.bean.CustomerBean> dao){
		Customer cusDto;
		if(dao != null && !dao.isEmpty()){
			for(com.pvkfoods.dao.bean.CustomerBean daoCustomer : dao){
				cusDto = new Customer();
				cusDto.setCustomerId(daoCustomer.getCustomerId());
				cusDto.setCustomerName(daoCustomer.getCustomerName());
				cusDto.setEmail(daoCustomer.getEmailId());
				//cusDto.setUUID(daoCustomer.get);
				dto.add(cusDto);
			}
		}
	}

	public CustomerServiceDao getCustomerDaoService() {
		return customerDaoService;
	}

	public void setCustomerDaoService(CustomerServiceDao customerDaoService) {
		this.customerDaoService = customerDaoService;
	}

	
	
	

}
