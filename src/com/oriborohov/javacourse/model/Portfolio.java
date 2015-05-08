package com.oriborohov.javacourse.model;

import java.util.Date;

public class Portfolio {
	
	private static final int MAX_PORTFOLIO_SIZE = 5;
	
	private String title;
	private Stock[] stocks;
	private int portfolioSize = 0;
	
	public Portfolio(String title, Stock[] stock, int size) { // portfolio constructor
		this.title = title;
		this.stocks = stock;
		this.portfolioSize = size;
	}
		
	public Portfolio(Portfolio copyPortfolio) { // portfolio copy constructor
		this.title = getTitle();
		
		for (int i=0; i < copyPortfolio.getPortfolioSize(); i++)
		{
			String symbol = copyPortfolio.stocks[i].getSymbol();
			float ask = copyPortfolio.stocks[i].getAsk();
			float bid = copyPortfolio.stocks[i].getBid();
			Date date = copyPortfolio.stocks[i].getDate();
			Stock stock = new Stock(symbol,ask,bid,date);
			this.stocks[i] = stock;
		}
		this.portfolioSize = copyPortfolio.getPortfolioSize();

	}
	
	public void addStock (Stock stock) { // adds stock to portfolio
		if(stock != null && portfolioSize < MAX_PORTFOLIO_SIZE) {
			stocks[portfolioSize] = stock;
			portfolioSize++;
		}
		else {
			System.out.println("Portfolio is full or input is null!");
		}	
	}
	
	public void removeStock(String eraseSymbol) // removes stock from portfolio
	{
		if (stocks[portfolioSize-1].getSymbol().equals(eraseSymbol))
		{
			stocks[portfolioSize-1] = null;
			portfolioSize--;
		}
		else
		{
			for (int i=0; i < portfolioSize; i++)
			{
				if (this.stocks[i].getSymbol().equals(eraseSymbol))
				{
					this.stocks[i] = this.stocks[portfolioSize-1];
					this.stocks[portfolioSize-1] = null;
					portfolioSize--;
				}
			}
		}
	}
				
	public Stock[] getStock() {
		return stocks;
	}
	
	public String getHtmlString() {
		String output = new String("<h1>" + title + "</h1>");
		for(int i = 0; i < portfolioSize ;i++) {
			output += this.stocks[i].getHtmlDescription() + "<br>";
		}
		return output;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Stock[] getStocks() {
		return stocks;
	}

	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}
	
	public int getPortfolioSize()
	{
		return portfolioSize; 	
	}
	
}
