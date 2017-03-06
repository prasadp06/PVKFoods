package com.pvkfoods.dao.bean;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author prasadprabhakaran
 *
 */
public class OrderBean extends BaseDaoBean{
	

	private Long orderId;
	private Long salesAgentId; 
	private UserBean salesUser;
	private Long customerId;
	private CustomerBean customer;
	
	private Double totalAmount;
	private Date orderDate;
	
	private List<OrderDetailsBean> details;

	public OrderBean(){
		
	}
	public OrderBean(Long orderId, Long salesAgentId, UserBean salesUser, Long customerId, CustomerBean customer,
			Double totalAmount, Date orderDate, List<OrderDetailsBean> details) {
		super();
		this.orderId = orderId;
		this.salesAgentId = salesAgentId;
		this.salesUser = salesUser;
		this.customerId = customerId;
		this.customer = customer;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
		this.details = details;
	}
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getSalesAgentId() {
		return salesAgentId;
	}

	public void setSalesAgentId(Long salesAgentId) {
		this.salesAgentId = salesAgentId;
	}

	public UserBean getSalesUser() {
		return salesUser;
	}

	public void setSalesUser(UserBean salesUser) {
		this.salesUser = salesUser;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public CustomerBean getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<OrderDetailsBean> getDetails() {
		return details;
	}

	public void setDetails(List<OrderDetailsBean> details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "OrderBean [orderId=" + orderId + ", salesAgentId=" + salesAgentId + ", salesUser=" + salesUser
				+ ", customerId=" + customerId + ", customer=" + customer + ", totalAmount=" + totalAmount
				+ ", orderDate=" + orderDate + ", details=" + details + "]";
	}
	
	
	
}
