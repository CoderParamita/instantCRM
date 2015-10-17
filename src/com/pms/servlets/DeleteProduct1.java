package com.pms.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.buisnesslogic.DeleteProductFromList;
import com.pms.buisnesslogic.ShowProduclist;;

/**
 * Servlet implementation class DeleteProduct
 */

public class DeleteProduct1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteProduct1() {
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
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int productId = Integer.parseInt(request.getParameter("productId"));
		DeleteProductFromList dpd = new DeleteProductFromList();
		if (dpd.deleteProduct(productId)) {
			ShowProduclist lst = new ShowProduclist();
			request.getSession().setAttribute("productname", lst.showProductlist());
			RequestDispatcher rd = request.getRequestDispatcher("ProductList.jsp");
			rd.include(request, response);

		}
	}

}
