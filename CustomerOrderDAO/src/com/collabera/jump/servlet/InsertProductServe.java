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
 * Servlet implementation class InsertProductServe
 */
@WebServlet("/InsertProductServe")
public class InsertProductServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProductServe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		CustomerAppDAO cuAppDAO = new CustomerAppDAOClass();
		
		int productCode = 0;
		String productName = "";
		int productPrice = 0;
		int productQuantity = 0;
				
		if (request.getParameter("productCode") != null) {
			productCode = Integer.valueOf(request.getParameter("productCode"));
		}
		
		if (request.getParameter("productName") != null) {
			productName = request.getParameter("productName");
		}
		
		if (request.getParameter("productPrice") != null) {
			productPrice = Integer.valueOf(request.getParameter("productPrice"));
		}
		
		if (request.getParameter("productQuantity") != null) {
			productQuantity = Integer.valueOf(request.getParameter("productQuantity"));
		}
		
		if (request.getParameter("productCode") != null) {
			if (cuAppDAO.insertNewProduct(productCode, productName, productPrice, productQuantity)) {
				System.out.println("New Product added");
			}
		}
		
		out.println("<html><body>");
		out.println("<center><table>"
				+ "<th><a href=CustomerAppHubServe>Hub</a></th>"
				+ "<th><a href=InsertProductServe>Insert New Product</a></th>"
				+ "<th><a href=UpdateProductServe>Update Product Quantity</a></th>"
				+ "<th><a href=InsertOrderServe>Insert New Orders</a></th>"
				+ "<th><a href=DeleteOrderServe>Delete Orders</a></th>"
				+ "</table></center>");
		
		out.println("<table border=1><th>Product Code</th><th>Product Name</th><th>Product Price</th><th>Product Quantity</th>");
		
		for (Product pr : cuAppDAO.getAllProducts()) {
			out.println(pr);
		}
		
		out.println("</table>");
		
		out.println("<form name=insertProductForm action=InsertProductServe method=GET>");
		out.println("<table><th>Product Code</th><th>Product Name</th><th>Product Price</th><th>Product Quantity</th>");
			out.println("<tr><td><input type=number name=productCode required></td>");
			out.println("<td><input type=text name=productName required></td>");
			out.println("<td><input type=number name=productPrice required></td>");
			out.println("<td><input type=number name=productQuantity required></td>");
			out.println("<td><input type=submit value=Insert></td></tr>");
		out.println("</form>");
				
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
