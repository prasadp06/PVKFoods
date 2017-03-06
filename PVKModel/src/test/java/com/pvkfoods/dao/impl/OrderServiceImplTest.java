package com.pvkfoods.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pvkfoods.DAOException;
import com.pvkfoods.dao.OrderServiceDao;
import com.pvkfoods.dao.bean.OrderBean;
import com.pvkfoods.dao.bean.ProductBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/pvkfoods-dao.xml"})
public class OrderServiceImplTest {
	
	@Autowired
	OrderServiceDao orderDaoService;

	@Test
	public void test() throws DAOException {
		java.util.List<OrderBean> order = orderDaoService.getAll();
		for(OrderBean bean : order){
			System.out.println(bean);
		}
		assertTrue(order.size()>0);
	}

	
	
}
