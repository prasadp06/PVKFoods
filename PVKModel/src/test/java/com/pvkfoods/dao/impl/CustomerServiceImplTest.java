package com.pvkfoods.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pvkfoods.DAOException;
import com.pvkfoods.dao.CustomerServiceDao;
import com.pvkfoods.dao.bean.CustomerBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/pvkfoods-dao.xml"})
public class CustomerServiceImplTest {

	@Autowired
	CustomerServiceDao service;
	
	@Test
	public void testSave() throws DAOException {
		CustomerBean cus = new CustomerBean(null, "Cus 1", "test@test.com", "1234 Test Street", "1234567890");
		assertTrue(service.save(cus));
	}

	@Test
	public void testUpdate() {
		assertTrue(true);
	}

	@Test
	public void testGet() throws DAOException {
		CustomerBean actual = new CustomerBean(new Long(1), "Cus 1", "test@test.com", "1234 Test Street", "1234567890");
		
		CustomerBean cus = service.get(new Long(1));
		assertTrue(true);
	}

	@Test
	public void testDelete() {
		assertTrue(true);
	}

	@Test
	public void testGetAll() {
		assertTrue(true);
	}

}
