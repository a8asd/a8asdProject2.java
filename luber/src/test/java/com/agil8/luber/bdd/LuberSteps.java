package com.agil8.luber.bdd;

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
	public void someone_is_a_driver(String driver) {
		api.addDriver(this, driver, true, 0L, 5L);
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
	
	@When("^(.*) changes his email address to (.*)$")
	public void ayrton_test_com_changes_his_email_address_to_ayrton_hotmail_com(String email, String newEmail) {
		api.drivers.get(0).setEmail(newEmail);
	}
	
	@Then("^(.*) sees these drivers available$")
	public void sees_these_drivers_available(String who,DataTable table) {
		table.diff(availableDrivers());	
	}

	private List<Driver> availableDrivers() {
		return api.drivers.stream().filter(d -> {
			
			double distance = Math.sqrt(Math.pow(d.getXPosition(), 2) + Math.pow(d.getYPosition(), 2));
			return distance <= 5; 
		}).collect(Collectors.toList());
		
	}
}
