package com.collabera.jump.CustomerApp;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		
		// Initialize objects used in menu
		Scanner scan = new Scanner(System.in);
		String input = "";
		CustomerAppDAO cuAppDAO = new CustomerAppDAOClass();
		int updateProCode = 0;
		int newQuantity = 0;
		int deleteCustomerName = 0;
		int deleteProCode = 0;
		Product mostExpenPro = new Product();
		
		System.out.println("Welcome to the CustomerApp!");
		
		while (true) {
			System.out.println("Please enter a number to perform an operation: ");
			System.out.println("1: View Customers and Products they have ordered");
			System.out.println("2: Update a Product Quantity");
			System.out.println("3: Delete Orders of Product by Customer");
			System.out.println("4: Most expensive Product purchased by a Customer");
			System.out.println("5: View All Customers");
			System.out.println("6: View All Products");
			System.out.println("7: View All Orders");
			System.out.println("0: Exit Menu");
			
			input = scan.next().trim();
			
			switch (input) {
			case "1": // Show all Customers and their pruchased Products
				for (Orders or : cuAppDAO.getCustomersAndProducts()) {
					System.out.println(or.getCustomer().getCustomerName() + " purchased " + or.getProduct().getProductName());
				}
				System.out.println("-------------------------");
				break;
			case "2": // Update Product quantity based on user input
				System.out.println("Please enter the Product Code you would like to update: ");
				updateProCode = scan.nextInt();
				System.out.println("Please enter the new quantity of product " + updateProCode + ":");
				newQuantity = scan.nextInt();
				if (cuAppDAO.updateProductQuantity(updateProCode, newQuantity)) {
					System.out.println("Product " + updateProCode + " was updated to have Quantity " + newQuantity);
				}
				System.out.println("-------------------------");
				break;
			case "3": // Delete all orders made by Customer of particular Product
				System.out.println("Please enter the Customer Number you would like to delete orders from:");
				deleteCustomerName = scan.nextInt();
				System.out.println("Please enter the Product Code you would like deleted from the orders:");
				deleteProCode = scan.nextInt();
				cuAppDAO.deleteAllOrdersByCustomer(deleteCustomerName, deleteProCode);
				System.out.println("-------------------------");
				break;
			case "4": // Display the most expensive product that has been purchased
				mostExpenPro = cuAppDAO.getMostExpensivePurchasedProduct();
				System.out.println("The most expensive purchased product is " + mostExpenPro.getProductName() + " at $" + mostExpenPro.getProductPrice());
				System.out.println("-------------------------");
				break;
			case "5": // Display all Customers
				for (Customer cu : cuAppDAO.getAllCustomers()) {
					System.out.println(cu);
				}
				System.out.println("-------------------------");
				break;
			case "6": // Display all Products
				for (Product pr : cuAppDAO.getAllProducts()) {
					System.out.println(pr);
				}
				System.out.println("-------------------------");
				break;
			case "7": // Display all Orders
				for (Orders or : cuAppDAO.getAllOrders()) {
					System.out.println(or);
				}
				System.out.println("-------------------------");
				break;
			case "0": // Exit menu
				System.out.println("Exiting menu...");
				scan.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input, please enter a valid input");
				System.out.println("-------------------------");
				break;
			}
		}
	}
}