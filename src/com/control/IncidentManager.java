package com.control;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dao.DaoFactory;
import com.dao.DbController;
import com.dao.DbFactory;
import com.dao.IncidentDao;
import com.entity.EmergencyServicesInfo;
import com.entity.FireIncident;
import com.entity.HazeInfo;
import com.entity.Incident;


// TODO: Auto-generated Javadoc
/**
 * The Class IncidentManager.
 */
public class IncidentManager{
	
	/**
	 * Creates a new incident.
	 *
	 * @param reporterName the reporter name
	 * @param reporterPhoneNumber the reporter phone number
	 * @param typeOfAssistance the type of assistance
	 * @param typeOfIncident the type of incident
	 * @param location the location
	 * @param description the description
	 * @param operatorName the operator name
	 * @return the incidentId of the incident that was created
	 */
	public int createIncident(String reporterName,int reporterPhoneNumber,String typeOfAssistance,String typeOfIncident,String location,String description,String operatorName){
		IncidentDao dao=DaoFactory.getIncidentDao();
		return dao.createIncident(reporterName, reporterPhoneNumber, typeOfAssistance, typeOfIncident, location, description, operatorName);
		
	}
	
	/**
	 * Creates a new haze info.
	 *
	 * @param incidentID the incident ID
	 * @param central the central
	 * @param north the north
	 * @param south the south
	 * @param east the east
	 * @param west the west
	 */
	public void createHazeInfo(int incidentID,int central,int north,int south,int east,int west){
		IncidentDao dao=DaoFactory.getIncidentDao();
		dao.createHazeInfo(incidentID, central, north, south, east, west);
	}
	
	/**
	 * Creates a new fire incident.
	 *
	 * @param incidentID the incident ID
	 * @param numberOfCasualties the number of casualties
	 * @param firefightingTime the firefighting time
	 */
	public void createFireIncident(int incidentID,int numberOfCasualties,int firefightingTime){
		IncidentDao dao=DaoFactory.getIncidentDao();
		dao.createFireIncident(incidentID, numberOfCasualties, firefightingTime);
	}
	
	/**
	 * Close existing incident.
	 *
	 * @param incidentID the incident ID of incident to close
	 * @param closeRemarks closing remarks
	 */
	public void closeIncident(int incidentID,String closeRemarks){
		IncidentDao dao=DaoFactory.getIncidentDao();
		dao.closeIncident(incidentID, closeRemarks);
	}
	
	/**
	 * Retrieve single incident.
	 *
	 * @param incidentID the incident ID
	 * @return the incident object
	 */
	public Incident retrieveSingleIncident(int incidentID){
		IncidentDao dao=DaoFactory.getIncidentDao();
		return dao.retrieveSingleIncident(incidentID);
	}
	
	/**
	 * Retrieve incidents.
	 *
	 * @return the array list of Incident
	 */
	public ArrayList<Incident> retrieveIncidents(){
		IncidentDao dao=DaoFactory.getIncidentDao();
		return dao.retrieveIncidents();
	}
	
	/**
	 * Retrieve latest haze info.
	 *
	 * @return the HazeInfo object
	 */
	public HazeInfo retrieveLatestHazeInfo(){
		IncidentDao dao=DaoFactory.getIncidentDao();
		return dao.retrieveLatestHazeInfo();
	}
	
	/**
	 * Retrieve haze info.
	 *
	 * @return the array list of HazeInfo
	 */
	public ArrayList<HazeInfo> retrieveHazeInfo(){
		IncidentDao dao=DaoFactory.getIncidentDao();
		return dao.retrieveHazeInfo();
	}
	
	/**
	 * Retrieve fire incidents.
	 *
	 * @return the array list of FireIncident 
	 */
	public ArrayList<FireIncident> retrieveFireIncidents(){
		IncidentDao dao=DaoFactory.getIncidentDao();
		return dao.retrieveFireIncidents();
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String [] args){
		IncidentManager im=new IncidentManager();
		System.out.println(im.retrieveSingleIncident(10).getIncidentType());
		//int key=im.createIncident("rname 10", 12345, EmergencyServicesInfo.FIRE_SERVICE, Incident.FIRE_INCIDENT, "730600", "desc", "operator 4");
		//im.createHazeInfo(key, 100, 202, 60, 70, 80);
		//im.createFireIncident(key, 5, 4);
	}
//	public void updateLocation(int incidentID,String location){
//		DbController db=new DbController();
//		String query="insert into publicuser values(";
//		db.executeQuery(query);
//		db.close();
//	}
//	
//	public void updateDescription(int incidentID,String description){
//		DbController db=new DbController();
//		String query="insert into publicuser values(";
//		db.executeQuery(query);
//		db.close();
//	}
	

	
}
