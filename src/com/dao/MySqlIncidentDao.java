package com.dao;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dao.DbController;
import com.dao.DbFactory;
import com.dao.IncidentDao;
import com.entity.EmergencyServicesInfo;
import com.entity.FireIncident;
import com.entity.HazeInfo;
import com.entity.Incident;


// TODO: Auto-generated Javadoc
/**
 * The Class MySqlIncidentDao is mysql implementation of incidentdao.
 */
public class MySqlIncidentDao implements IncidentDao{
	
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
	public int createIncident(String reporterName,int reporterPhoneNumber,String typeOfAssistance,String typeOfIncident,String location,String description,String operatorName){
		int incidentID=1;
		DbController db=DbFactory.getDbController();
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
	public void createHazeInfo(int incidentID,int central,int north,int south,int east,int west){
		DbController db=DbFactory.getDbController();
		db.connect();
		String query="insert into hazeinfo values("+incidentID+","+central+","+north+","+south+","+east+","+west+")";
		System.out.println(query);
		db.updateQuery(query);
		query="update incident set isClosed="+true+" where incidentID="+incidentID;
		System.out.println(query);
		db.updateQuery(query);
		db.close();
	}
	
	/**
	 * Creates the fire incident.
	 *
	 * @param incidentID the incident ID
	 * @param numberOfCasualties the number of casualties
	 * @param firefightingTime the firefighting time
	 */
	public void createFireIncident(int incidentID,int numberOfCasualties,int firefightingTime){
		DbController db=DbFactory.getDbController();
		db.connect();
		String query="insert into fireincident values("+incidentID+","+numberOfCasualties+","+firefightingTime+")";
		db.updateQuery(query);
		db.close();
	}
	
	/**
	 * Close incident.
	 *
	 * @param incidentID the incident ID
	 * @param closeRemarks the close remarks
	 */
	public void closeIncident(int incidentID,String closeRemarks){
		DbController db=DbFactory.getDbController();
		db.connect();
		String query="update incident set isClosed="+true+",closureTimestamp=CURRENT_TIMESTAMP,closureRemarks='"+closeRemarks+"' where incidentID="+incidentID;
		db.updateQuery(query);
		db.close();
		
	}
	
	/**
	 * Retrieve single incident.
	 *
	 * @param incidentID the incident ID
	 * @return the incident
	 */
	public Incident retrieveSingleIncident(int incidentID){
		Incident incident=null;
		DbController db=DbFactory.getDbController();
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
	
	/**
	 * Retrieve incidents.
	 *
	 * @return the array list
	 */
	public ArrayList<Incident> retrieveIncidents(){
		ArrayList<Incident> list=new ArrayList<Incident>();
		Incident incident=null;
		DbController db=DbFactory.getDbController();
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
	
	/**
	 * Retrieve latest haze info.
	 *
	 * @return the haze info
	 */
	public HazeInfo retrieveLatestHazeInfo(){
		HazeInfo hi=new HazeInfo();
		DbController db=DbFactory.getDbController();
		db.connect();
		String query="select * from hazeinfo inner join incident on hazeinfo.incidentID=incident.incidentID order by hazeInfo.incidentID DESC LIMIT 1";
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
			e.printStackTrace();
		}
		db.close();
		return hi;
	}
	
	/**
	 * Retrieve haze info.
	 *
	 * @return the array list
	 */
	public ArrayList<HazeInfo> retrieveHazeInfo(){
		HazeInfo hi=null;
		DbController db=DbFactory.getDbController();
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
		db.close();
		return list;
	}
	
	/**
	 * Retrieve fire incidents.
	 *
	 * @return the array list
	 */
	public ArrayList<FireIncident> retrieveFireIncidents(){
		FireIncident fi=null;
		DbController db=DbFactory.getDbController();
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
				fi.setOperatorName(rs.getString("operatorUsername"));
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
	

	
}
