package com.agil8.examples.bdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// watch out for ambiguous match errors
public class StepMatchersAndCaptureGroups {
	//capture groups with any characters
	@Given("^(.*?) borrows (.*?)$")
	public void user_borrows_book(String user, String Book) {
	}

	//capture group with integer
	@When("^(.*?) is fined (\\d+)$")
	public void user_is_fined_amount(String user,int amount) {
	}

	// non-capturing group
	@Then("^(.*?) (?:borrowed|has borrowed) (.*?)$")
	public void user_has_borrowed_book(String user, String book) {
	}

}
