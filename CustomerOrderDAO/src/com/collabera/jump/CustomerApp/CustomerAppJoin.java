package com.collabera.jump.CustomerApp;

public class CustomerAppJoin {
	
	private Customer customer;
	private Product product;
	private Orders order;
	
	public CustomerAppJoin () {
		
	}
	
	public CustomerAppJoin(Customer customer, Product product, Orders order) {
		super();
		this.customer = customer;
		this.product = product;
		this.order = order;
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
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}

}
