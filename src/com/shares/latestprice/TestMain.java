package com.shares.latestprice;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StockInfoFetcherIEX fetcher = new StockInfoFetcherIEX("MSFT");
		double thePrice = fetcher.getLatestPrice();
	}

}
