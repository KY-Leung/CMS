package com.control;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.entity.BombshelterInfo;
import com.entity.EmergencyServicesInfo;
import com.entity.HazeInfo;
import com.entity.MaskInfo;
public class InfoManager {
	public void createMaskInfo(String location,String maskType){
		DbController db=ConfigFactory.getDbController();
		db.connect();
		String query="insert into maskinfo values('"+location+"','"+maskType+"')";
		db.updateQuery(query);
		db.close();
		
	}
	public void createBombshelterInfo(String location){
		DbController db=ConfigFactory.getDbController();
		db.connect();
		String query="insert into bombshelterinfo values('"+location+"')";
		db.updateQuery(query);
		db.close();
	}
	public void createHazeInfo(int centralPsi,int northPsi,int southPsi,int eastPsi,int westPsi,Date timestamp){
		DbController db=ConfigFactory.getDbController();
		db.connect();
		String query="insert into hazeinfo values('"+timestamp+"','"+centralPsi+"','"+northPsi+"','"+southPsi+"','"+eastPsi+"','"+westPsi+"')";
		db.updateQuery(query);
		db.close();
	}
	public ArrayList<MaskInfo> retrieveMaskInfo(){
		ArrayList<MaskInfo> list=new ArrayList<MaskInfo>();
		MaskInfo mi=null;
		DbController db=ConfigFactory.getDbController();
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
	
	public ArrayList<BombshelterInfo> retrieveBombshelterInfo(){
		ArrayList<BombshelterInfo> list=new ArrayList<BombshelterInfo>();
		BombshelterInfo bi=null;
		DbController db=ConfigFactory.getDbController();
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
	
	public ArrayList<EmergencyServicesInfo> retrieveEmergencyServicesInfo(){
		ArrayList<EmergencyServicesInfo> list=new ArrayList<EmergencyServicesInfo>();
		EmergencyServicesInfo ei=null;
		DbController db=ConfigFactory.getDbController();
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
