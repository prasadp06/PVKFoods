package com.pvkfoods.dao.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author prasadprabhakaran
 *
 */
public class OrderDetailsBean {
	private Long orderId;
	private Long productId; 
	private List<ProductBean> product;
	private Integer quantity; 
	private String UOM;
	
	public OrderDetailsBean(){
		
	}
	public OrderDetailsBean(Long orderId, Long productId, ProductBean product, Integer quantity, String uOM) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		getProduct().add(product);
		this.quantity = quantity;
		UOM = uOM;
	}
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public List<ProductBean> getProduct() {
		if(product == null){
			product = new ArrayList<ProductBean>();
		}
		return product;
	}
	public void setProduct(List<ProductBean> product) {
		this.product = product;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getUOM() {
		return UOM;
	}
	public void setUOM(String uOM) {
		UOM = uOM;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "OrderDetailsBean [orderId=" + orderId + ", productId=" + productId + ", product=" + product
				+ ", quantity=" + quantity + ", UOM=" + UOM + "]";
	} 

	
	
}
