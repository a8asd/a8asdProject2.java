package com.agil8.luber.bdd;

public class Driver {

	private String email;
	private boolean availible;
	private int y;
	private int x;
	private double distance;
	

	Driver(String email, boolean availible, int x, int y) {
		this.email = email;
		this.availible = availible;
		this.x = x;
		this.y = y;
	}

	public double distance(int x2, int y2) {
		int h = x-x2;
		int v = y-y2;
		
		distance = Math.pow(h, 2) + Math.pow(v, 2);
		distance = Math.sqrt(distance);
		
		return distance;
		
	}
	
	public boolean getAvailible() {
		return availible;
	}
	
	public String getName() {
		return email;
	}

}