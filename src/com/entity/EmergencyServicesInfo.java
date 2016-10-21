package com.entity;

public class EmergencyServicesInfo {
	public static final String FIRE_SERVICE="fire service";
	public static final String AMBULANCE="ambulance";
	public static final String EOD="eod";
	private String name;
	private int contactNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
}
