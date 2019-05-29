package com.agil8.luber.bdd;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LuberSteps {

	private List<Driver> drivers = new ArrayList<Driver>();

	@Given("^(.*) is a driver$")
	public void ayrton_test_com_is_a_driver(String driverName) {
		drivers.add(new Driver(driverName, true));
	}

	@Given("^(.*) is an unavailable driver$")
	public void david_test_com_is_an_unavailable_driver(String driverName) {
		drivers.add(new Driver(driverName, false));
	}

	@Given("^tony@test\\.com is a customer$")
	public void tony_test_com_is_a_customer() {
	}

	@When("^Tony requests a taxi$")
	public void tony_requests_a_taxi() {
	}

	@Then("^Tony sees these drivers available$")
	public void tony_sees_these_drivers_available(DataTable table) {
		table.diff(drivers);
	}

}
