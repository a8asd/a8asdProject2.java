package com.agil8.examples.ocp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.agil8.examples.ocp.polymorphic.Employee;
import com.agil8.examples.ocp.polymorphic.PolymorphicSalaryCalculator;
import com.agil8.examples.ocp.switched.EmployeeWithTypeProperty;
import com.agil8.examples.ocp.switched.SalaryCalculatorWithSwitch;

// Replace Conditional with Polymorphism

public class SalaryTest {

	@Test
	public void employeeWithTypeProperty() {
		SalaryCalculatorWithSwitch calculator = new SalaryCalculatorWithSwitch();
		int salary;
		salary = calculator.getSalary(new EmployeeWithTypeProperty(
				EmployeeType.good));
		assertEquals(1000, salary);

		salary = calculator.getSalary(new EmployeeWithTypeProperty(
				EmployeeType.bad));
		assertEquals(800, salary);

		salary = calculator.getSalary(new EmployeeWithTypeProperty(
				EmployeeType.ugly));
		assertEquals(200, salary);
	}

	@Test
	public void polymorphicEmployee() {
		PolymorphicSalaryCalculator calculator = new PolymorphicSalaryCalculator();
		int salary = calculator.getSalary(Employee.create(EmployeeType.good));
		assertEquals(1000, salary);

		salary = calculator.getSalary(Employee.create(EmployeeType.bad));
		assertEquals(800, salary);

		salary = calculator.getSalary(Employee.create(EmployeeType.ugly));
		assertEquals(200, salary);
	}

}
