package com.agil8.examples.bdd;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	@Before
	public void runsBeforeEachScenario() {
	}

	@After
	public void runsAfterEachScenario() {
	}

	@Before("withTag")
	public void runsBeforeEachScenarioWithMatchingTag() {
	}

	@After("withTag")
	public void runsAfterEachScenarioWithMatchingTag() {
	}
}
