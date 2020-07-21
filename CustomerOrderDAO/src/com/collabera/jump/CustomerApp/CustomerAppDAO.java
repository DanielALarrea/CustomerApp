package com.collabera.jump.CustomerApp;

import java.util.List;

public interface CustomerAppDAO {
	public List<Customer> getAllCustomers();
	public List<Product> getAllProducts();
	public List<Orders> getAllOrders();
	
	public List<Orders> getCustomersAndProducts();
	public boolean updateProductQuantity(int proCode, int newQuantity);
	public void deleteAllOrdersByCustomer(int customerNum, int proCode);
	public Product getMostExpensivePurchasedProduct();
}
