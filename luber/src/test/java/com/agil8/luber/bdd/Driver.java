package com.agil8.luber.bdd;

public class Driver {

	private String email;
	private boolean available;
	private Long xPosition;
	private Long yPosition;

	Driver(String email, boolean available, Long xPosition, Long yPosition) {
		this.email = email;
		this.available = available;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	public Long getXPosition()
	{
		return this.xPosition;
	}
	
	public Long getYPosition()
	{
		return this.yPosition;
	}
	
	public void setEmail(String email) {
		this.email = email;
		
	}
	
	public String getEmail() {
		return email;
	}
}
