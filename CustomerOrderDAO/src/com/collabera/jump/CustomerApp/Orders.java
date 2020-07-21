package com.collabera.jump.CustomerApp;

public class Orders {

	private int orderNum;
	private int customerNum;
	private int productCode;
	private int orderPrice;
	private int orderQuantity;
	private Customer customer;
	private Product product;
	
	public Orders () {
		
	}
	
	public Orders(int orderNum, int customerNum, int productCode, int orderPrice, int orderQuantity) {
		super();
		this.orderNum = orderNum;
		this.customerNum = customerNum;
		this.productCode = productCode;
		this.orderPrice = orderPrice;
		this.orderQuantity = orderQuantity;
	}
	
	public Orders(int orderNum, int customerNum, int productCode, int orderPrice, int orderQuantity,
			Customer customer, Product product) {
		super();
		this.orderNum = orderNum;
		this.customerNum = customerNum;
		this.productCode = productCode;
		this.orderPrice = orderPrice;
		this.orderQuantity = orderQuantity;
		this.customer = customer;
		this.product = product;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getCustomerNum() {
		return customerNum;
	}
	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Order Number: " + orderNum 
				+ ", Customer Number: " + customerNum 
				+ ", Product Code: " + productCode
				+ ", Order Price: " + orderPrice 
				+ ", Order Quantity: " + orderQuantity;
	}
	
	
}
