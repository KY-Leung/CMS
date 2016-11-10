package com.control;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dao.DaoFactory;
import com.dao.DbController;
import com.dao.DbFactory;
import com.dao.SettingsDao;
import com.entity.Settings;
import com.entity.User;



// TODO: Auto-generated Javadoc
/**
 * The Class SettingsManager.
 */
public class SettingsManager{
	
	/** The username. */
	String username;
	
	/**
	 * Instantiates a new settings manager.
	 *
	 * @param username the username
	 */
	public SettingsManager(String username){
		this.username=username;
	}
	
	/**
	 * Creates the settings for a new user.
	 *
	 * @param viaSms the via sms
	 * @param hazeInfo the haze info
	 * @param fireInfo the fire info
	 * @param maskInfo the mask info
	 * @param bombshelterInfo the bombshelter info
	 */
	public void createSettings(boolean viaSms,boolean hazeInfo,boolean fireInfo,boolean maskInfo,boolean bombshelterInfo){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		dao.createSettings(viaSms, hazeInfo, fireInfo, maskInfo, bombshelterInfo);
	}
	
	/**
	 * Update whether user wants sms notification.
	 *
	 * @param x the x
	 */
	public void updateSms(boolean x){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		dao.updateSms(x);
	}
	
	/**
	 * Update whether user wants haze info notifications.
	 *
	 * @param x the x
	 */
	public void updateHazeInfo(boolean x){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		dao.updateHazeInfo(x);
	}
	
	/**
	 * Update whether user wants bombshelterinfo notifications.
	 *
	 * @param x the x
	 */
	public void updateBombshelterinfo(boolean x){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		dao.updateBombshelterinfo(x);
	}
	
	/**
	 * Update whether user wants fire info notifications.
	 *
	 * @param x the x
	 */
	public void updateFireInfo(boolean x){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		dao.updateFireInfo(x);
	}
	
	/**
	 * Update whether user wants mask info notifications.
	 *
	 * @param x the x
	 */
	public void updateMaskInfo(boolean x){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		dao.updateMaskInfo(x);
		
	}
	
	/**
	 * Gets the settings object of the user.
	 *
	 * @return the settings
	 */
	public Settings getSettings(){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		return dao.getSettings();
	}
	
	/**
	 * Gets list of users who want haze info notications.
	 *
	 * @return the haze info users
	 */
	public ArrayList<User> getHazeInfoUsers(){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		return dao.getHazeInfoUsers();
	}
	
	/**
	 * Gets list of users who want fire info notications
	 *
	 * @return the fire info users
	 */
	public ArrayList<User> getFireInfoUsers(){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		return dao.getFireInfoUsers();
	}
	
	/**
	 * Gets list of users who want mask info notifications
	 *
	 * @return the mask info users
	 */
	public ArrayList<User> getMaskInfoUsers(){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		return dao.getMaskInfoUsers();
	}
	
	/**
	 * Gets list of users who want bombshelter info notifications
	 *
	 * @return the bombshelter info users
	 */
	public ArrayList<User> getBombshelterInfoUsers(){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		return dao.getBombshelterInfoUsers();
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		SettingsManager sm=new SettingsManager("asf");
		System.out.println(sm.getBombshelterInfoUsers().size());
		System.out.println(sm.getFireInfoUsers().size());
		System.out.println(sm.getHazeInfoUsers().size());
		System.out.println(sm.getMaskInfoUsers().size());
	}
}
