package com.pms.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.buisnesslogic.CreateUserWthValidation;
/**
 * Servlet implementation class CreateUser
 */
//@WebServlet("/createuser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
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
		String userName=request.getParameter("username");
		String passWord=request.getParameter("password");
		CreateUserWthValidation cuw=new CreateUserWthValidation();
		if(cuw.createuser(userName, passWord))
		{
			out.print("<p style=\"color:red\">You Have Succesfully Registered.Please Login Here</p>");    
            RequestDispatcher rd=request.getRequestDispatcher("LogIn.jsp");    
            rd.include(request,response);
		}
		else
		{
			out.print("<p style=\"color:red\">Sorry You Can't Registered With Same Username</p>");    
            RequestDispatcher rd=request.getRequestDispatcher("SignIn.jsp");    
            rd.include(request,response);
		}
		
		
	}

}
