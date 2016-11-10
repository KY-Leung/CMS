package com.entity;

import java.sql.Date;
import java.sql.Timestamp;

// TODO: Auto-generated Javadoc
/**
 * The Class HazeInfo.
 */
public class HazeInfo extends Incident{
	
	/** The west psi. */
	private int centralPsi,northPsi,southPsi,eastPsi,westPsi;
	
	/**
	 * Gets the central psi.
	 *
	 * @return the central psi
	 */
	public int getCentralPsi() {
		return centralPsi;
	}
	
	/**
	 * Sets the central psi.
	 *
	 * @param centralPsi the new central psi
	 */
	public void setCentralPsi(int centralPsi) {
		this.centralPsi = centralPsi;
	}
	
	/**
	 * Gets the north psi.
	 *
	 * @return the north psi
	 */
	public int getNorthPsi() {
		return northPsi;
	}
	
	/**
	 * Sets the north psi.
	 *
	 * @param northPsi the new north psi
	 */
	public void setNorthPsi(int northPsi) {
		this.northPsi = northPsi;
	}
	
	/**
	 * Gets the south psi.
	 *
	 * @return the south psi
	 */
	public int getSouthPsi() {
		return southPsi;
	}
	
	/**
	 * Sets the south psi.
	 *
	 * @param southPsi the new south psi
	 */
	public void setSouthPsi(int southPsi) {
		this.southPsi = southPsi;
	}
	
	/**
	 * Gets the east psi.
	 *
	 * @return the east psi
	 */
	public int getEastPsi() {
		return eastPsi;
	}
	
	/**
	 * Sets the east psi.
	 *
	 * @param eastPsi the new east psi
	 */
	public void setEastPsi(int eastPsi) {
		this.eastPsi = eastPsi;
	}
	
	/**
	 * Gets the west psi.
	 *
	 * @return the west psi
	 */
	public int getWestPsi() {
		return westPsi;
	}
	
	/**
	 * Sets the west psi.
	 *
	 * @param westPsi the new west psi
	 */
	public void setWestPsi(int westPsi) {
		this.westPsi = westPsi;
	}
}
