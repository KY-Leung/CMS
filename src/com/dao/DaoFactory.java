package com.dao;

import com.control.IncidentManager;
import com.control.SettingsManager;
import com.control.UserController;

public class DaoFactory {
	public static UserDao getUserDao(){
		UserDao userdao=null;
		//String dbString=Config.getDbType();
		String dbString=Config.MY_SQL;
		System.out.println("The db string is "+dbString);
		switch(dbString){
		case (Config.MY_SQL):
			userdao=new MySqlUserDao();
			break;
		default:
			userdao=new MySqlUserDao();
		}
		return userdao;
	}
	
	public static SettingsDao getSettingsDao(String username){
		SettingsDao settingsDao=null;
		//String dbString=Config.getDbType();
		String dbString=Config.MY_SQL;
		System.out.println("The db string is "+dbString);
		switch(dbString){
		case (Config.MY_SQL):
			settingsDao=new MySqlSettingsDao(username);
			break;
		default:
			settingsDao=new MySqlSettingsDao(username);
		}
		return settingsDao;
	}
	
	public static IncidentDao getIncidentDao(){
		IncidentDao incidentDao=null;
		//String dbString=Config.getDbType();
		String dbString=Config.MY_SQL;
		System.out.println("The db string is "+dbString);
		switch(dbString){
		case (Config.MY_SQL):
			incidentDao=new MySqlIncidentDao();
			break;
		default:
			incidentDao=new MySqlIncidentDao();
		}
		return incidentDao;
	}
}
