package com.entity;

// TODO: Auto-generated Javadoc
/**
 * The Class Incident.
 */
public class Incident {
	
	/** The Constant FIRE_INCIDENT. */
	public static final String FIRE_INCIDENT="fire";
	
	/** The Constant TRAFFIC_ACCIDENT. */
	public static final String TRAFFIC_ACCIDENT="traffic_accident";
	
	/** The Constant GAS_LEAK_INCIDENT. */
	public static final String GAS_LEAK_INCIDENT="gas_leak_incident";
	
	/** The Constant HAZE_INFO. */
	public static final String HAZE_INFO="haze_info";
	
	/** The Constant NOT_APPLICABLE. */
	public static final String NOT_APPLICABLE="na";
	
	/** The incident ID. */
	private int incidentID;
	
	/** The incident type. */
	private String reporterName,location,creationTimestamp,description,closureRemarks,closureTimestamp,typeOfAssistance,operatorName,incidentType;
	
	/** The is closed. */
	private boolean isClosed;
	
	/** The reporter phone number. */
	private int reporterPhoneNumber;
	
	/**
	 * Gets the operator name.
	 *
	 * @return the operator name
	 */
	public String getOperatorName() {
		return operatorName;
	}
	
	/**
	 * Sets the operator name.
	 *
	 * @param operatorName the new operator name
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	/**
	 * Gets the incident ID.
	 *
	 * @return the incident ID
	 */
	public int getIncidentID() {
		return incidentID;
	}
	
	/**
	 * Sets the incident ID.
	 *
	 * @param incidentID the new incident ID
	 */
	public void setIncidentID(int incidentID) {
		this.incidentID = incidentID;
	}
	
	/**
	 * Gets the reporter name.
	 *
	 * @return the reporter name
	 */
	public String getReporterName() {
		return reporterName;
	}
	
	/**
	 * Sets the reporter name.
	 *
	 * @param reporterName the new reporter name
	 */
	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}
	
	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Sets the location.
	 *
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * Gets the creation timestamp.
	 *
	 * @return the creation timestamp
	 */
	public String getCreationTimestamp() {
		return creationTimestamp;
	}
	
	/**
	 * Sets the creation timestamp.
	 *
	 * @param creationTimestamp the new creation timestamp
	 */
	public void setCreationTimestamp(String creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Gets the closure remarks.
	 *
	 * @return the closure remarks
	 */
	public String getClosureRemarks() {
		return closureRemarks;
	}
	
	/**
	 * Sets the closure remarks.
	 *
	 * @param closureRemarks the new closure remarks
	 */
	public void setClosureRemarks(String closureRemarks) {
		this.closureRemarks = closureRemarks;
	}
	
	/**
	 * Gets the closure timestamp.
	 *
	 * @return the closure timestamp
	 */
	public String getClosureTimestamp() {
		return closureTimestamp;
	}
	
	/**
	 * Sets the closure timestamp.
	 *
	 * @param closureTimestamp the new closure timestamp
	 */
	public void setClosureTimestamp(String closureTimestamp) {
		this.closureTimestamp = closureTimestamp;
	}
	
	/**
	 * Gets the type of assistance.
	 *
	 * @return the type of assistance
	 */
	public String getTypeOfAssistance() {
		return typeOfAssistance;
	}
	
	/**
	 * Sets the type of assistance.
	 *
	 * @param typeOfAssistance the new type of assistance
	 */
	public void setTypeOfAssistance(String typeOfAssistance) {
		this.typeOfAssistance = typeOfAssistance;
	}
	
	/**
	 * Checks if is closed.
	 *
	 * @return true, if is closed
	 */
	public boolean isClosed() {
		return isClosed;
	}
	
	/**
	 * Sets the closed.
	 *
	 * @param isClosed the new closed
	 */
	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
	
	/**
	 * Gets the reporter phone number.
	 *
	 * @return the reporter phone number
	 */
	public int getReporterPhoneNumber() {
		return reporterPhoneNumber;
	}
	
	/**
	 * Sets the reporter phone number.
	 *
	 * @param reporterPhoneNumber the new reporter phone number
	 */
	public void setReporterPhoneNumber(int reporterPhoneNumber) {
		this.reporterPhoneNumber = reporterPhoneNumber;
	}
	
	/**
	 * Sets the incident type.
	 *
	 * @param incidentType the new incident type
	 */
	public void setIncidentType(String incidentType){
		this.incidentType=incidentType;
	}
	
	/**
	 * Gets the incident type.
	 *
	 * @return the incident type
	 */
	public String getIncidentType(){
		return incidentType;
	}
}
