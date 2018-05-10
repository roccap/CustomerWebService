package com.db.customer;


/**
 * @author roccap
 */
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
public class AddNewCustomer {

	@Path("/addNewCustomer")
	@GET
	@Produces("application/xml")
	public int addCustomer() {		
	 
			return -1;
	}
	 
}
