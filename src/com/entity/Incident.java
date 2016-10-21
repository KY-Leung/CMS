package com.entity;

public class Incident {
	public static final String FIRE_INCIDENT="fire";
	public static final String TRAFFIC_ACCIDENT="traffic_accident";
	public static final String GAS_LEAK_INCIDENT="gas_leak_incident";
	private int incidentID;
	private String reporterName,location,creationTimestamp,description,closureRemarks,closureTimestamp,typeOfAssistance,operatorName,incidentType;
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	boolean isClosed;
	int reporterPhoneNumber;
	public int getIncidentID() {
		return incidentID;
	}
	public void setIncidentID(int incidentID) {
		this.incidentID = incidentID;
	}
	public String getReporterName() {
		return reporterName;
	}
	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCreationTimestamp() {
		return creationTimestamp;
	}
	public void setCreationTimestamp(String creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getClosureRemarks() {
		return closureRemarks;
	}
	public void setClosureRemarks(String closureRemarks) {
		this.closureRemarks = closureRemarks;
	}
	public String getClosureTimestamp() {
		return closureTimestamp;
	}
	public void setClosureTimestamp(String closureTimestamp) {
		this.closureTimestamp = closureTimestamp;
	}
	public String getTypeOfAssistance() {
		return typeOfAssistance;
	}
	public void setTypeOfAssistance(String typeOfAssistance) {
		this.typeOfAssistance = typeOfAssistance;
	}
	public boolean isClosed() {
		return isClosed;
	}
	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
	public int getReporterPhoneNumber() {
		return reporterPhoneNumber;
	}
	public void setReporterPhoneNumber(int reporterPhoneNumber) {
		this.reporterPhoneNumber = reporterPhoneNumber;
	}
	public void setIncidentType(String incidentType){
		this.incidentType=incidentType;
	}
	public String getIncidentType(){
		return incidentType;
	}
}
