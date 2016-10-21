package com.entity;

public class FireIncident extends Incident{
	private int numberOfCasualties;
	private int firefightingTime;

	public int getNumberOfCasualties() {
		return numberOfCasualties;
	}
	public void setNumberOfCasualties(int numberOfCasualties) {
		this.numberOfCasualties = numberOfCasualties;
	}
	public int getFirefightingTime() {
		return firefightingTime;
	}
	public void setFirefightingTime(int firefightingTime) {
		this.firefightingTime = firefightingTime;
	}
}
