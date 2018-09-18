package com.agil8.examples.ocp.polymorphic;

public class IndifferentEmployee extends Employee {

	@Override
	int getSalary() {
		return 100;
	}

	@Override
	double getBonus() {
		return 0.015;
	}

}
