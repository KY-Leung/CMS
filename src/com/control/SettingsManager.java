package com.control;
import java.sql.ResultSet;

import com.entity.Settings;


public class SettingsManager {
	DbController db=null;
	String username;
	public SettingsManager(String username){
		this.username=username;
		db=new DbController();
	}
	public void finishUpdate(){
		db.close();
	}
	
	public void createSettings(boolean viaSms,boolean hazeInfo,boolean fireInfo,boolean maskInfo,boolean bombshelterInfo){
		String query="insert into settings values('"+username+"',"+hazeInfo+","+fireInfo+","+maskInfo+","+bombshelterInfo+","+viaSms+")";
		db.updateSql(query);
	}
	public void updateSms(boolean x){
		String query="update settings set viaSms="+x+" where username='"+username+"'";
		db.updateSql(query);
	}
	
	public void updateHazeInfo(boolean x){
		String query="update settings set hazeInfo="+x+" where username='"+username+"'";
		db.updateSql(query);
	}
	
	public void updateBombshelterinfo(boolean x){
		String query="update settings set bombshelterInfo="+x+" where username='"+username+"'";
		db.updateSql(query);
	}
	
	public void updateFireInfo(boolean x){
		String query="update settings set fireInfo="+x+" where username='"+username+"'";
		db.updateSql(query);
	}
	
	public void updateMaskInfo(boolean x){
		String query="update settings set maskInfo="+x+" where username='"+username+"'";
		db.updateSql(query);
		
	}
	public Settings getSettings(){
		Settings s=new Settings();
		s.setUsername(username);
		String query="select *  from settings where username='"+username+"'";
		try{
			ResultSet rs=db.executeSql(query);
			while(rs.next()){
				s.setViaSms(rs.getBoolean("viaSms"));
				s.setHazeInfo(rs.getBoolean("hazeInfo"));
				s.setFireInfo(rs.getBoolean("fireInfo"));
				s.setMaskInfo(rs.getBoolean("maskInfo"));
				s.setBombshelterInfo(rs.getBoolean("bombshelterInfo"));
			}
		}catch(Exception e){
			
		}
		
		return s;
	}
}
