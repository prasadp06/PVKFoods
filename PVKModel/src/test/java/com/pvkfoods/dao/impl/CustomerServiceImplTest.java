package com.pvkfoods.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pvkfoods.DAOException;
import com.pvkfoods.dao.CustomerService;
import com.pvkfoods.dao.bean.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/pvkfoods-dao.xml"})
public class CustomerServiceImplTest {

	@Autowired
	CustomerService service;
	
	@Test
	public void testSave() throws DAOException {
		Customer cus = new Customer(null, "Cus 1", "test@test.com", "1234 Test Street", "1234567890", "testuser", new Date());
		assertTrue(service.save(cus));
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

}
