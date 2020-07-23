package com.collabera.jump.CustomerApp;

public class Customer {
	
	private int customerNum;
	private String customerName;
	private String address;
	private String city;
	private String country;
	
	public Customer () {
		
	}

	public Customer(int customerNum, String customerName, String address, String city, String country) {
		super();
		this.customerNum = customerNum;
		this.customerName = customerName;
		this.address = address;
		this.city = city;
		this.country = country;
	}

	public int getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "<tr><td>" + customerNum 
				+ "</td><td>" + customerName 
				+ "</td><td>" + address
				+ "</td><td>" + city 
				+ "</td><td>" + country + "</td></tr>";
	}
	
//	public String toString() {
//		return "Customer Number: " + customerNum 
//				+ ", Customer Name: " + customerName 
//				+ ", Address: " + address
//				+ ", City: " + city 
//				+ ", Country: " + country;
//	}
}
