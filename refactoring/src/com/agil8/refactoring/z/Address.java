package com.agil8.refactoring.z;

public class Address {
	private Country country;
	private Status status;
	private Type type;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country value) {
		country = value;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status value) {
		status = value;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type value) {
		type = value;
	}
}