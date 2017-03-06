package com.pvkfoods.dao.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CustomerServiceImplTest.class, OrderServiceImplTest.class, ProductServiceDaoImplTest.class,
		UserServiceDaoImplTest.class })
public class AllTests {

}
