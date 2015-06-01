package com.oriborohov.javacourse.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.algo.model.StockInterface;

import com.oriborohov.javacourse.model.Portfolio.ALGO_RECOMMENDATION;

public class Stock implements StockInterface {
	
	private String symbol;
	private float ask;
	private float bid;
	private Date date;
	private ALGO_RECOMMENDATION recommendation;
	private int stockQuantity;
	
	// Empty constructor
	public Stock() 
	{
	}
	
	// Default constructor
	public Stock(String symbol, float ask, float bid, Date date, int stockQuantity) 
	{
		super();
		this.symbol = symbol;
		this.ask = ask;
		this.bid = bid;
		this.date = date;
		this.stockQuantity = stockQuantity;
	}
	
	// Copy Constructor
	public Stock(Stock stockToCopy) 
	{
		this(new String(stockToCopy.getSymbol()), 
			 stockToCopy.getAsk(), 
			 stockToCopy.getBid(), 
			 new Date(stockToCopy.getDate().getTime()),
			 stockToCopy.getStockQuantity());
	}
	
	// Get the Stock's Symbol
	public String getSymbol() {
		return symbol;
	}

	// Set the Stock's Symbol
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	// Get the Stock's Ask price
	public float getAsk() {
		return ask;
	}

	// Set the Stock's Ask price
	public void setAsk(float ask) {
		this.ask = ask;
	}

	// Get the Stock's Bid price
	public float getBid() {
		return bid;
	}

	// Set the Stock's Bid price
	public void setBid(float bid) {
		this.bid = bid;
	}

	// Get the Stock's Date
	public Date getDate() {
		return date;
	}
	
	// Set the Stock's Date
	public void setDate(Date date) {
		this.date = date;
	}
	
	// Set the Stock's Date from Long
	public void setDate(long time) 
	{
		this.date = new Date(time);
	}
	
	// Get the Stock's Quantity
	public int getStockQuantity() {
		return stockQuantity;
	}

	// Set the Stock's Quantity
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	// Get the Stock's Recommendation
	public Enum<ALGO_RECOMMENDATION> getRecommendation() 
	{
		return this.recommendation;
	}

	// Set the Stock's Recommendation
	public void setRecommendation(ALGO_RECOMMENDATION valueOf) 
	{
		this.recommendation = valueOf;
	}
	
	public String getHtmlDescription()
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dateToStr = simpleDateFormat.format(getDate());

		return(new String("<b>Stock Symbol: </b>" + getSymbol() +
						  " <b>Bid: </b>" + getBid() +
						  " <b>Ask: </b>" + getAsk() + 
						  " <b>Date: </b>" + dateToStr +
						  " <b>Quantity: </b>" + getStockQuantity()));
	}
}
