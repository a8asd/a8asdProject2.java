package com.agil8.refactoring.z;

public class Employment {
	private Person regulator;
	private Address employerAddress;
	public Person getRegulator() {
		return regulator;
	}
	public Address getEmployerAddress() {
		return employerAddress;
	}
	public void setEmployerAddress(Address employerAddress) {
		this.employerAddress = employerAddress;
	}

}
