package com.collabera.jump.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.collabera.jump.CustomerApp.Customer;
import com.collabera.jump.CustomerApp.CustomerAppDAO;
import com.collabera.jump.CustomerApp.CustomerAppDAOClass;
import com.collabera.jump.CustomerApp.Orders;
import com.collabera.jump.CustomerApp.Product;

/**
 * Servlet implementation class CustomerAppHubServe
 */
@WebServlet("/CustomerAppHubServe")
public class CustomerAppHubServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAppHubServe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		CustomerAppDAO cuAppDAO = new CustomerAppDAOClass();
		
		out.println("<html><body>");
		out.println("<center><table>"
				+ "<th><a href=CustomerAppHubServe>Hub</a></th>"
				+ "<th><a href=UpdateProductServe>Update Product Quantity</a></th>"
				+ "<th><a href=DeleteOrderServe>Delete Orders</a></th>"
				+ "</table></center>");
		
		out.println("<table border=1><th>Customer Number</th><th>Customer Name</th><th>Address</th><th>City</th><th>Country</th>");
		
		for (Customer cu : cuAppDAO.getAllCustomers()) {
			out.println(cu);
		}
		
		out.println("</table>");
		out.println("<table border=1><th>Product Code</th><th>Product Name</th><th>Product Price</th><th>Product Quantity</th>");
		
		for (Product pr : cuAppDAO.getAllProducts()) {
			out.println(pr);
		}
		
		out.println("</table>");
		out.println("<table border=1><th>Order Number</th><th>Customer Number</th><th>Product Code</th><th>Order Price</th><th>Order Quantity</th>");
		
		for (Orders or : cuAppDAO.getAllOrders()) {
			out.println(or);
		}
		
		out.println("</table>");
		
		out.println("<table border=1><th>Customer</th><th>Purchased</th>");
		for (Orders or : cuAppDAO.getCustomersAndProducts()) {
			out.println("<tr><td>" + or.getCustomer().getCustomerName() + "</td>"
					+ "<td>" + or.getProduct().getProductName() + "</td></tr>");
		}
		
		out.println("</table>");
		
		Product mostExpenPro = cuAppDAO.getMostExpensivePurchasedProduct();
		out.println("<table border=1><th colspan=2>Most Expensive Product</th>"
				+ "<tr><td>Product</td><td>Price</td></tr>"
				+ "<tr><td>" + mostExpenPro.getProductName() + "</td>"
				+ "<td>" + mostExpenPro.getProductPrice() + "</td></tr>");
		
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
