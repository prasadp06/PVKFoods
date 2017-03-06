package com.pvkfoods.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.ComponentScan;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.pvkfoods.dao.bean.CustomerBean;
/**
 * 
 * @author prasadprabhakaran
 *
 */
@ComponentScan
public interface CustomerServiceMapper {
	
	@Results({
        @Result(property = "customerId", column = "CUSTOMER_ID"),
        @Result(property = "customerName", column = "CUSTOMER_NAME"),
        @Result(property = "emailId", column = "EMAIL"),
        @Result(property = "uuid", column = "UUID"),
        @Result(property = "uuidType", column = "UUID"),
        @Result(property = "updatedBy", column = "UPDATED_BY"),
        @Result(property = "updatedDate", column = "UPDATED_DATE")
      })
	@Select("SELECT CUSTOMER_ID, CUSTOMER_NAME, EMAIL, UUID, UUID_TYPE_CD, UPDATED_BY, UPDATED_DATE from PVK_CUSTOMER WHERE CUSTOMER_ID = #{customerId}")
	CustomerBean getCustomer(Long customerId);
	
	@Results({
		@Result(property = "customerId", column = "CUSTOMER_ID"),
        @Result(property = "customerName", column = "CUSTOMER_NAME"),
        @Result(property = "emailId", column = "EMAIL"),
        @Result(property = "uuid", column = "UUID"),
        @Result(property = "uuidType", column = "UUID"),
        @Result(property = "updatedBy", column = "UPDATED_BY"),
        @Result(property = "updatedDate", column = "UPDATED_DATE")
      })
	@Select("SELECT CUSTOMER_ID, CUSTOMER_NAME, EMAIL, UUID, UUID_TYPE_CD, UPDATED_BY, UPDATED_DATE from PVK_CUSTOMER")
	List<CustomerBean> getAllCustomers();
	
	@Insert("INSERT INTO PVK_CUSTOMER (CUSTOMER_NAME, EMAIL, UUID, UUID_TYPE_CD, UPDATED_BY, UPDATED_DATE) VALUES(#{customerName}, #{emailId},"
			+ "#{uuid},#{uuidType},#{updatedBy},#{updatedDate})")
	void saveCustomer(CustomerBean customer);
	
	@Update("UPDATE PVK_CUSTOMER SET CUSTOMER_NAME=#{customerName}, EMAIL=#{emailId}, ADDRESS=#{address}, PHONE=#{phone}, UPDATED_BY=#{updatedBy}, UPDATED_DATE=#{updatedDate},  WHERE CUSTOMER_ID =#{customerId}")
	void updateCustomer(CustomerBean customer);
	
	@Delete("DELETE FROM PVK_CUSTOMER WHERE CUSTOMER_ID =#{customerId}")
	void deleteCustomer(Long customerId);
}
