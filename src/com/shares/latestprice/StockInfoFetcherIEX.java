package com.shares.latestprice;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;



public class StockInfoFetcherIEX {
	private Double latestPrice;
	private String tickerSymbol;
	private String baseIEXAddress = "https://api.iextrading.com/1.0/stock/";
	private String quoteSuffix = "/batch?types=quote,news,chart&range=1m&last=10";
	private String simplePriceSuffix = "/price";
	public StockInfoFetcherIEX(String tickerSymbol) {
		super();
		this.tickerSymbol = tickerSymbol;
	}
	public double getLatestPrice() {
		Double price = 0.0;
		String queryString = baseIEXAddress +this.tickerSymbol+ this.simplePriceSuffix;
		String responseString = executePost(queryString);
		//for simple price quote - response is floating point number
		try 
		{
			price = Double.parseDouble(responseString);
		}
		catch (NumberFormatException e) 
		{
			
		}
		return price;
	}

	private static String executePost(String targetURL) {
		 String output = "";
		 try
		 {
			 URL yahoo = new URL(targetURL);
			 URLConnection yc = yahoo.openConnection();
			 BufferedReader in = new BufferedReader(
	                                new InputStreamReader(
	                                yc.getInputStream()));
	        String inputLine;

	        while ((inputLine = in.readLine()) != null) 
	            System.out.println(inputLine);
	        in.close();
		 }
		 catch(Exception ex)
		 {
		 }
		 return output;    
	}
	
}
