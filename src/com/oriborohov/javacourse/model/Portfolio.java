package com.oriborohov.javacourse.model;

import com.oriborohov.javacourse.Stock;

public class Portfolio {
	
	private static final int MAX_PORTFOLIO_SIZE = 5;
	
	private String title;
	private Stock[] stocks;
	private int portfolioSize = 0;
	
	public Portfolio(String title) {
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.title = title;
	}
	
	public void addStock (Stock stock) {
		if(stock != null && portfolioSize < MAX_PORTFOLIO_SIZE) {
			stocks[portfolioSize] = stock;
			portfolioSize++;
		}
		else {
			System.out.println("Portfolio is full or input is null!");
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
	
}
