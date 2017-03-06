package com.pvkfoods.dao.bean;

import java.util.Date;

/**
 * 
 * @author prasadprabhakaran
 *
 */
public class UserBean extends BaseDaoBean {
	private Long userId;
	private String username; 
	private String password; 
	private String firstName;
	private String lastName; 
	private String middleName; 
	private Date dob; 
	
	private String email; 
	private Date deactiveDate;
	
	
	public UserBean(){
		
	}
	
	public UserBean(Long userId, String username, String password, String firstName, String lastName, String middleName,
			Date dob, String email, Date deactiveDate) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.dob = dob;
		this.email = email;
		this.deactiveDate = deactiveDate;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDeactiveDate() {
		return deactiveDate;
	}
	public void setDeactiveDate(Date deactiveDate) {
		this.deactiveDate = deactiveDate;
	}

	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", dob=" + dob + ", email="
				+ email + ", deactiveDate=" + deactiveDate + "]";
	}
	
	
	
	
	
}
