package com.control;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entity.Settings;
import com.entity.User;



public class SettingsManager {
	String username;
	public SettingsManager(String username){
		this.username=username;
	}
	
	public void createSettings(boolean viaSms,boolean hazeInfo,boolean fireInfo,boolean maskInfo,boolean bombshelterInfo){
		String query="insert into settings values('"+username+"',"+hazeInfo+","+fireInfo+","+maskInfo+","+bombshelterInfo+","+viaSms+")";
		DbController db=new DbController();
		db.updateSql(query);
		db.close();
	}
	public void updateSms(boolean x){
		String query="update settings set viaSms="+x+" where username='"+username+"'";
		DbController db=new DbController();
		db.updateSql(query);
		db.close();
	}
	
	public void updateHazeInfo(boolean x){
		String query="update settings set hazeInfo="+x+" where username='"+username+"'";
		DbController db=new DbController();
		db.updateSql(query);
		db.close();
	}
	
	public void updateBombshelterinfo(boolean x){
		String query="update settings set bombshelterInfo="+x+" where username='"+username+"'";
		DbController db=new DbController();
		db.updateSql(query);
		db.close();
	}
	
	public void updateFireInfo(boolean x){
		String query="update settings set fireInfo="+x+" where username='"+username+"'";
		DbController db=new DbController();
		db.updateSql(query);
		db.close();
	}
	
	public void updateMaskInfo(boolean x){
		String query="update settings set maskInfo="+x+" where username='"+username+"'";
		DbController db=new DbController();
		db.updateSql(query);
		db.close();
		
	}
	public Settings getSettings(){
		Settings s=new Settings();
		s.setUsername(username);
		String query="select *  from settings where username='"+username+"'";
		DbController db=new DbController();
		
		try{
			ResultSet rs=db.executeSql(query);
			while(rs.next()){
				s.setViaSms(rs.getBoolean("viaSms"));
				s.setHazeInfo(rs.getBoolean("hazeInfo"));
				s.setFireInfo(rs.getBoolean("fireInfo"));
				s.setMaskInfo(rs.getBoolean("maskInfo"));
				s.setBombshelterInfo(rs.getBoolean("bombshelterInfo"));
			}
			db.close();
		}catch(Exception e){
			
		}
		
		return s;
	}
	
	public ArrayList<User> getHazeInfoUsers(){
		ArrayList<User> list=new ArrayList<User>();
		User user=null;
		try{
			DbController db=new DbController();
			String query="select * from users where username in(select username from settings where hazeInfo=true);";
			ResultSet rs=db.executeSql(query);
			while(rs.next()){
				user=new User();
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setPhoneNumber(rs.getInt("phoneNumber"));
				user.setType(rs.getInt("type"));
				list.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<User> getFireInfoUsers(){
		ArrayList<User> list=new ArrayList<User>();
		User user=null;
		try{
			DbController db=new DbController();
			String query="select * from users where username in(select username from settings where fireInfo=true);";
			ResultSet rs=db.executeSql(query);
			while(rs.next()){
				user=new User();
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setPhoneNumber(rs.getInt("phoneNumber"));
				user.setType(rs.getInt("type"));
				list.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<User> getMaskInfoUsers(){
		ArrayList<User> list=new ArrayList<User>();
		User user=null;
		try{
			DbController db=new DbController();
			String query="select * from users where username in(select username from settings where maskInfo=true);";
			ResultSet rs=db.executeSql(query);
			while(rs.next()){
				user=new User();
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setPhoneNumber(rs.getInt("phoneNumber"));
				user.setType(rs.getInt("type"));
				list.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<User> getBombshelterInfoUsers(){
		ArrayList<User> list=new ArrayList<User>();
		User user=null;
		try{
			DbController db=new DbController();
			String query="select * from users where username in(select username from settings where bombshelterInfo=true);";
			ResultSet rs=db.executeSql(query);
			while(rs.next()){
				user=new User();
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setPhoneNumber(rs.getInt("phoneNumber"));
				user.setType(rs.getInt("type"));
				list.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public static void main(String[] args){
		SettingsManager sm=new SettingsManager("asf");
		System.out.println(sm.getBombshelterInfoUsers().size());
		System.out.println(sm.getFireInfoUsers().size());
		System.out.println(sm.getHazeInfoUsers().size());
		System.out.println(sm.getMaskInfoUsers().size());
	}
}
