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
	
	@ResultMap(value="ordersMap")
	@Select("select O.ORDER_ID, O.TOT_AMOUNT, O.ORDER_DATE, O.SALES_AGENT_ID, U.USER_ID, U.USERNAME, U.FIRST_NAME, U.LAST_NAME, U.EMAIL, "
			+ "O.CUSTOMER_ID, C.CUSTOMER_ID, C.CUSTOMER_NAME, OD.QUANTITY, OD.UOM, P.PRODUCT_ID, P.PRODUCT_TITLE "
			+ "FROM PVK_ORDER O, PVK_USER U, PVK_CUSTOMER C,  PVK_ORDER_PRODUCT OD, PVK_PRODUCT P "
			+ "WHERE O.SALES_AGENT_ID = U.USER_ID AND O.CUSTOMER_ID = C.CUSTOMER_ID AND O.ORDER_ID = OD.ORDER_ID "
			+ "AND OD.PRODUCT_ID = P.PRODUCT_ID")
	List<OrderBean> getAllOrders();
}
