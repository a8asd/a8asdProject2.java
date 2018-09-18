package com.agil8.examples.ocp.switched;

public class BonusCalculatorWithSwitch {
	public double getBonus(EmployeeWithTypeProperty employee){
		switch(employee.getType()){
			case good:
				return 1000 * .20;
			case bad:
				return 800 * .15;
			case ugly:
				return 200 * 0.01;
			case indifferent:
				return 100 *.0005;
			default:
				throw new IllegalArgumentException();
		}
	}

}
