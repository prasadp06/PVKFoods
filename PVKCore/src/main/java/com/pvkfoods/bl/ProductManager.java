package com.pvkfoods.bl;

import java.util.List;

import com.pvkfoods.dto.beans.Customer;
import com.pvkfoods.dto.beans.Products;
import com.pvkfoods.exception.BusinessException;

/**
 * 
 * @author prasadprabhakaran
 *
 */
public interface ProductManager {
	
	/**
	 * 
	 * @return
	 * @throws BusinessException
	 */
	Products getProducts() throws BusinessException;
}
