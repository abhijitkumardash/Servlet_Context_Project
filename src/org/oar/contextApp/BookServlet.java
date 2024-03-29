package org.oar.contextApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/bp")
public class BookServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		ServletContext ctx=getServletContext();
	       String offmsg=ctx.getInitParameter("ofm");
	       String offperc=ctx.getInitParameter("ofp");
	       
	       //CONTEXT OBJECT IS FETCHED BACK FROM SCOPE OR ENVIRONMENT OF APPLICATION//
	      Product pd=(Product)ctx.getAttribute("prd");
	      
	      PrintWriter out=resp.getWriter();
	       out.println("<html><body bgcolor='yellow'>"
	       		+ "<h1>Book Product Details</h1><p>"
	       		+ ""+offmsg+""+offperc+"%off"
	       				+ "<br><a href=\"product.html\">Back</a>"
	       				+ "</body></html>");
	       out.flush();
	       out.close();
	}

}
