package com.pvkfoods.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.pvkfoods.dao.bean.Customer;
/**
 * 
 * @author prasadprabhakaran
 *
 */
public interface CustomerServiceMapper {
	
	@Results({
        @Result(property = "customerId", column = "CUSTOMER_ID"),
        @Result(property = "customerName", column = "CUSTOMER_NAME"),
        @Result(property = "emailId", column = "EMAIL"),
        @Result(property = "address", column = "ADDRESS"),
        @Result(property = "phone", column = "PHONE"),
        @Result(property = "updatedBy", column = "UPDATED_BY"),
        @Result(property = "updatedDate", column = "UPDATED_DATE")
      })
	@Select("SELECT CUSTOMER_ID, CUSTOMER_NAME, EMAIL, ADDRESS, PHONE, UPDATED_BY, UPDATED_DATE from PVK_CUSTOMER WHERE id = #{id}")
	Customer getCustomer(Long customerId);
	
	@Results({
        @Result(property = "customerId", column = "CUSTOMER_ID"),
        @Result(property = "customerName", column = "CUSTOMER_NAME"),
        @Result(property = "emailId", column = "EMAIL"),
        @Result(property = "address", column = "ADDRESS"),
        @Result(property = "phone", column = "PHONE"),
        @Result(property = "updatedBy", column = "UPDATED_BY"),
        @Result(property = "updatedDate", column = "UPDATED_DATE")
      })
	@Select("SELECT CUSTOMER_ID, CUSTOMER_NAME, EMAIL, ADDRESS, PHONE, UPDATED_BY, UPDATED_DATE from PVK_CUSTOMER")
	List<Customer> getAllCustomers();
	
	@Insert("INSERT into PVK_CUSTOMER (CUSTOMER_NAME, EMAIL, ADDRESS, PHONE, UPDATED_BY, UPDATED_DATE) VALUES(#{customerName}, #{emailId},"
			+ "#{address},#{phone},#{updatedBy},#{updatedDate})")
	void saveCustomer(Customer customer);
	
	@Update("UPDATE PVK_CUSTOMER SET CUSTOMER_NAME=#{customerName}, EMAIL=#{emailId}, ADDRESS=#{address}, PHONE=#{phone}, UPDATED_BY=#{updatedBy}, UPDATED_DATE=#{updatedDate},  WHERE CUSTOMER_ID =#{customerId}")
	void updateCustomer(Customer customer);
	
	@Delete("DELETE PVK_CUSTOMER village WHERE CUSTOMER_ID =#{customerId}")
	void deleteCustomer(Long customerId);
}
