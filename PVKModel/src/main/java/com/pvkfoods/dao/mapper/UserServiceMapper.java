package com.pvkfoods.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pvkfoods.dao.bean.UserBean;

/**
 * 
 * @author prasadprabhakaran
 *
 */
public interface UserServiceMapper {
	@Results({
        @Result(property = "userId", column = "USER_ID"),
        @Result(property = "username", column = "USERNAME"),
        @Result(property = "firstName", column = "FIRST_NAME"),
        @Result(property = "lastName", column = "LAST_NAME"),
        @Result(property = "email", column = "EMAIL"),
        @Result(property = "uuid", column = "UUID"),
        @Result(property = "uuidType", column = "UUID_TYPE_CD"),
        @Result(property = "updatedBy", column = "UPDATED_BY"),
        @Result(property = "updatedDate", column = "UPDATED_DATE")
      })
	@Select("SELECT USER_ID, USERNAME, FIRST_NAME, LAST_NAME, EMAIL, UUID, UUID_TYPE_CD, UPDATED_BY, UPDATED_DATE from PVK_USER WHERE USER_ID = #{userId}")
	UserBean getUser(Long userId);
	
	@Results({
		@Result(property = "userId", column = "USER_ID"),
        @Result(property = "username", column = "CUSTOMER_NAME"),
        @Result(property = "email", column = "EMAIL"),
        @Result(property = "firstName", column = "FIRST_NAME"),
        @Result(property = "lastName", column = "LAST_NAME"),
        @Result(property = "uuid", column = "UUID"),
        @Result(property = "uuidType", column = "UUID_TYPE_CD"),
        @Result(property = "updatedBy", column = "UPDATED_BY"),
        @Result(property = "updatedDate", column = "UPDATED_DATE")
      })
	@Select("SELECT USER_ID, USERNAME, FIRST_NAME, LAST_NAME, EMAIL, UUID, UUID_TYPE_CD, UPDATED_BY, UPDATED_DATE from PVK_USER")
	List<UserBean> getAllUsers();
	
	@Insert("INSERT INTO PVK_USER (USERNAME, FIRST_NAME, LAST_NAME, EMAIL, UUID, UUID_TYPE_CD, UPDATED_BY, UPDATED_DATE, PASSWORD) "
			+ "VALUES(#{username}, #{firstName}, #{lastName}, #{email},"
			+ "#{uuid},#{uuidType},#{updatedBy},#{updatedDate},MD5(#{password}))")
	void saveUser(UserBean user);
	
	@Update("UPDATE PVK_USER SET USERNAME=#{username}, FIRST_NAME=#{firstName}, LAST_NAME#{lastName}, EMAIL=#{email}, UPDATED_BY=#{updatedBy}, "
			+ "UPDATED_DATE=#{updatedDate},  WHERE USER_ID =#{userId}")
	void updateUser(UserBean user);
	
	@Delete("DELETE FROM PVK_USER WHERE USER_ID =#{userId}")
	void deleteUser(Long userId);
}
