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


public class IncidentManager{
	public int createIncident(String reporterName,int reporterPhoneNumber,String typeOfAssistance,String typeOfIncident,String location,String description,String operatorName){
		IncidentDao dao=DaoFactory.getIncidentDao();
		return dao.createIncident(reporterName, reporterPhoneNumber, typeOfAssistance, typeOfIncident, location, description, operatorName);
		
	}
	public void createHazeInfo(int incidentID,int central,int north,int south,int east,int west){
		IncidentDao dao=DaoFactory.getIncidentDao();
		dao.createHazeInfo(incidentID, central, north, south, east, west);
	}
	
	public void createFireIncident(int incidentID,int numberOfCasualties,int firefightingTime){
		IncidentDao dao=DaoFactory.getIncidentDao();
		dao.createFireIncident(incidentID, numberOfCasualties, firefightingTime);
	}
	public void closeIncident(int incidentID,String closeRemarks){
		IncidentDao dao=DaoFactory.getIncidentDao();
		dao.closeIncident(incidentID, closeRemarks);
	}
	public Incident retrieveSingleIncident(int incidentID){
		IncidentDao dao=DaoFactory.getIncidentDao();
		return dao.retrieveSingleIncident(incidentID);
	}
	public ArrayList<Incident> retrieveIncidents(){
		IncidentDao dao=DaoFactory.getIncidentDao();
		return dao.retrieveIncidents();
	}
	public HazeInfo retrieveLatestHazeInfo(){
		IncidentDao dao=DaoFactory.getIncidentDao();
		return dao.retrieveLatestHazeInfo();
	}
	public ArrayList<HazeInfo> retrieveHazeInfo(){
		IncidentDao dao=DaoFactory.getIncidentDao();
		return dao.retrieveHazeInfo();
	}
	public ArrayList<FireIncident> retrieveFireIncidents(){
		IncidentDao dao=DaoFactory.getIncidentDao();
		return dao.retrieveFireIncidents();
	}
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
