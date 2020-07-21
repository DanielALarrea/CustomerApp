package com.collabera.jump.CustomerApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerAppDAOClass implements CustomerAppDAO {
	//list is working as a database
	List<Customer> customerList;
	List<Product> productList;
	List<Orders> orderList;

	public CustomerAppDAOClass(){
		customerList = new ArrayList<Customer>();
		productList = new ArrayList<Product>();
		orderList = new ArrayList<Orders>();
	}

	//retrieve list of Customers from the database
	@Override
	public List <Customer> getAllCustomers() {
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
			List<Customer> customerList = new ArrayList<Customer>();

			while(rs.next())
			{
				Customer customer = new Customer();
				customer.setCustomerNum(rs.getInt("customernumber"));
				customer.setCustomerName(rs.getString("customername"));
				customer.setCity(rs.getString("city"));
				customer.setAddress(rs.getString("address"));
				customer.setCountry(rs.getString("country"));
				customerList.add(customer);
			}
//			con.close();
			stmt.close();
			rs.close();
			return customerList;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	//retrieve list of Products from the database
	@Override
	public List <Product> getAllProducts() {
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM product");
			List<Product> productList = new ArrayList<Product>();

			while(rs.next())
			{
				Product product = new Product();
				product.setProductCode(rs.getInt("productcode"));
				product.setProductName(rs.getString("productname"));
				product.setProductPrice(rs.getInt("productprice"));
				product.setProductQuantity(rs.getInt("productquantity"));
				productList.add(product);
			}
//			con.close();
			stmt.close();
			rs.close();
			return productList;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	//retrieve list of Orders from the database
	@Override
	public List <Orders> getAllOrders() {
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
			List<Orders> orderList = new ArrayList<Orders>();

			while(rs.next())
			{
				Orders order = new Orders();
				order.setOrderNum(rs.getInt("ordernumber"));
				order.setCustomerNum(rs.getInt("customernumber"));
				order.setProductCode(rs.getInt("productcode"));
				order.setOrderPrice(rs.getInt("orderprice"));
				order.setOrderQuantity(rs.getInt("orderquantity"));
				orderList.add(order);
			}
//			con.close();
			stmt.close();
			rs.close();
			return orderList;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	// Update the quantity of a given Product
	@Override
	public boolean updateProductQuantity(int proCode, int newQuantity) {
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("UPDATE product SET productquantity=? WHERE productcode=?");
			ps.setInt(1, newQuantity);
			ps.setInt(2, proCode);

			int i = ps.executeUpdate();

			if(i == 1) {
				return true;
			}
//			connection.close();
			ps.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}

	// Return all the Customers and products they ordered
	public List<Orders> getCustomersAndProducts() {
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from orders "
					+ "inner join customer "
					+ "on orders.customernumber = customer.customernumber "
					+ "inner join product "
					+ "on orders.productcode = product.productcode");
			List<Orders> orderList = new ArrayList<Orders>();

			while(rs.next())
			{
				Orders order = new Orders();
				Customer customer = new Customer();
				Product product = new Product();
				customer.setCustomerName(rs.getString("customerName"));
				product.setProductName(rs.getString("productname"));
				order.setCustomer(customer);
				order.setProduct(product);
				orderList.add(order);
			}
//			con.close();
			stmt.close();
			rs.close();
			return orderList;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	// Delete all the Orders for a Product by a Customer
	@Override
	public void deleteAllOrdersByCustomer(int customerNum, int proCode) {
		// Delete all orders for with a specific ProductCode according to a specific CustomerNumber
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			PreparedStatement ps = con.prepareStatement("delete from orders where customernumber = ? and productcode = ?");
			ps.setInt(1, customerNum);
			ps.setInt(2, proCode);

			int i = ps.executeUpdate();
			if(i != 0) {
				System.out.println("Orders by Customer " + customerNum + " of Product " + proCode + " were deleted");
			}
//			con.close();
			ps.close();
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	// Return the most expensive product that has been purchased
	@Override
	public Product getMostExpensivePurchasedProduct() {
		Connection con = ConnectionFactory.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select max(productprice) as mostexpensive from product "
					+ "join orders "
					+ "on orders.productcode = product.productcode;");
			Product mostExpenPro = new Product();
			int mostExpenVal = 0;

			while(rs.next())
			{
				mostExpenPro.setProductPrice(rs.getInt("mostexpensive"));
				mostExpenVal = rs.getInt("mostexpensive");
			}

			rs = stmt.executeQuery("select productname from product "
					+ "where productprice = " + mostExpenVal);

			while(rs.next()) {
				mostExpenPro.setProductName(rs.getString("productname"));
			}
//			con.close();
			stmt.close();
			rs.close();
			return mostExpenPro;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
