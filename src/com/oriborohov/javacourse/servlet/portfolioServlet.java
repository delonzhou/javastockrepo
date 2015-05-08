package com.oriborohov.javacourse.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oriborohov.javacourse.model.Portfolio;
import com.oriborohov.javacourse.service.PortfolioManager;

@SuppressWarnings("serial")
public class portfolioServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		
		PortfolioManager pManager = new PortfolioManager();
		Portfolio portfolio1 = pManager.getPortfolio();
		Portfolio portfolio2 = new Portfolio(portfolio1);
		
		portfolio2.setTitle("Portfolio 2");
		
		resp.getWriter().println(portfolio1.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
		
		portfolio1.removeStock(portfolio1.getStocks()[0].getSymbol());
		
		resp.getWriter().println(portfolio1.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());
		
		portfolio2.getStocks()[portfolio2.getPortfolioSize()-1].setBid((float)55.55);
		
		resp.getWriter().println(portfolio1.getHtmlString());
		resp.getWriter().println(portfolio2.getHtmlString());	
	}
}
