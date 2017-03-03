package com.pvkfoodsbl.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pvkfoods.bl.CustomerManager;
import com.pvkfoods.dto.beans.Customer;
import com.pvkfoods.exception.BusinessException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/pvkfoods-core.xml"})
public class CustomerManagerImplTest {
	
	@Autowired
	CustomerManager customerManager;

	@Test
	public void testGetCustomers() throws BusinessException {
		List<Customer> customers = customerManager.getCustomers();
		assertTrue(customers.size()>0);
	}

}
