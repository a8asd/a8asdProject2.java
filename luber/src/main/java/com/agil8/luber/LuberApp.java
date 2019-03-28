package com.agil8.luber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LuberApp {
	private Map<String,Driver> drivers = new HashMap<>();

	public void addDriver(Driver driver) {
		drivers.put(driver.getName(), driver);
	}

	public void addBookingToDriver(String client, String driver) {
		drivers.get(driver).addBooking(client);
	}

	public List<String> getDriverBookings(String driver) {
		return drivers.get(driver).getBookings();
	}

	public void bookFirstAvailableDriver(String client) {
		for(Driver driver:drivers.values()) {
			if(driver.isAvailable()) {
				addBookingToDriver(client,driver.getName());
				return;
			}
		}
	}
}
