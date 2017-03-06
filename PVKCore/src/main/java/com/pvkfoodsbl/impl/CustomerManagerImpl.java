package com.pvkfoodsbl.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class CustomerManagerImpl implements CustomerManager{

	@Autowired
	CustomerServiceDao customerService;
	
	public CustomerManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Customer> getCustomers() throws BusinessException {
		// TODO Auto-generated method stub
		List<Customer> customers = new ArrayList<Customer>();
		try {
			
			copyToDto(customers, customerService.getAll());
			
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
	
	

}
