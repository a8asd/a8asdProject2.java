package com.agil8.luber.bdd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerSteps {
	private Map<String, Customer> costomers = new HashMap<>();

	@Given("^(.*) is a phonelessCustomer$")
	public void tony_test_com_is_a_customer(String customerName) {
		costomers.put(customerName, new Customer(customerName));
	}

	@When("^(.*) adds phonenumber (\\d+)$")
	public void tony_adds_phonenumber(String customerName, int arg1) {
		costomers.get(customerName).setPhoneNumber(arg1);
	}

	@Then("^(.*) record is$")
	public void tony_record_is(String customerName, DataTable dataTable) {
	//   dataTable.diff(Arrays.asList(costomers.get(customerName)));
	}
}
