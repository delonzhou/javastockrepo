package com.oriborohov.javacourse.service;

import java.util.Calendar;
import java.util.Date;

import com.oriborohov.javacourse.model.Portfolio;
import com.oriborohov.javacourse.model.Stock;

public class PortfolioManager {
	
	public Portfolio getPortfolio() {
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 11, 15);
		
		Date date1 = cal.getTime();
		Date date2 = cal.getTime();
		Date date3 = cal.getTime();
		
		String portfolioTitle = "Portfolio 1";
		Stock stock1 = new Stock("PIH", (float)13.1, (float)12.4, date1);	
		Stock stock2 = new Stock("AAL", (float)5.78, (float)5.5, date2);		
		Stock stock3 = new Stock("CAAS", (float)32.2, (float)31.5, date3);
		
		int numOfStocks = 3;
		Stock[] stockArr = {stock1, stock2, stock3};
		Portfolio portfolio = new Portfolio(portfolioTitle,stockArr, numOfStocks);

		return portfolio;
	}
	
}
