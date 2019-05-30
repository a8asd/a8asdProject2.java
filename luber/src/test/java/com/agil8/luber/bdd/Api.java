package com.agil8.luber.bdd;

import java.util.List;

public class Api {
	public List<Driver> drivers;
	
	public Api(List<Driver> drivers) {
		this.drivers = drivers;
	}

	void addDriver(LuberSteps luberSteps, String Drivername, boolean available, long xPosition, long yPosition) {
		Driver e = new Driver(Drivername , available, xPosition, yPosition);
		drivers.add(e);
	}
	

	
}