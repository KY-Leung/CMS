package com.control;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.dao.DbController;
import com.dao.DbFactory;
import com.entity.BombshelterInfo;
import com.entity.EmergencyServicesInfo;
import com.entity.HazeInfo;
import com.entity.MaskInfo;
// TODO: Auto-generated Javadoc

/**
 * The Class InfoManager.
 */
public class InfoManager {
	
	/**
	 * Creates new mask info.
	 *
	 * @param location the location where mask is distributed
	 * @param maskType the mask type
	 */
	public void createMaskInfo(String location,String maskType){
		DbController db=DbFactory.getDbController();
		db.connect();
		String query="insert into maskinfo values('"+location+"','"+maskType+"')";
		db.updateQuery(query);
		db.close();
		
	}
	
	/**
	 * Creates new bombshelter info.
	 *
	 * @param location the location of bombshelter
	 */
	public void createBombshelterInfo(String location){
		DbController db=DbFactory.getDbController();
		db.connect();
		String query="insert into bombshelterinfo values('"+location+"')";
		db.updateQuery(query);
		db.close();
	}
	
	/**
	 * Retrieve mask info.
	 *
	 * @return the array list of maskInfo objects
	 */
	public ArrayList<MaskInfo> retrieveMaskInfo(){
		ArrayList<MaskInfo> list=new ArrayList<MaskInfo>();
		MaskInfo mi=null;
		DbController db=DbFactory.getDbController();
		db.connect();
		String query="select * from maskinfo";
		try{
			ResultSet rs=db.executeQuery(query);
			while(rs.next()){
				mi=new MaskInfo();
				mi.setLocation(rs.getString("location"));
				mi.setMaskType(rs.getString("masktype"));
				list.add(mi);
			}
		}catch(Exception e){
			
		}
		db.close();
		return list;
	}
	
	/**
	 * Retrieve bombshelter info.
	 *
	 * @return the array list of bombshelterInfo objects
	 */
	public ArrayList<BombshelterInfo> retrieveBombshelterInfo(){
		ArrayList<BombshelterInfo> list=new ArrayList<BombshelterInfo>();
		BombshelterInfo bi=null;
		DbController db=DbFactory.getDbController();
		db.connect();
		String query="select * from bombshelterinfo";
		try{
			ResultSet rs=db.executeQuery(query);
			while(rs.next()){
				bi=new BombshelterInfo();
				bi.setLocation(rs.getString("location"));
				list.add(bi);
			}
		}catch(Exception e){
			
		}
		db.close();
		return list;
	}
	
	/**
	 * Retrieve emergency services info.
	 *
	 * @return the array list of emergencyServicesInfo objects
	 */
	public ArrayList<EmergencyServicesInfo> retrieveEmergencyServicesInfo(){
		ArrayList<EmergencyServicesInfo> list=new ArrayList<EmergencyServicesInfo>();
		EmergencyServicesInfo ei=null;
		DbController db=DbFactory.getDbController();
		db.connect();
		String query="select * from emergencyservices";
		try{
			ResultSet rs=db.executeQuery(query);
			while(rs.next()){
				ei=new EmergencyServicesInfo();
				ei.setContactNumber(rs.getInt("contactNumber"));
				ei.setName(rs.getString("name"));
			}
		}catch(Exception e){
			
		}
		db.close();
		return list;
	}
}
