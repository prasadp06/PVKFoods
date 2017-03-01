package com.pvkfoods.dao.bean;

public class Product {
	Long productId;
	String productDesc;
	String prodcutStatus;
	Double productUnit;
	
	
	public Product(){
		
	}
	
	/**
	 * @param productId
	 * @param productDesc
	 * @param prodcutStatus
	 * @param productUnit
	 */
	public Product(Long productId, String productDesc, String prodcutStatus, Double productUnit) {
		super();
		this.productId = productId;
		this.productDesc = productDesc;
		this.prodcutStatus = prodcutStatus;
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
	public String getProdcutStatus() {
		return prodcutStatus;
	}
	public void setProdcutStatus(String prodcutStatus) {
		this.prodcutStatus = prodcutStatus;
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
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
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
		return "Product [productId=" + productId + ", productDesc=" + productDesc + ", prodcutStatus=" + prodcutStatus
				+ ", productUnit=" + productUnit + "]";
	}
	
	
	
}
