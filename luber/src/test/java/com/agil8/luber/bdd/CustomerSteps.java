package com.agil8.luber.bdd;

import java.util.Arrays;
import java.util.Collections;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerSteps {
	private Api api = new Api(Collections.emptyList());

	@Given("^(.*) is a phonelessCustomer$")
	public void tony_test_com_is_a_customer(String customerName) {
		api.addCustomer(customerName);
	}

	@When("^(.*) adds phonenumber (\\d+)$")
	public void tony_adds_phonenumber(String customerName, String phone) {
		api.addPhoneNumber(customerName, phone);
	}

	@Then("^(.*) record is$")
	public void tony_record_is(String customerName, DataTable dataTable) {
	   dataTable.diff(Arrays.asList(api.getCustomerByName(customerName)));
	}
}
