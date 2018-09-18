package com.agil8.examples.ocp.switched;

import com.agil8.examples.ocp.EmployeeType;

public class EmployeeWithTypeProperty {
	private EmployeeType type;

	public EmployeeWithTypeProperty(EmployeeType type) {
		this.type = type;
	}
	public EmployeeType getType() {
		return type;
	}
}
