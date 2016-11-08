package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.entity.FireIncident;
import com.entity.HazeInfo;
import com.entity.Incident;

public interface IncidentDao {
	public int createIncident(String reporterName,int reporterPhoneNumber,String typeOfAssistance,String typeOfIncident,String location,String description,String operatorName);
	public void createHazeInfo(int incidentID,int central,int north,int south,int east,int west);
	public void createFireIncident(int incidentID,int numberOfCasualties,int firefightingTime);
	public void closeIncident(int incidentID,String closeRemarks);
	public Incident retrieveSingleIncident(int incidentID);
	public ArrayList<Incident> retrieveIncidents();
	public HazeInfo retrieveLatestHazeInfo();
	public ArrayList<HazeInfo> retrieveHazeInfo();
	public ArrayList<FireIncident> retrieveFireIncidents();
}
