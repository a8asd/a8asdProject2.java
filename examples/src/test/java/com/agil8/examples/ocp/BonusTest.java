package com.agil8.examples.ocp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.agil8.examples.ocp.polymorphic.Employee;
import com.agil8.examples.ocp.polymorphic.PolymorphicBonusCalculator;
import com.agil8.examples.ocp.switched.BonusCalculatorWithSwitch;
import com.agil8.examples.ocp.switched.EmployeeWithTypeProperty;

//Replace Conditional with Polymorphism

public class BonusTest {

	@Test
	public void employeeWithTypePropertyBonus() {
		BonusCalculatorWithSwitch calculator = new BonusCalculatorWithSwitch();
		double salary;
		salary = calculator.getBonus(new EmployeeWithTypeProperty(
				EmployeeType.good));
		assertEquals(200, salary, 2);

		salary = calculator.getBonus(new EmployeeWithTypeProperty(
				EmployeeType.bad));
		assertEquals(120, salary, 2);

		salary = calculator.getBonus(new EmployeeWithTypeProperty(
				EmployeeType.ugly));
		assertEquals(2, salary, 2);
	}

	@Test
	public void polymorphicEmployeeBonus() {
		PolymorphicBonusCalculator calculator = new PolymorphicBonusCalculator();
		double bonus = calculator.getBonus(Employee.create(EmployeeType.good));
		assertEquals(200, bonus, 2);

		bonus = calculator.getBonus(Employee.create(EmployeeType.bad));
		assertEquals(120, bonus, 2);

		bonus = calculator.getBonus(Employee.create(EmployeeType.ugly));
		assertEquals(2, bonus, 2);
	}

}
