package com.pvkfoods.bl.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvkfoods.DAOException;
import com.pvkfoods.bl.ProductManager;
import com.pvkfoods.dao.ProductServiceDao;
import com.pvkfoods.dao.bean.ProductBean;
import com.pvkfoods.dto.beans.Product;
import com.pvkfoods.dto.beans.Products;
import com.pvkfoods.exception.BusinessException;

@Service
public class ProductManagerImpl implements ProductManager {
	
	@Autowired
	ProductServiceDao productDaoService;

	/**
	 * 
	 */
	public ProductManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Products getProducts() throws BusinessException {
		Products products = new Products();
		try {
			List<ProductBean> daoProducts = productDaoService.getAll();
			copyToDto(products, daoProducts);
		} catch (DAOException e) {
			throw new BusinessException("Error While Reteriving Product Details ", e);
		}
		
		return products;
	}
	
	private void copyToDto(Products products , List<ProductBean> daoProducts){
		Product dto;
		if(daoProducts != null){
			for(ProductBean dao : daoProducts){
				dto = new Product();
				dto.setProductId(dao.getProductId());
				dto.setProductName(dao.getProductName());
				dto.setProductDesc(dao.getProductDesc());
				dto.setStatus("A".equals(dao.getProductStatus())?"Active":"De-Active");
				dto.setUnitPrice(dao.getUnitPrice());
				dto.setUnits(dao.getProductUnit());
				dto.setUOM(dao.getUOM());
				
				products.getProducts().add(dto);
			}
		}
		
	}

	public ProductServiceDao getProductDaoService() {
		return productDaoService;
	}

	public void setProductDaoService(ProductServiceDao productDaoService) {
		this.productDaoService = productDaoService;
	}

}
