package com.oriborohov.javacourse.service;

import java.util.Date;

import com.oriborohov.javacourse.Stock;
import com.oriborohov.javacourse.model.Portfolio;

public class PortfolioManager {
	
	public Portfolio getPortfolio() {
		Portfolio portfolio = new Portfolio("portfolio");

		Date date1 = new Date("11/15/2014");
		
		Stock stock1 = new Stock("PIH", (float)13.1, (float)12.4, date1);
		portfolio.addStock(stock1);
		
		Stock stock2 = new Stock("AAL", (float)5.78, (float)5.5, date1);
		portfolio.addStock(stock2);
		
		Stock stock3 = new Stock("CAAS", (float)32.2, (float)31.5, date1);
		portfolio.addStock(stock3);
		
		return portfolio;
	}
	
}
