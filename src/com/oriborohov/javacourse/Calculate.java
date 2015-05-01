package com.oriborohov.javacourse;

	import java.io.IOException;
	
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	public class Calculate extends HttpServlet{
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			resp.setContentType("text/html");
			
			int radius = 50;
			double area = radius*radius*Math.PI;
			
			int angleB = 30;
			double length = java.lang.Math.sin(angleB * Math.PI / 180)*50;
			
			int base = 20;
			int exp = 13;
			double result = java.lang.Math.pow(base,exp);
			
			String line1 = new String("Calculation 1: Area of circle with radius "+radius+" is "+area+" square-cm");
			String line2 = new String("Calculation 2: Length of opposite where angle B is "+angleB+" degrees and Hypotenuse length is 50 cm is: "+length+" cm");
			String line3 = new String("Calculation 3: Power of "+base+" with exp of "+exp+" is "+result);
			
			String resultStr = line1 + "<br>" + line2 + "<br>" +line3;
			resp.getWriter().println(resultStr);
		}

}
