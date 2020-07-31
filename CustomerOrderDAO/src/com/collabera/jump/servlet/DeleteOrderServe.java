package com.collabera.jump.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.collabera.jump.CustomerApp.CustomerAppDAO;
import com.collabera.jump.CustomerApp.CustomerAppDAOClass;
import com.collabera.jump.CustomerApp.Orders;
import com.collabera.jump.CustomerApp.Product;

/**
 * Servlet implementation class DeleteOrderServe
 */
@WebServlet("/DeleteOrderServe")
public class DeleteOrderServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOrderServe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		CustomerAppDAO cuAppDAO = new CustomerAppDAOClass();
		
		int deleteCustomerName = 0;
		int deleteProCode = 0;
		
		if (request.getParameter("customerCode") != null) {
			deleteCustomerName = Integer.valueOf(request.getParameter("customerCode"));
		}
		if (request.getParameter("productCode") != null) {
			deleteProCode = Integer.valueOf(request.getParameter("productCode"));
		}
		
		if (request.getParameter("customerCode") != null) {
			cuAppDAO.deleteAllOrdersByCustomer(deleteCustomerName, deleteProCode);
		}
		
		out.println("<html><body>");
		out.println("<center><table>"
				+ "<th><a href=CustomerAppHubServe>Hub</a></th>"
				+ "<th><a href=InsertProductServe>Insert New Product</a></th>"
				+ "<th><a href=UpdateProductServe>Update Product Quantity</a></th>"
				+ "<th><a href=InsertOrderServe>Insert New Orders</a></th>"
				+ "<th><a href=DeleteOrderServe>Delete Orders</a></th>"
				+ "</table></center>");
		
		out.println("<table border=1><th>Order Number</th><th>Customer Number</th><th>Product Code</th><th>Order Price</th><th>Order Quantity</th>");
		
		for (Orders or : cuAppDAO.getAllOrders()) {
			out.println(or);
		}
		
		out.println("<form name=deleteOrderForm action=DeleteOrderServe method=GET>");
		out.println("<table><th>Customer Code</th><th>Product Code</th>");
			out.println("<tr><td><input type=number name=customerCode required></td>");
			out.println("<td><input type=number name=productCode required></td>");
			out.println("<td><input type=submit value=Delete></td></tr>");
		out.println("</form>");
		
		out.println("</table>");
		
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
