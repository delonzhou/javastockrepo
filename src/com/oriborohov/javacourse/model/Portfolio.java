package com.oriborohov.javacourse.model;

import java.util.Date;

public class Portfolio 
{
	public enum ALGO_RECOMMENDATION {BUY, SELL, REMOVE, HOLD};
	
	private String title;
	private final static int MAX_PORTFOLIO_SIZE = 5;
	private Stock[] stocks;
	private int currPortfolioIndex;
	private float balance;
	
	// Empty Constructor
	public Portfolio() 
	{
		super();
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		currPortfolioIndex = 0;
		balance = 0;
	}
	
	// Copy Constructor
	public Portfolio(Portfolio portfolioToCopy) 
	{
		title = portfolioToCopy.getTitle();
		currPortfolioIndex = portfolioToCopy.getCurrPortfolioIndex();
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		balance = portfolioToCopy.getBalance();

		for(int i = 0; i < currPortfolioIndex; i++)
		{
			stocks[i] = new Stock(portfolioToCopy.getStocks()[i]);
		}
	}
	
	// Return the Stocks array
	public Stock[] getStocks() 
	{
		return stocks;
	}
	
	// Return the Portfolio title
	public String getTitle()
	{
		return title;
	}

	// Set the Title of the Portfolio
	public void setTitle(String newTitle)
	{
		title = newTitle;
	}
	
	// Return the current Portfolio index
	public int getCurrPortfolioIndex()
	{
		return currPortfolioIndex;
	}
	
	// Set the current Portfolio index
	public void setCurrPortfolioIndex(int newIndex)
	{
		currPortfolioIndex = newIndex;
	}
	
	public void addStock(Stock stockToAdd)
	{
		// If Stock is not valid
		if(stockToAdd == null)
		{
			System.out.println("Stock is not valid!");
		}
		
		// If Portfolio is full
		else if (currPortfolioIndex >= MAX_PORTFOLIO_SIZE)
		{
			System.out.println("Can't add new Stock, portfolio can have only " + MAX_PORTFOLIO_SIZE + " stocks");
		}
		
		// If Stock is valid, Portfolio is not full and Stock doesn't already exists
		else if(isStockInPortfolio(stockToAdd.getSymbol()) == -1)
		{
			stocks[currPortfolioIndex] = stockToAdd;
			stocks[currPortfolioIndex].setStockQuantity(0);
			currPortfolioIndex++;
		}
	}
	
	public int isStockInPortfolio(String symbolToFind)
	{
		for(int i = 0; i < currPortfolioIndex; i++)
		{
			if (stocks[i].getSymbol().equals(symbolToFind))
			{
				return(i);
			}
		}
		
		return(-1);
	}
	
	// Update the current balance of portfolio
	public void updateBalance(float amount)
	{
		if(balance + amount < 0)
			System.out.println("Portfolio Balance cannot be negative!");
		else
			balance += amount;
	}
	
	public boolean buyStock(Stock stockToBuy, int quantity)
	{
		int indexToBuy = isStockInPortfolio(stockToBuy.getSymbol());
		float totalPurchaseSum = 0;
		
		if(indexToBuy != -1)
		{
			if(quantity == -1)
			{
				quantity = (int)(getBalance() / stocks[indexToBuy].getAsk());
			}
			
			totalPurchaseSum = quantity * stocks[indexToBuy].getAsk();
			
			if(totalPurchaseSum > getBalance())
			{
				System.out.println("Not enough balance to complete the purchase!");
				return (false);
			}
			else
			{
				stocks[indexToBuy].setStockQuantity(stocks[indexToBuy].getStockQuantity() + quantity);
				updateBalance((-1) * quantity * stocks[indexToBuy].getAsk());				
				return (true);
			}
		}
		// If the Stock to Buy is not in the Portfolio
		else
		{
			if(quantity == -1)
			{
				// Calculate how much can be Bought with the current Balance
				quantity = (int)(getBalance() / stockToBuy.getAsk());
			}
			
			totalPurchaseSum = quantity * stockToBuy.getAsk();
			
			if(totalPurchaseSum > getBalance())
			{
				System.out.println("Not enough Balance to complete Purchase!");
				return (false);
			}
			
			// If the Total Purchase Sum is valid
			else
			{
				addStock(stockToBuy);
				stocks[currPortfolioIndex - 1].setStockQuantity(quantity);
				updateBalance((-1) * quantity * stockToBuy.getAsk());
				return (true);
			}
		}
	}
	
	
	public boolean sellStock(String symbolToSell, int quantity)
	{
		int indexToSell = isStockInPortfolio(symbolToSell);
		
		// If the stock to sell is not found in the portfolio
		if(indexToSell == -1)
		{
			System.out.println("Given Stock is not found in the Portfolio!");
			return (false);
		}
		
		// If the stock to sell quantity is bigger than availiable
		else if(quantity > stocks[indexToSell].getStockQuantity())
		{
			System.out.println("Not enough Stocks to Sell!");
			return (false);
		}
		
		// If the Stock and the Quantity are valid
		else
		{
			// If received quantity to sell is ALL
			if (quantity == -1)
			{
				// Sell the whole Stock
				quantity = stocks[indexToSell].getStockQuantity();
			}
			
			// Update the Sold Stock's quantity
			stocks[indexToSell].setStockQuantity(stocks[indexToSell].getStockQuantity() - quantity);
			
			updateBalance(quantity * stocks[indexToSell].getBid());
			
			return (true);
		}
		
	}
	
	public boolean removeStock(String symbolToRemove)
	{
		int indexToRemove = isStockInPortfolio(symbolToRemove);
		
		// If the Stock to remove is found in the Portfolio
		if(indexToRemove != -1)
		{
			sellStock(symbolToRemove, -1);
			
			for(int i = indexToRemove; i < currPortfolioIndex - 1; i++)
			{
				stocks[i] = stocks[i + 1];
			}
			stocks[currPortfolioIndex - 1] = null;
			currPortfolioIndex--;
			return (true);
		}
		
		// If the stock to remove is not in the portfolio
		return (false);
	}
	
	
	// Returns total value of all stocks
	public float getStocksValue()
	{
		float totalValue = 0;
		for(int i = 0; i < currPortfolioIndex; i++)
		{
			totalValue += stocks[i].getStockQuantity() * stocks[i].getBid();
		}
		
		return (totalValue);
	}
	
	// Return the sum of all Stocks and Portfolio's Balance
	public float getTotalValue()
	{
		return (getStocksValue() + getBalance());
	}
	
	public float getBalance()
	{
		return balance;
	}

	public String getHtmlString()
	{
		String retStr = new String("<h1>Portfolio Title: " + getTitle() + "</h1>");
		retStr += "<b>Total Portfolio Value: </b>" + getTotalValue() + "$" +
				  " <b>Total Stocks Value: </b>" + getStocksValue() + "$" +
				  " <b>Balance: </b>" + getBalance() + "$<br>";
		retStr += "{<br>";
				
		for(int i = 0; i < currPortfolioIndex; i++)
		{
			// Add current Stock's info
			retStr += "&nbsp;&nbsp;&nbsp;&nbsp;" + stocks[i].getHtmlDescription() + "<br>";
		}
		retStr += "}";
		return(retStr);
	}
}