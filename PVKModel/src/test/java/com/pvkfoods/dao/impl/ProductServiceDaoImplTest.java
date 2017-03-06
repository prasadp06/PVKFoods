/**
 * 
 */
package com.pvkfoods.dao.impl;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pvkfoods.DAOException;
import com.pvkfoods.dao.ProductServiceDao;
import com.pvkfoods.dao.bean.CustomerBean;
import com.pvkfoods.dao.bean.ProductBean;
import com.pvkfoods.dao.bean.UserBean;

/**
 * @author prasadprabhakaran
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/pvkfoods-dao.xml"})
public class ProductServiceDaoImplTest {
	
	@Autowired
	ProductServiceDao productDaoService;

	/**
	 * Test method for {@link com.pvkfoods.dao.impl.ProductServiceDaoImpl#save(com.pvkfoods.dao.bean.ProductBean)}.
	 * @throws DAOException 
	 */
	@Test
	public void testSave() throws DAOException {
		String name = ""+Math.random();
		ProductBean product = new ProductBean(null, "Product"+name, "Product Desc", "A", new Double(10));
		product.setUOM("KG");
		productDaoService.save(product);
	}

	/**
	 * Test method for {@link com.pvkfoods.dao.impl.ProductServiceDaoImpl#get(java.lang.Long)}.
	 * @throws DAOException 
	 */
	@Test
	public void testGet() throws DAOException {
		ProductBean product = productDaoService.get(new Long(1));
		assertEquals(product.getProductId(), new Long(1));
	}

	/**
	 * Test method for {@link com.pvkfoods.dao.impl.ProductServiceDaoImpl#getAll()}.
	 * @throws DAOException 
	 */
	@Test
	public void testGetAll() throws DAOException {
		java.util.List<ProductBean> product = productDaoService.getAll();
		assertTrue(product.size()>0);
	}

}
