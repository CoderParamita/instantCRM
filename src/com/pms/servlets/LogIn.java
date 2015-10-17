package com.pms.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.pms.buisnesslogic.LogInValidation;
import com.pms.buisnesslogic.ShowProduclist;

/**
 * Servlet implementation class LogIn
 */

public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("username");
		String upwd = request.getParameter("userpwd");

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.setAttribute("username", uname);
		}

		if (LogInValidation.validate(uname, upwd)) {

			ShowProduclist lst = new ShowProduclist();

			request.getSession().setAttribute("productname", lst.showProductlist());

			RequestDispatcher rd = request.getRequestDispatcher("ProductList.jsp");
			rd.forward(request, response);

		} else {
			out.print("<p style=\"color:red\">Sorry invalid username or password</p>");
			RequestDispatcher rd = request.getRequestDispatcher("LogIn.jsp");
			rd.include(request, response);
		}

	}

}
