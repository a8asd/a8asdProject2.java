package com.agil8.examples.ocp.polymorphic;

import com.agil8.examples.ocp.EmployeeType;

public abstract class Employee {
	protected int salary;

	abstract int getSalary() ;
	abstract double getBonus() ;

	public static Employee create(EmployeeType type) {
		switch (type) {
		case good:
			return new GoodEmployee();
		case bad:
			return new BadEmployee();
		case ugly:
			return new UglyEmployee();
		case indifferent:
			return new IndifferentEmployee();
		default:
			throw new IllegalArgumentException();
		}
	}
}
