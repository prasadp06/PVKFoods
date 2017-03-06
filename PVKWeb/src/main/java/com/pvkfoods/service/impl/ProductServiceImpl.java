/**
 * 
 */
package com.pvkfoods.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.pvkfoods.bl.ProductManager;
import com.pvkfoods.dto.beans.Products;
import com.pvkfoods.dto.request.ProductRequest;
import com.pvkfoods.dto.request.ProductResponse;
import com.pvkfoods.exception.BusinessException;
import com.pvkfoods.service.ProductService;
import com.pvkfoods.service.ServiceException;

/**
 * @author prasadprabhakaran
 *
 */
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductManager productManager;

	/* (non-Javadoc)
	 * @see com.pvkfoods.service.ProductService#addProduct(com.pvkfoods.dto.request.ProductRequest)
	 */
	@Override
	public Long addProduct(ProductRequest product) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pvkfoods.service.ProductService#getProduct(java.lang.Long)
	 */
	@Override
	public ProductResponse getProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pvkfoods.service.ProductService#getProducts()
	 */
	@Override
	public ProductResponse getProducts() throws ServiceException {
		ProductResponse response = new ProductResponse();
		long repTime = System.currentTimeMillis();
		try {
			Products products = productManager.getProducts();
			response.getProducts().addAll(products.getProducts());
			response.setResponseTime("Took "+(repTime - System.currentTimeMillis()) + " sec");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException("ERR001","Product Service Error");
		}
		return response;
	}

	/* (non-Javadoc)
	 * @see com.pvkfoods.service.ProductService#modifyProduct(com.pvkfoods.dto.request.ProductRequest)
	 */
	@Override
	public Long modifyProduct(ProductRequest product) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.pvkfoods.service.ProductService#deleteProduct(java.lang.Long)
	 */
	@Override
	public boolean deleteProduct(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public ProductManager getProductManager() {
		return productManager;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}

	
	
}
