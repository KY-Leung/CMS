package com.control;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entity.EmergencyServicesInfo;
import com.entity.FireIncident;
import com.entity.HazeInfo;
import com.entity.Incident;


public class IncidentManager {
//	public static void main(String[] args) {
//		IncidentManager i = new IncidentManager(); 
//		ArrayList<Incident> incidents = i.retrieveIncidents();
//    	System.out.println("Number of incidents = " + incidents.size());
//	}
	
	public int createIncident(String reporterName,int reporterPhoneNumber,String typeOfAssistance,String typeOfIncident,String location,String description,String operatorName){
		int incidentID=1;
		DbController db=new DbController();
		String query="insert into incident values(null,'"+reporterName+"',"+reporterPhoneNumber+",'"+typeOfIncident+"','"+location+"','"+typeOfAssistance+"','"+description+"',null,null,null,null,'"+operatorName+"')";
		System.out.println(query);
		db.updateSql(query);
		query="select last_insert_id() as last";
		try{
			ResultSet rs=db.executeSql(query);
			if(rs.next()){
				incidentID=rs.getInt("last");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		db.close();
		return incidentID;
	}
	public void createHazeInfo(int incidentID,int central,int north,int south,int east,int west){
		DbController db=new DbController();
		String query="insert into hazeinfo values("+incidentID+","+central+","+north+","+south+","+east+","+west+")";
		System.out.println(query);
		db.updateSql(query);
		db.close();
	}
	
	public void createFireIncident(int incidentID,int numberOfCasualties,int firefightingTime){
		DbController db=new DbController();
		String query="insert into fireincident values("+incidentID+","+numberOfCasualties+","+firefightingTime+")";
		db.updateSql(query);
		db.close();
	}
	public void closeIncident(int incidentID,String closeRemarks){
		DbController db=new DbController();
		String query="update incident set isClosed="+true+",closureTimestamp=CURRENT_TIMESTAMP,closureRemarks='"+closeRemarks+"' where incidentID="+incidentID;
		db.updateSql(query);
		db.close();
		
	}
	public ArrayList<Incident> retrieveIncidents(){
		ArrayList<Incident> list=new ArrayList<Incident>();
		Incident incident=null;
		DbController db=new DbController();
		String query="select * from incident";
		try{
			ResultSet rs=db.executeSql(query);
			while(rs.next()){
				incident=new Incident();
				incident.setIncidentID(rs.getInt("incidentID"));
				incident.setReporterName(rs.getString("reporterName"));
				incident.setReporterPhoneNumber(rs.getInt("reporterPhoneNumber"));
				incident.setLocation(rs.getString("location"));
				incident.setTypeOfAssistance(rs.getString("typeOfAssistance"));
				incident.setDescription(rs.getString("description"));
				incident.setCreationTimestamp(rs.getString("creationTimestamp"));
				incident.setClosureRemarks(rs.getString("closureRemarks"));
				incident.setClosed(rs.getBoolean("isClosed"));
				incident.setClosureTimestamp(rs.getString("closureTimestamp"));
				incident.setOperatorName(rs.getString("operatorUsername"));
				incident.setIncidentType(rs.getString("typeOfIncident"));
				list.add(incident);
			}
		}catch(Exception e){
			
		}
		return list;
	}
	public HazeInfo retrieveLatestHazeInfo(){
		HazeInfo hi=new HazeInfo();
		DbController db=new DbController();
		String query="select * from hazeinfo inner join incident on hazeinfo.incidentID=incident.incidentID order by incidentID DESC LIMIT 1";
		try{
			ResultSet rs=db.executeSql(query);
			if(rs.next()){
				hi.setIncidentID(rs.getInt("incidentID"));
				hi.setReporterName(rs.getString("reporterName"));
				hi.setReporterPhoneNumber(rs.getInt("reporterPhoneNumber"));
				hi.setLocation(rs.getString("location"));
				hi.setTypeOfAssistance(rs.getString("typeOfAssistance"));
				hi.setDescription(rs.getString("description"));
				hi.setCreationTimestamp(rs.getString("creationTimestamp"));
				hi.setClosureRemarks(rs.getString("closureRemarks"));
				hi.setClosed(rs.getBoolean("isClosed"));
				hi.setClosureTimestamp(rs.getString("closureTimestamp"));
				hi.setOperatorName(rs.getString("operatorUsername"));
				hi.setIncidentType(rs.getString("typeOfIncident"));
				hi.setCentralPsi(rs.getInt("centralPsi"));
				hi.setNorthPsi(rs.getInt("northPsi"));
				hi.setSouthPsi(rs.getInt("southPsi"));
				hi.setEastPsi(rs.getInt("eastPsi"));
				hi.setWestPsi(rs.getInt("westPsi"));
				hi.setIncidentID(rs.getInt("incidentID"));
			
			}
		}catch(Exception e){
			
		}
		return hi;
	}
	public ArrayList<HazeInfo> retrieveHazeInfo(){
		HazeInfo hi=null;
		DbController db=new DbController();
		ArrayList<HazeInfo> list=new ArrayList<HazeInfo>();
		String query="select * from hazeinfo inner join incident on hazeinfo.incidentID=incident.incidentID";
		try{
			ResultSet rs=db.executeSql(query);
			if(rs.next()){
				hi=new HazeInfo();
				hi.setIncidentID(rs.getInt("incidentID"));
				hi.setReporterName(rs.getString("reporterName"));
				hi.setReporterPhoneNumber(rs.getInt("reporterPhoneNumber"));
				hi.setLocation(rs.getString("location"));
				hi.setTypeOfAssistance(rs.getString("typeOfAssistance"));
				hi.setDescription(rs.getString("description"));
				hi.setCreationTimestamp(rs.getString("creationTimestamp"));
				hi.setClosureRemarks(rs.getString("closureRemarks"));
				hi.setClosed(rs.getBoolean("isClosed"));
				hi.setClosureTimestamp(rs.getString("closureTimestamp"));
				hi.setOperatorName(rs.getString("operatorUsername"));
				hi.setIncidentType(rs.getString("typeOfIncident"));
				hi.setCentralPsi(rs.getInt("centralPsi"));
				hi.setNorthPsi(rs.getInt("northPsi"));
				hi.setSouthPsi(rs.getInt("southPsi"));
				hi.setEastPsi(rs.getInt("eastPsi"));
				hi.setWestPsi(rs.getInt("westPsi"));
				hi.setIncidentID(rs.getInt("incidentID"));
				list.add(hi);
			}
		}catch(Exception e){
			
		}
		return list;
	}
	public ArrayList<FireIncident> retrieveFireIncidents(){
		FireIncident fi=null;
		DbController db=new DbController();
		ArrayList<FireIncident> list=new ArrayList<FireIncident>();
		String query="select * from fireincident inner join incident on fireincident.incidentID=incident.incidentID";
		try{
			ResultSet rs=db.executeSql(query);
			if(rs.next()){
				fi=new FireIncident();
				fi.setIncidentID(rs.getInt("incidentID"));
				fi.setReporterName(rs.getString("reporterName"));
				fi.setReporterPhoneNumber(rs.getInt("reporterPhoneNumber"));
				fi.setLocation(rs.getString("location"));
				fi.setTypeOfAssistance(rs.getString("typeOfAssistance"));
				fi.setDescription(rs.getString("description"));
				fi.setCreationTimestamp(rs.getString("creationTimestamp"));
				fi.setClosureRemarks(rs.getString("closureRemarks"));
				fi.setClosed(rs.getBoolean("isClosed"));
				fi.setClosureTimestamp(rs.getString("closureTimestamp"));
				fi.setOperatorName(rs.getString("operatorUsername"));
				fi.setIncidentType(rs.getString("typeOfIncident"));
				fi.setNumberOfCasualties(rs.getInt("numberOfCasualties"));
				fi.setFirefightingTime(rs.getInt("firefightingTime"));
				list.add(fi);
			}
		}catch(Exception e){
			
		}
		return list;
	}
//	public void updateLocation(int incidentID,String location){
//		DbController db=new DbController();
//		String query="insert into publicuser values(";
//		db.executeSql(query);
//		db.close();
//	}
//	
//	public void updateDescription(int incidentID,String description){
//		DbController db=new DbController();
//		String query="insert into publicuser values(";
//		db.executeSql(query);
//		db.close();
//	}
	

	
}
