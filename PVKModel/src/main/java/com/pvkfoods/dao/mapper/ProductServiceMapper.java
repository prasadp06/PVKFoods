package com.pvkfoods.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pvkfoods.dao.bean.ProductBean;
/**
 * 
 * @author prasadprabhakaran
 *
 */
public interface ProductServiceMapper {
	
	@Results({
        @Result(property = "productId", column = "PRODUCT_ID"),
        @Result(property = "productName", column = "PRODUCT_TITLE"),
        @Result(property = "productDesc", column = "PRODUCT_DESC"),
        @Result(property = "productStatus", column = "PRODUCT_STATUS"),
        @Result(property = "productUnit", column = "PRODUCT_UNIT"),
        @Result(property = "unitPrice", column = "UNIT_PRICE"),
        @Result(property = "UOM", column = "UNIT_UOM")
      })
	@Select("SELECT PRODUCT_ID, PRODUCT_TITLE, PRODUCT_DESC, PRODUCT_STATUS, PRODUCT_UNIT, UNIT_PRICE, UNIT_UOM  from PVK_PRODUCT WHERE PRODUCT_ID = #{prodcutId}")
	ProductBean getProduct(Long prodcutId);
	
	@Results({
		@Result(property = "productId", column = "PRODUCT_ID"),
        @Result(property = "productName", column = "PRODUCT_TITLE"),
        @Result(property = "productDesc", column = "PRODUCT_DESC"),
        @Result(property = "productStatus", column = "PRODUCT_STATUS"),
        @Result(property = "productUnit", column = "PRODUCT_UNIT"),
        @Result(property = "unitPrice", column = "UNIT_PRICE"),
        @Result(property = "UOM", column = "UNIT_UOM")
      })
	@Select("SELECT PRODUCT_ID, PRODUCT_TITLE, PRODUCT_DESC, PRODUCT_STATUS, PRODUCT_UNIT, UNIT_PRICE, UNIT_UOM  from PVK_PRODUCT")
	List<ProductBean> getAllProducts();
	
	@Insert("INSERT INTO PVK_PRODUCT (PRODUCT_ID, PRODUCT_TITLE, PRODUCT_DESC, PRODUCT_STATUS, PRODUCT_UNIT,UNIT_PRICE, UNIT_UOM, UPDATED_BY, UPDATED_DATE) "
			+ "VALUES(#{productId}, #{productName}, #{productDesc},#{productStatus},#{productUnit},#{unitPrice},#{UOM},#{updatedBy},#{updatedDate})")
	void saveProduct(ProductBean product);
	
	@Update("UPDATE PVK_PRODUCT SET CUSTOMER_NAME=#{productId}, PRODUCT_TITLE=#{productName}, PRODUCT_DESC=#{productDesc}, PRODUCT_STATUS=#{productStatus}, PRODUCT_UNIT=#{productUnit}, UNIT_PRICE=#{unitPrice}, UNIT_UOM=#{UOM}, UPDATED_BY=#{updatedBy}, UPDATED_DATE=#{updatedDate},  WHERE CUSTOMER_ID =#{customerId}")
	void updateProduct(ProductBean product);
	
	@Delete("DELETE PVK_CUSTOMER village WHERE PVK_PRODUCT =#{productId}")
	void deleteProduct(Long productId);
}
