package com.control;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entity.EmergencyServicesInfo;
import com.entity.FireIncident;
import com.entity.HazeInfo;
import com.entity.Incident;


public class IncidentManager {
	public int createIncident(String reporterName,int reporterPhoneNumber,String typeOfAssistance,String typeOfIncident,String location,String description,String operatorName){
		int incidentID=1;
		DbController db=ConfigFactory.getDbController();
		db.connect();
		String query="insert into incident values(null,'"+reporterName+"',"+reporterPhoneNumber+",'"+typeOfIncident+"','"+location+"','"+typeOfAssistance+"','"+description+"',null,false,null,null,'"+operatorName+"')";
		System.out.println(query);
		db.updateQuery(query);
		query="select last_insert_id() as last";
		try{
			ResultSet rs=db.executeQuery(query);
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
		DbController db=ConfigFactory.getDbController();
		db.connect();
		String query="insert into hazeinfo values("+incidentID+","+central+","+north+","+south+","+east+","+west+")";
		System.out.println(query);
		db.updateQuery(query);
		query="update incident set isClosed="+true+" where incidentID="+incidentID;
		System.out.println(query);
		db.updateQuery(query);
		db.close();
	}
	
	public void createFireIncident(int incidentID,int numberOfCasualties,int firefightingTime){
		DbController db=ConfigFactory.getDbController();
		db.connect();
		String query="insert into fireincident values("+incidentID+","+numberOfCasualties+","+firefightingTime+")";
		db.updateQuery(query);
		db.close();
	}
	public void closeIncident(int incidentID,String closeRemarks){
		DbController db=ConfigFactory.getDbController();
		db.connect();
		String query="update incident set isClosed="+true+",closureTimestamp=CURRENT_TIMESTAMP,closureRemarks='"+closeRemarks+"' where incidentID="+incidentID;
		db.updateQuery(query);
		db.close();
		
	}
	public Incident retrieveSingleIncident(int incidentID){
		Incident incident=null;
		DbController db=ConfigFactory.getDbController();
		db.connect();
		String query="select * from incident left join hazeinfo on incident.incidentID=hazeinfo.incidentID left join fireincident on incident.incidentID=fireincident.incidentID where incident.incidentID="+incidentID;
		try{
			System.out.println(query);
			ResultSet rs=db.executeQuery(query);
			while(rs.next()){
				if(rs.getString("typeOfIncident").equals(Incident.FIRE_INCIDENT)){
					FireIncident fIncident=new FireIncident();
					fIncident.setNumberOfCasualties(rs.getInt("numberOfCasualties"));
					fIncident.setFirefightingTime(rs.getInt("firefightingTime"));
					incident=fIncident;
				}
				else if(rs.getString("typeOfIncident").equals(Incident.HAZE_INFO)){
					HazeInfo hInfo=new HazeInfo();
					hInfo.setCentralPsi(rs.getInt("centralPsi"));
					hInfo.setNorthPsi(rs.getInt("northPsi"));
					hInfo.setSouthPsi(rs.getInt("southPsi"));
					hInfo.setEastPsi(rs.getInt("eastPsi"));
					hInfo.setWestPsi(rs.getInt("westPsi"));
					incident=hInfo;
				}
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

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		db.close();
		return incident;
	}
	public ArrayList<Incident> retrieveIncidents(){
		ArrayList<Incident> list=new ArrayList<Incident>();
		Incident incident=null;
		DbController db=ConfigFactory.getDbController();
		db.connect();
		String query="select * from incident";
		try{
			ResultSet rs=db.executeQuery(query);
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
			e.printStackTrace();
		}
		db.close();
		return list;
	}
	public HazeInfo retrieveLatestHazeInfo(){
		HazeInfo hi=new HazeInfo();
		DbController db=ConfigFactory.getDbController();
		db.connect();
		String query="select * from hazeinfo inner join incident on hazeinfo.incidentID=incident.incidentID order by incidentID DESC LIMIT 1";
		try{
			ResultSet rs=db.executeQuery(query);
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
				hi.setOperatorName(rs.getString("operatorName"));
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
		db.close();
		return hi;
	}
	public ArrayList<HazeInfo> retrieveHazeInfo(){
		HazeInfo hi=null;
		DbController db=ConfigFactory.getDbController();
		db.connect();
		ArrayList<HazeInfo> list=new ArrayList<HazeInfo>();
		String query="select * from hazeinfo inner join incident on hazeinfo.incidentID=incident.incidentID";
		try{
			ResultSet rs=db.executeQuery(query);
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
				hi.setOperatorName(rs.getString("operatorName"));
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
		db.close();
		return list;
	}
	public ArrayList<FireIncident> retrieveFireIncidents(){
		FireIncident fi=null;
		DbController db=ConfigFactory.getDbController();
		db.connect();
		ArrayList<FireIncident> list=new ArrayList<FireIncident>();
		String query="select * from fireincident inner join incident on fireincident.incidentID=incident.incidentID";
		try{
			ResultSet rs=db.executeQuery(query);
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
				fi.setOperatorName(rs.getString("operatorName"));
				fi.setIncidentType(rs.getString("typeOfIncident"));
				fi.setNumberOfCasualties(rs.getInt("numberOfCasualties"));
				fi.setFirefightingTime(rs.getInt("firefightingTime"));
				list.add(fi);
			}
		}catch(Exception e){
			
		}
		db.close();
		return list;
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
