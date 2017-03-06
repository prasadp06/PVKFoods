package com.pvkfoods.dao.bean;

import java.util.Date;

public class ProductBean extends BaseDaoBean{
	Long productId;
	String productName;
	String productDesc;
	String productStatus;
	Double productUnit;
	String UOM;
	Double unitPrice;
	
	
	
	public ProductBean(){
		
	}
	
	/**
	 * @param productId
	 * @param productDesc
	 * @param prodcutStatus
	 * @param productUnit
	 */
	public ProductBean(Long productId, String productName, String productDesc, String productStatus, Double productUnit) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productStatus = productStatus;
		this.productUnit = productUnit;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	
	public Double getProductUnit() {
		return productUnit;
	}
	public void setProductUnit(Double productUnit) {
		this.productUnit = productUnit;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ProductBean))
			return false;
		ProductBean other = (ProductBean) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productDesc=" + productDesc + ", prodcutStatus=" + productStatus
				+ ", productUnit=" + productUnit + "]";
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUOM() {
		return UOM;
	}

	public void setUOM(String uOM) {
		UOM = uOM;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	
	
	
}
