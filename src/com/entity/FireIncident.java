package com.entity;

// TODO: Auto-generated Javadoc
/**
 * The Class FireIncident.
 */
public class FireIncident extends Incident{
	
	/** The number of casualties. */
	private int numberOfCasualties;
	
	/** The firefighting time. */
	private int firefightingTime;

	/**
	 * Gets the number of casualties.
	 *
	 * @return the number of casualties
	 */
	public int getNumberOfCasualties() {
		return numberOfCasualties;
	}
	
	/**
	 * Sets the number of casualties.
	 *
	 * @param numberOfCasualties the new number of casualties
	 */
	public void setNumberOfCasualties(int numberOfCasualties) {
		this.numberOfCasualties = numberOfCasualties;
	}
	
	/**
	 * Gets the firefighting time.
	 *
	 * @return the firefighting time
	 */
	public int getFirefightingTime() {
		return firefightingTime;
	}
	
	/**
	 * Sets the firefighting time.
	 *
	 * @param firefightingTime the new firefighting time
	 */
	public void setFirefightingTime(int firefightingTime) {
		this.firefightingTime = firefightingTime;
	}
}
