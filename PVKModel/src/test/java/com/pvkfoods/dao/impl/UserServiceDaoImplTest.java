/**
 * 
 */
package com.pvkfoods.dao.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pvkfoods.DAOException;
import com.pvkfoods.dao.UserServiceDao;
import com.pvkfoods.dao.bean.UserBean;

/**
 * @author prasadprabhakaran
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/pvkfoods-dao.xml"})
public class UserServiceDaoImplTest {

	@Autowired
	UserServiceDao userDaoService;
	
	/**
	 * Test method for {@link com.pvkfoods.dao.impl.UserServiceDaoImpl#save(com.pvkfoods.dao.bean.UserBean)}.
	 * @throws DAOException 
	 */
	@Test
	public void testSave() throws DAOException {
		String name = ""+Math.random();
		UserBean user = new UserBean(null, "test"+name, "test1"+name, "Test"+name, "User", null, new Date(), "test@test.com", null);
		userDaoService.save(user);
	}

	/**
	 * Test method for {@link com.pvkfoods.dao.impl.UserServiceDaoImpl#get(java.lang.Long)}.
	 * @throws DAOException 
	 */
	@Test
	public void testGetLong() throws DAOException {
		UserBean user = userDaoService.get(new Long(1L));
		assertEquals("test1", user.getUsername());
	}

	/**
	 * Test method for {@link com.pvkfoods.dao.impl.UserServiceDaoImpl#getAll()}.
	 * @throws DAOException 
	 */
	@Test
	public void testGetAll() throws DAOException {
		List user = userDaoService.getAll();
		assertTrue(user.size() > 0);
	}

}
