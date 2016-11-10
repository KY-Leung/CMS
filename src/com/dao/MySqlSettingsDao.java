package com.dao;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dao.DbController;
import com.dao.DbFactory;
import com.dao.SettingsDao;
import com.entity.Settings;
import com.entity.User;



// TODO: Auto-generated Javadoc
/**
 * The Class MySqlSettingsDao is mysql implemenation of settingsdao.
 */
public class MySqlSettingsDao implements SettingsDao{
	
	/** The username. */
	String username;
	
	/**
	 * Instantiates a new my sql settings dao.
	 *
	 * @param username the username
	 */
	public MySqlSettingsDao(String username){
		this.username=username;
	}
	
	/**
	 * Creates the settings.
	 *
	 * @param viaSms the via sms
	 * @param hazeInfo the haze info
	 * @param fireInfo the fire info
	 * @param maskInfo the mask info
	 * @param bombshelterInfo the bombshelter info
	 */
	public void createSettings(boolean viaSms,boolean hazeInfo,boolean fireInfo,boolean maskInfo,boolean bombshelterInfo){
		String query="insert into settings values('"+username+"',"+hazeInfo+","+fireInfo+","+maskInfo+","+bombshelterInfo+","+viaSms+")";
		DbController db=DbFactory.getDbController();
		db.connect();
		db.updateQuery(query);
		db.close();
	}
	
	/**
	 * Update sms.
	 *
	 * @param x the x
	 */
	public void updateSms(boolean x){
		String query="update settings set viaSms="+x+" where username='"+username+"'";
		DbController db=DbFactory.getDbController();
		db.connect();
		db.updateQuery(query);
		db.close();
	}
	
	/**
	 * Update haze info.
	 *
	 * @param x the x
	 */
	public void updateHazeInfo(boolean x){
		String query="update settings set hazeInfo="+x+" where username='"+username+"'";
		DbController db=DbFactory.getDbController();
		db.connect();
		db.updateQuery(query);
		db.close();
	}
	
	/**
	 * Update bombshelterinfo.
	 *
	 * @param x the x
	 */
	public void updateBombshelterinfo(boolean x){
		String query="update settings set bombshelterInfo="+x+" where username='"+username+"'";
		DbController db=DbFactory.getDbController();
		db.connect();
		db.updateQuery(query);
		db.close();
	}
	
	/**
	 * Update fire info.
	 *
	 * @param x the x
	 */
	public void updateFireInfo(boolean x){
		String query="update settings set fireInfo="+x+" where username='"+username+"'";
		DbController db=DbFactory.getDbController();
		db.connect();
		db.updateQuery(query);
		db.close();
	}
	
	/**
	 * Update mask info.
	 *
	 * @param x the x
	 */
	public void updateMaskInfo(boolean x){
		String query="update settings set maskInfo="+x+" where username='"+username+"'";
		DbController db=DbFactory.getDbController();
		db.connect();
		db.updateQuery(query);
		db.close();
		
	}
	
	/**
	 * Gets the settings.
	 *
	 * @return the settings
	 */
	public Settings getSettings(){
		Settings s=new Settings();
		s.setUsername(username);
		String query="select *  from settings where username='"+username+"'";
		DbController db=DbFactory.getDbController();
		db.connect();
		try{
			ResultSet rs=db.executeQuery(query);
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
		db.close();
		return s;
	}
	
	/**
	 * Gets the haze info users.
	 *
	 * @return the haze info users
	 */
	public ArrayList<User> getHazeInfoUsers(){
		ArrayList<User> list=new ArrayList<User>();
		User user=null;
		DbController db=DbFactory.getDbController();
		db.connect();
		try{
			String query="select * from users where username in(select username from settings where hazeInfo=true);";
			ResultSet rs=db.executeQuery(query);
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
		db.close();
		return list;
	}
	
	/**
	 * Gets the fire info users.
	 *
	 * @return the fire info users
	 */
	public ArrayList<User> getFireInfoUsers(){
		ArrayList<User> list=new ArrayList<User>();
		User user=null;
		DbController db=DbFactory.getDbController();
		db.connect();
		try{
			String query="select * from users where username in(select username from settings where fireInfo=true);";
			ResultSet rs=db.executeQuery(query);
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
		db.close();
		return list;
	}
	
	/**
	 * Gets the mask info users.
	 *
	 * @return the mask info users
	 */
	public ArrayList<User> getMaskInfoUsers(){
		ArrayList<User> list=new ArrayList<User>();
		User user=null;
		DbController db=DbFactory.getDbController();
		db.connect();
		try{
			String query="select * from users where username in(select username from settings where maskInfo=true);";
			ResultSet rs=db.executeQuery(query);
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
		db.close();
		return list;
	}
	
	/**
	 * Gets the bombshelter info users.
	 *
	 * @return the bombshelter info users
	 */
	public ArrayList<User> getBombshelterInfoUsers(){
		ArrayList<User> list=new ArrayList<User>();
		User user=null;
		DbController db=DbFactory.getDbController();
		db.connect();
		try{
			String query="select * from users where username in(select username from settings where bombshelterInfo=true);";
			ResultSet rs=db.executeQuery(query);
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
		db.close();
		return list;
	}
}
