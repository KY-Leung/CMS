package com.entity;

public class EmergencyServicesInfo {
	public static final String FIRE_FIGHTING = "fire fighting";
	public static final String AMBULANCE="emergency ambulance";
	public static final String RESCUE_AND_EVACUATION = "rescue and evacuation"; 
	public static final String GAS_LEAK_CONTROL = "gas leak control"; 
	public static final String[] services = new String[] {AMBULANCE, RESCUE_AND_EVACUATION, FIRE_FIGHTING, GAS_LEAK_CONTROL}; 
	
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
