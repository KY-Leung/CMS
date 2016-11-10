package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.entity.FireIncident;
import com.entity.HazeInfo;
import com.entity.Incident;

// TODO: Auto-generated Javadoc
/**
 * The Interface IncidentDao.
 */
public interface IncidentDao {
	
	/**
	 * Creates the incident.
	 *
	 * @param reporterName the reporter name
	 * @param reporterPhoneNumber the reporter phone number
	 * @param typeOfAssistance the type of assistance
	 * @param typeOfIncident the type of incident
	 * @param location the location
	 * @param description the description
	 * @param operatorName the operator name
	 * @return the int
	 */
	public int createIncident(String reporterName,int reporterPhoneNumber,String typeOfAssistance,String typeOfIncident,String location,String description,String operatorName);
	
	/**
	 * Creates the haze info.
	 *
	 * @param incidentID the incident ID
	 * @param central the central
	 * @param north the north
	 * @param south the south
	 * @param east the east
	 * @param west the west
	 */
	public void createHazeInfo(int incidentID,int central,int north,int south,int east,int west);
	
	/**
	 * Creates the fire incident.
	 *
	 * @param incidentID the incident ID
	 * @param numberOfCasualties the number of casualties
	 * @param firefightingTime the firefighting time
	 */
	public void createFireIncident(int incidentID,int numberOfCasualties,int firefightingTime);
	
	/**
	 * Close incident.
	 *
	 * @param incidentID the incident ID
	 * @param closeRemarks the close remarks
	 */
	public void closeIncident(int incidentID,String closeRemarks);
	
	/**
	 * Retrieve single incident.
	 *
	 * @param incidentID the incident ID
	 * @return the incident
	 */
	public Incident retrieveSingleIncident(int incidentID);
	
	/**
	 * Retrieve incidents.
	 *
	 * @return the array list
	 */
	public ArrayList<Incident> retrieveIncidents();
	
	/**
	 * Retrieve latest haze info.
	 *
	 * @return the haze info
	 */
	public HazeInfo retrieveLatestHazeInfo();
	
	/**
	 * Retrieve haze info.
	 *
	 * @return the array list
	 */
	public ArrayList<HazeInfo> retrieveHazeInfo();
	
	/**
	 * Retrieve fire incidents.
	 *
	 * @return the array list
	 */
	public ArrayList<FireIncident> retrieveFireIncidents();
}
