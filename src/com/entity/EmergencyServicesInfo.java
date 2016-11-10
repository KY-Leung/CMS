package com.entity;

// TODO: Auto-generated Javadoc
/**
 * The Class EmergencyServicesInfo.
 */
public class EmergencyServicesInfo {
	
	/** The Constant FIRE_FIGHTING. */
	public static final String FIRE_FIGHTING = "fire fighting";
	
	/** The Constant AMBULANCE. */
	public static final String AMBULANCE="emergency ambulance";
	
	/** The Constant RESCUE_AND_EVACUATION. */
	public static final String RESCUE_AND_EVACUATION = "rescue and evacuation"; 
	
	/** The Constant GAS_LEAK_CONTROL. */
	public static final String GAS_LEAK_CONTROL = "gas leak control"; 
	
	/** The Constant services. */
	public static final String[] services = new String[] {AMBULANCE, RESCUE_AND_EVACUATION, FIRE_FIGHTING, GAS_LEAK_CONTROL}; 
	
	/** The Constant EOD. */
	public static final String EOD="eod";
	
	/** The name. */
	private String name;
	
	/** The contact number. */
	private int contactNumber;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the contact number.
	 *
	 * @return the contact number
	 */
	public int getContactNumber() {
		return contactNumber;
	}
	
	/**
	 * Sets the contact number.
	 *
	 * @param contactNumber the new contact number
	 */
	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}
}
