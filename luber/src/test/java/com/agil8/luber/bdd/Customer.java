package com.agil8.luber.bdd;

public class Customer {

	private String email;
	private String phone;

	Customer(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
}
