package com.oriborohov.javacourse.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oriborohov.javacourse.model.Portfolio;
import com.oriborohov.javacourse.service.PortfolioManager;

@SuppressWarnings("serial")
public class portfolioServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException 
	{
		resp.setContentType("text/html");
		PortfolioManager portfolioManager = new PortfolioManager();
		Portfolio testPortfolio1 = portfolioManager.getPortfolio();
		resp.getWriter().println(testPortfolio1.getHtmlString());
	}
}