package com.agil8.luber.bdd;

import java.util.ArrayList;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LuberSteps {

	private List<Driver> drivers = new ArrayList<Driver>();
	private List<Driver> closedrivers = new ArrayList<Driver>();
	//private List<Customer> customers = new ArrayList<Customer>();
	private int x1;
	private int y1;
	private int x2 =0;
	private int y2 =0;
	// private double distance;
	private int max = 5;
	private Object customerName;
	private double latitude;
	private double longtiude;

	@Given("^(.*) is a driver at (\\d+), (\\d+)$")
	public void ayrton_test_com_is_a_driver(String driverName, int x1, int y1) {
		drivers.add(new Driver(driverName, true, x1, y1));
	}

	@Given("^(.*) is an unavailable driver at (\\d+), (\\d+)$")
	public void david_test_com_is_an_unavailable_driver(String driverName, int x, int y) {
		drivers.add(new Driver(driverName, false, x, y));
	}

	@Given("^tony@test\\.com is a customer at (\\d+), (\\d+)$")
	public void tony_test_com_is_a_customer(int x2, int y2) {
		//customers.add(new Customer(customerName, latitude, longtiude ));
	}

	@When("^Tony requests a taxi$")
	public void tony_requests_a_taxi() {
		for (int i = 0; i < drivers.size(); i++) {
			if (drivers.get(i).distance(x1, y1) < max) {
				closedrivers.add(drivers.get(i));
			}
		}
	}

	@Then("^Tony sees these drivers available$")
	public void tony_sees_these_drivers_available(DataTable table) {
		table.diff(closedrivers);
	}

}
