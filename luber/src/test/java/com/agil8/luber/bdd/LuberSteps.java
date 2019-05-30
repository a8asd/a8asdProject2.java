package com.agil8.luber.bdd;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LuberSteps {
	private Api api = new Api(new ArrayList<>());

	@Given("^(.*) is a driver$")
	public void ayrton_test_com_is_a_driver(String Driver) {
		api.addDriver(this, Driver, true, 0L, 5L);
	}

	@Given("^dave@test\\.com is an unavailable driver$")
	public void dave_test_com_is_a_unavailable_driver() {
		api.addDriver(this, "dave@test.com", false, 0L, 10L);
	}
	
	
	@Given("^ayrton@test\\.com is a driver at (\\d+),(\\d+)$")
	public void ayrton_test_com_is_a_driver_at(int arg1, int arg2) {
		api.addDriver(this, "ayrton@test.com", true, 0L, 5L);
	}

	@Given("^dave@test\\.com is an unavailable driver at (\\d+),(\\d+)$")
	public void dave_test_com_is_an_unavailable_driver_at(int arg1, int arg2) {
		api.addDriver(this, "dave@test.com", false, 0L, 10L);
	}


	@Given("^tony@test\\.com is a customer$")
	public void tony_test_com_is_a_customer() {
	}

	@When("^Tony requests a taxi$")
	public void tony_requests_a_taxi() {
	}

	@Then("^Tony sees these drivers available$")
	public void tony_sees_these_drivers_available(DataTable table) {
		table.diff(availableDrivers());
		
		
	}

	private List<Driver> availableDrivers() {
		return api.drivers.stream().filter(d -> {
			
			double distance = Math.sqrt(Math.pow(d.getXPosition(), 2) + Math.pow(d.getYPosition(), 2));
			return distance <= 5; 
		}).collect(Collectors.toList());
		
	}
}
