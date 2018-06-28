package com.shares.latestprice;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

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

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@Path("/getLatestPrice")
public class GetLatestPrice {


	@Path("{s}")
	@GET
	@Produces("application/json")
	public Response getStockPrice(@PathParam("s") String tickerSymbol) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("TickerSymbol", tickerSymbol);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			jsonObject.put("DateTime", dtf.format(now));
			Integer price = 2;
			jsonObject.put("LatestPrice", price);
			
        
           
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	/*	float celsius;
		celsius =  (f - 32)*5/9; 
		jsonObject.put("F Value", f); */
		

		String result = "@Produces(\"application/json\") Output: \n\nGet Price : \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
	 
}

/* 
 {firstName:"Bob",lastName:"Smith"} 
  
  
 * */

