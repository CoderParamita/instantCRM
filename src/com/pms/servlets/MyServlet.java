package com.pms.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
		    ServletOutputStream out=response.getOutputStream();
		    out.println("<html>");
		    out.println("<head>");
		    out.println("Jai Hanumanji");
		    out.println("</head>");
		    out.println("</html>");
		    out.close();
	}

}
