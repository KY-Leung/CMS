package com.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class HazeInfo extends Incident{
	private int centralPsi,northPsi,southPsi,eastPsi,westPsi;
	public int getCentralPsi() {
		return centralPsi;
	}
	public void setCentralPsi(int centralPsi) {
		this.centralPsi = centralPsi;
	}
	public int getNorthPsi() {
		return northPsi;
	}
	public void setNorthPsi(int northPsi) {
		this.northPsi = northPsi;
	}
	public int getSouthPsi() {
		return southPsi;
	}
	public void setSouthPsi(int southPsi) {
		this.southPsi = southPsi;
	}
	public int getEastPsi() {
		return eastPsi;
	}
	public void setEastPsi(int eastPsi) {
		this.eastPsi = eastPsi;
	}
	public int getWestPsi() {
		return westPsi;
	}
	public void setWestPsi(int westPsi) {
		this.westPsi = westPsi;
	}
}
