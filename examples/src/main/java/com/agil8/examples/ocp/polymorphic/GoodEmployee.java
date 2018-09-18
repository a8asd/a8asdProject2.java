package com.agil8.examples.ocp.polymorphic;

public class GoodEmployee extends Employee {
	public GoodEmployee() {
		salary = 1000;
	}

	@Override
	int getSalary() {
		return 1000;
	}

	@Override
	double getBonus() {
		return salary * 0.2;
	}
}
