package com.entity;

public class Settings {
	private String username;
	private boolean hazeInfo;
	private boolean fireInfo;
	private boolean maskInfo;
	private boolean bombshelterInfo;
	private boolean viaSms;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isHazeInfo() {
		return hazeInfo;
	}
	public void setHazeInfo(boolean hazeInfo) {
		this.hazeInfo = hazeInfo;
	}
	public boolean isFireInfo() {
		return fireInfo;
	}
	public void setFireInfo(boolean fireInfo) {
		this.fireInfo = fireInfo;
	}
	public boolean isMaskInfo() {
		return maskInfo;
	}
	public void setMaskInfo(boolean maskInfo) {
		this.maskInfo = maskInfo;
	}
	public boolean isBombshelterInfo() {
		return bombshelterInfo;
	}
	public void setBombshelterInfo(boolean bombshelterInfo) {
		this.bombshelterInfo = bombshelterInfo;
	}
	public boolean isViaSms() {
		return viaSms;
	}
	public void setViaSms(boolean viaSms) {
		this.viaSms = viaSms;
	}
}
