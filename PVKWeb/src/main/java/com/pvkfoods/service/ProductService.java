package com.pvkfoods.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.pvkfoods.dto.request.ProductRequest;
import com.pvkfoods.dto.request.ProductResponse;

/**
 * 
 * @author prasadprabhakaran
 *
 */
@Produces({"application/xml","application/json"})
public interface ProductService {
	
	@PUT
	@Path("/")
	public Long addProduct(ProductRequest product) throws ServiceException;
	
	@GET
	@Path("/{id}/")
	public ProductResponse getProduct(@PathParam("id") Long id) throws ServiceException;
	
	@GET
	@Path("/")
	public ProductResponse getProducts() throws ServiceException;
	
	@POST
	@Path("/")
	public Long modifyProduct(ProductRequest product) throws ServiceException;
	
	@DELETE
	@Path("/")
	public boolean deleteProduct(@PathParam("id") Long id) throws ServiceException;

}
