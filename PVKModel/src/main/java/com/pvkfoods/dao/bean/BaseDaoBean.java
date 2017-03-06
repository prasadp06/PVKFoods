package com.pvkfoods.dao.bean;

import java.util.Date;

public abstract class BaseDaoBean {
	private String updatedBy; 
	private Date updatedDate;
	
	private String uuid; 
	private String uuidType;
	
	
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUuidType() {
		return uuidType;
	}
	public void setUuidType(String uuidType) {
		this.uuidType = uuidType;
	}
	
	
}
