package com.control;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dao.DaoFactory;
import com.dao.DbController;
import com.dao.DbFactory;
import com.dao.SettingsDao;
import com.entity.Settings;
import com.entity.User;



public class SettingsManager{
	String username;
	public SettingsManager(String username){
		this.username=username;
	}
	
	public void createSettings(boolean viaSms,boolean hazeInfo,boolean fireInfo,boolean maskInfo,boolean bombshelterInfo){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		dao.createSettings(viaSms, hazeInfo, fireInfo, maskInfo, bombshelterInfo);
	}
	public void updateSms(boolean x){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		dao.updateSms(x);
	}
	
	public void updateHazeInfo(boolean x){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		dao.updateHazeInfo(x);
	}
	
	public void updateBombshelterinfo(boolean x){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		dao.updateBombshelterinfo(x);
	}
	
	public void updateFireInfo(boolean x){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		dao.updateFireInfo(x);
	}
	
	public void updateMaskInfo(boolean x){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		dao.updateMaskInfo(x);
		
	}
	public Settings getSettings(){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		return dao.getSettings();
	}
	
	public ArrayList<User> getHazeInfoUsers(){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		return dao.getHazeInfoUsers();
	}
	
	public ArrayList<User> getFireInfoUsers(){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		return dao.getFireInfoUsers();
	}
	
	public ArrayList<User> getMaskInfoUsers(){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		return dao.getMaskInfoUsers();
	}
	
	public ArrayList<User> getBombshelterInfoUsers(){
		SettingsDao dao=DaoFactory.getSettingsDao(username);
		return dao.getBombshelterInfoUsers();
	}
	public static void main(String[] args){
		SettingsManager sm=new SettingsManager("asf");
		System.out.println(sm.getBombshelterInfoUsers().size());
		System.out.println(sm.getFireInfoUsers().size());
		System.out.println(sm.getHazeInfoUsers().size());
		System.out.println(sm.getMaskInfoUsers().size());
	}
}
