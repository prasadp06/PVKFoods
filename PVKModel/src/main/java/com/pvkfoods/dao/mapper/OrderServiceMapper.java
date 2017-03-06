package com.pvkfoods.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.pvkfoods.dao.bean.OrderBean;

/**
 * 
 * @author prasadprabhakaran
 *
 */
public interface OrderServiceMapper {
	
	
	List<OrderBean> getAllOrders();
}
