package com.agil8.luber;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	private List<String> bookings = new ArrayList<>();
	private String name;
	private boolean available;

	public Driver(String name, boolean available) {
		this.name = name;
		this.setAvailable(available);
	}

	public List<String> getBookings() {
		return bookings ;
	}

	public void addBooking(String string) {
		bookings.add(string);
	}

	public String getName() {
		return name;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}
