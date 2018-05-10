package com.db.customer;


import java.io.IOException;

/**
 * @author roccap
 */
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

@Path("/addNewCustomer")
public class AddNewCustomer {


	@GET
	@Produces("application/xml")
	public int addCustomer() {		
	 
			return -1;
	}
	
	@Path("{s}")
	@GET
	@Produces("application/json")
	public Response addCustomer(@PathParam("s") String customerData) throws JSONException {

		ObjectMapper mapper = new ObjectMapper();
		String name = "ziggy";
        try {
            Customer customer = mapper.readValue(customerData, Customer.class);
            
            name = customer.getFirstName();
            System.out.print(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		JSONObject jsonObject = new JSONObject();
	/*	float celsius;
		celsius =  (f - 32)*5/9; 
		jsonObject.put("F Value", f); */
		jsonObject.put("Success", name);

		String result = "@Produces(\"application/json\") Output: \n\nAdd Customer: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
	 
}

/* 
 {firstName:"Bob",lastName:"Smith"} 
  
  
 * */
