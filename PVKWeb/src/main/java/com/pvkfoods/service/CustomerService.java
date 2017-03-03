package com.pvkfoods.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.pvkfoods.dto.request.CustomerRequest;
import com.pvkfoods.dto.request.CustomerResponse;

/**
 * 
 * @author prasadprabhakaran
 *
 */

@Produces({"application/xml","application/json"})
public interface CustomerService {
	
	@PUT
	@Path("/")
	public Long addCustomer(CustomerRequest customer);
	
	@GET
	@Path("/{id}/")
	public CustomerResponse getCustomer(@PathParam("id") Long id);
	
	@GET
	@Path("/")
	public CustomerResponse getCustomers();
	
	@POST
	@Path("/")
	public Long modifyCustomer(CustomerRequest customer);
	
	@DELETE
	@Path("/")
	public boolean deleteCustomer(@PathParam("id") Long id);
}
