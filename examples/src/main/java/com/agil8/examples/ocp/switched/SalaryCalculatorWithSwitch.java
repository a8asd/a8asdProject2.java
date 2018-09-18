package com.agil8.examples.ocp.switched;

public class SalaryCalculatorWithSwitch {
	public int getSalary(EmployeeWithTypeProperty employee){
		switch(employee.getType()){
			case good:
				return 1000;
			case bad:
				return 800;
			case ugly:
				return 200;
			case indifferent:
				return 100;
			default:
				throw new IllegalArgumentException();
		}
	}
}
