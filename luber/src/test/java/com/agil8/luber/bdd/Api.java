package com.agil8.luber.bdd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Api {
	public List<Driver> drivers;
	private Map<String, Customer> customers = new HashMap<>();

	public Api(List<Driver> drivers) {
		this.drivers = drivers;
	}

	void addDriver(LuberSteps luberSteps, String Drivername, boolean available, long xPosition, long yPosition) {
		Driver e = new Driver(Drivername , available, xPosition, yPosition);
		drivers.add(e);
	}

	public void addCustomer(String customerName) {
		customers.put(customerName, new Customer(customerName));
	}

	public void addPhoneNumber(String customerName, String phone) {
		customers.get(customerName).setPhoneNumber(phone);
	}

	public Customer getCustomerByName(String customerName) {
		return customers.get(customerName);
	}
}