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
import com.collabera.jump.CustomerApp.Product;

/**
 * Servlet implementation class UpdateProductServe
 */
@WebServlet("/UpdateProductServe")
public class UpdateProductServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		CustomerAppDAO cuAppDAO = new CustomerAppDAOClass();
		
		int updateProCode = 0;
		int newQuantity = 0;
		
		if (request.getParameter("productCode") != null) {
			updateProCode = Integer.valueOf(request.getParameter("productCode"));
		}
		if (request.getParameter("quantity") != null) {
			newQuantity = Integer.valueOf(request.getParameter("quantity"));
		}
		
		if (request.getParameter("productCode") != null) {
			if (cuAppDAO.updateProductQuantity(updateProCode, newQuantity)) {
				System.out.println("Product " + updateProCode + " was updated to have Quantity " + newQuantity);
			}
		}
		
		out.println("<html><body>");
		out.println("<center><table>"
				+ "<th><a href=CustomerAppHubServe>Hub</a></th>"
				+ "<th><a href=UpdateProductServe>Update Product Quantity</a></th>"
				+ "<th><a href=DeleteOrderServe>Delete Orders</a></th>"
				+ "</table></center>");
		
		out.println("<table border=1><th>Product Code</th><th>Product Name</th><th>Product Price</th><th>Product Quantity</th>");
		
		for (Product pr : cuAppDAO.getAllProducts()) {
			out.println(pr);
		}
		
		out.println("</table>");
		
			
		
		out.println("<form name=updateProductForm action=UpdateProductServe method=GET>");
		out.println("<table><th>Product Code</th><th>Quantity</th>");
			out.println("<tr><td><input type=number name=productCode required></td>");
			out.println("<td><input type=number name=quantity required></td>");
			out.println("<td><input type=submit value=Update></td></tr>");
		out.println("</form>");
		
		
		
//		System.out.println("Please enter the Product Code you would like to update: ");
//		updateProCode = scan.nextInt();
//		System.out.println("Please enter the new quantity of product " + updateProCode + ":");
//		newQuantity = scan.nextInt();
//		if (cuAppDAO.updateProductQuantity(updateProCode, newQuantity)) {
//			System.out.println("Product " + updateProCode + " was updated to have Quantity " + newQuantity);
//		}
		
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
