package com.pvkfoods.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.pvkfoods.dto.request.OrderRequest;
import com.pvkfoods.dto.request.OrderResponse;
import com.pvkfoods.dto.request.OrderSearchRequest;


/**
 * 
 * @author prasadprabhakaran
 *
 */
@Produces({"application/xml","application/json"})
public interface OrderService {
	
	@PUT
	@Path("/")
	public Long createOrder(OrderRequest orderRequest);
	
	@GET
	@Path("/{id}/")
	public OrderResponse getOrder(@PathParam("id") Long id);
	
	@GET
	@Path("/")
	public OrderResponse getOrders(OrderSearchRequest orderRequest);
	
	@POST
	@Path("/")
	public Long modifyOrder(OrderRequest orderRequest);
	
	@DELETE
	@Path("/")
	public boolean deleteOrder(@PathParam("id") Long id);
}
