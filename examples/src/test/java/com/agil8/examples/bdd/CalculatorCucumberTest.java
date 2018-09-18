package com.agil8.examples.bdd;
 
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	plugin = {"pretty", "html:target/cucumber"}
)

public class CalculatorCucumberTest {}
