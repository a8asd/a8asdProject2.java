package com.agil8.luber.bdd;

import static org.junit.Assert.assertTrue;

import java.util.List;

import com.agil8.luber.Driver;
import com.agil8.luber.LuberApp;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LuberSteps {
	LuberApp context = new LuberApp();

	@Given("^(.*) is a driver$")
	public void a_driver(String driverName) {
		Driver driver = new Driver(driverName, true);
		context.addDriver(driver);
	}

	public class DriverData {
		public String name;
		public boolean available;
	}

	@Given("^these drivers$")
	public void these_drivers(List<DriverData> driverTable) {
		for (DriverData driverdata : driverTable) {
			context.addDriver(new Driver(driverdata.name, driverdata.available));
		}
	}

	@When("^(.*) books a ride with (.*)$")
	public void client_books_a_ride_with_driver(String client, String driver) {
		context.addBookingToDriver(client, driver);
	}

	@When("^(.*) books first available driver$")
	public void client_books_first_available_driver(String client) {
		context.bookFirstAvailableDriver(client);
	}

	@Then("^(.*) receives (.*)'s booking$")
	public void driver_receives_the_client_booking(String driver, String client) {
		assertTrue(context.getDriverBookings(driver).contains(client));
	}
}
