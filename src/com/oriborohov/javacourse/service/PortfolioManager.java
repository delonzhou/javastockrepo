package com.oriborohov.javacourse.service;

import java.util.Calendar;
import java.util.Date;

import com.oriborohov.javacourse.model.Portfolio;
import com.oriborohov.javacourse.model.Stock;

public class PortfolioManager 
{
	// Return portfolio
	public Portfolio getPortfolio()
	{
		Portfolio myPortfolio = new Portfolio();
		myPortfolio.setTitle("Exercise 7 portfolio");
		myPortfolio.updateBalance(10000);
		
		Calendar calendar1 = Calendar.getInstance();
		calendar1.set(2014, 12, 15);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(2014, 12, 15);
		Calendar calendar3 = Calendar.getInstance();
		calendar3.set(2014, 12, 15);
		
		Stock stock1 = new Stock("PIH", (float)10, (float)8.5, calendar1.getTime(), 0);
		Stock stock2 = new Stock("AAL", (float)30, (float)25.5, calendar2.getTime(), 0);
		Stock stock3 = new Stock("CAAS", (float)20, (float)15.5, calendar3.getTime(), 0);
		
		myPortfolio.buyStock(stock1, 20);
		myPortfolio.buyStock(stock2, 30);
		myPortfolio.buyStock(stock3, 40);
		
		// Sell all stocks of symbol AAL
		myPortfolio.sellStock("AAL", -1);
		
		// Remove all stocks of symbol CAAS
		myPortfolio.removeStock("CAAS");
		
		return(myPortfolio);
	}
}