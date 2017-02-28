package com.pvkfoods.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author prasadprabhakaran
 *
 */
@XmlRootElement
public class CustomerDto {
	Long customerId; 
	String customerName;
	
	public CustomerDto(){
		
	}
	
	public CustomerDto(Long customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	} 
	
}
