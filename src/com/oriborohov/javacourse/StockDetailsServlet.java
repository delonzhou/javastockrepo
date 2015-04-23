package com.oriborohov.javacourse;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.*;


public class StockDetailsServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
	
	Date date1 = new Date("11/15/2014");

	Stock stock1 = new Stock("PIH", (float)13.1, (float)12.4, date1);

	Stock stock2 = new Stock("AAL", (float)5.78, (float)5.5, date1);

	Stock stock3 = new Stock("CAAS", (float)32.2, (float)31.5, date1);
	
	resp.setContentType("text/html");

	resp.getWriter().println(stock1.getHtmlDescription() + "<br>" +

	stock2.getHtmlDescription() + "<br>" +

	stock3.getHtmlDescription());
	
	}
	
}
