package com.control;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entity.Incident;


public class IncidentManager {
	public int createIncident(String reporterName,String reporterPhoneNumber,String typeOfAssistance,String typeOfIncident,String location,String description,String operatorName){
		int incidentID=1;
		DbController db=new DbController();
		String query="insert into incident values(null,'"+reporterName+"',reporterPhoneNumber,"+typeOfIncident+"'"+location+"','"+typeOfAssistance+"','"+description+"',null,null,null,null,'"+operatorName+"')";
		db.updateSql(query);
		db.close();
		return incidentID;
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
				incident.setOperatorName(rs.getString("operatorName"));
				incident.setIncidentType(rs.getString("typeOfIncident"));
				list.add(incident);
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
