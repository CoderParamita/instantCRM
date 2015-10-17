package com.pms.servlets;
import com.pms.buisnesslogic.ShowProduclist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.buisnesslogic.CreteProductWthValidation;
import com.pms.buisnesslogic.LogInValidation;;
/**
 * Servlet implementation class CreateProductDetails
 */

public class CreateProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String productName= request.getParameter("productname");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		float price=Float.parseFloat(request.getParameter("price"));
		String vendorName=request.getParameter("vendorname");
		
		if(CreteProductWthValidation.createProductWthValidate(productName, quantity,price,vendorName)){ 
			ShowProduclist lst= new ShowProduclist();
			request.getSession().setAttribute("productname", lst.showProductlist());
			RequestDispatcher rd=request.getRequestDispatcher("ProductList.jsp");    
            rd.forward(request,response); 
        } 
		else
		{
			 	out.print("<p style=\"color:red\">Sorry you are unable to insert same product</p>");    
	            RequestDispatcher rd=request.getRequestDispatcher("CreateProductDetails.jsp");    
	            rd.include(request,response);
		}

		
	}

}
