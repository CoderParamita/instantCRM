package com.pms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.buisnesslogic.ShowProducDetailsForEdit;
import com.pms.buisnesslogic.ShowProductLIstBean;

/**
 * Servlet implementation class EditProductDetails
 */

public class EditProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProductDetails() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		String productId = request.getParameter("productId");
		String productName = request.getParameter("productName");

		int qnty = Integer.parseInt(request.getParameter("quantity"));
		Float prce = Float.parseFloat(request.getParameter("price"));
		String vendorName = request.getParameter("vname");

		request.getSession().setAttribute("productId", productId);
		request.getSession().setAttribute("productname", productName);
		request.getSession().setAttribute("quantity", qnty);
		request.getSession().setAttribute("price", prce);
		request.getSession().setAttribute("vendorName", vendorName);
		RequestDispatcher rd = request.getRequestDispatcher("Edit.jsp");
		rd.include(request, response);

	}

}
