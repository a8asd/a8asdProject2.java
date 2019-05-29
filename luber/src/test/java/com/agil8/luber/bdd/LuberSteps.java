package com.agil8.luber.bdd;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LuberSteps {
	@Given("^ayrton@test\\.com is a driver$")
	public void ayrton_test_com_is_a_driver() {
	}

	@Given("^tony@test\\.com is a customer$")
	public void tony_test_com_is_a_customer() {
	}

	@When("^Tony requests a taxi$")
	public void tony_requests_a_taxi() {
	}

	@Then("^Tony sees these drivers available$")
	public void tony_sees_these_drivers_available(DataTable table) {
		
	}
}
