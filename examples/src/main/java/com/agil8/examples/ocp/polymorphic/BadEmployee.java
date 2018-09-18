package com.agil8.examples.ocp.polymorphic;

public class BadEmployee extends Employee {
	public BadEmployee() {
		salary = 800;
	}

	@Override
	int getSalary() {
		return salary;
	}

	@Override
	double getBonus() {
		return salary * 0.15;
	}

}
