package com.collabera.jump.CustomerApp;

public class Product {

	private int productCode;
	private String productName;
	private int productPrice;
	private int productQuantity;
	
	public Product () {
		
	}
	
	public Product(int productCode, String productName, int productPrice, int productQuantity) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		return "<tr><td>" + productCode 
				+ "</td><td>" + productName 
				+ "</td><td>" + productPrice
				+ "</td><td>" + productQuantity + "</td></tr>";
	}
	
	
}
