package com.agil8.examples.ocp.polymorphic;

public class UglyEmployee extends Employee {
	public UglyEmployee() {
		salary = 200;
	}

	@Override
	int getSalary() {
		return salary;
	}

	@Override
	double getBonus() {
		return 0.01 * salary;
	}
}
