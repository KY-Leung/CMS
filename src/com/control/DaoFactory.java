package com.control;

public class DaoFactory {
	public static UserDao getUserDao(){
		UserDao userdao=null;
		//String dbString=Config.getDbType();
		String dbString=Config.MY_SQL;
		System.out.println("The db string is "+dbString);
		switch(dbString){
		case (Config.MY_SQL):
			userdao=new UserController();
			break;
		default:
			userdao=new UserController();
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
			settingsDao=new SettingsManager(username);
			break;
		default:
			settingsDao=new SettingsManager(username);
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
			incidentDao=new IncidentManager();
			break;
		default:
			incidentDao=new IncidentManager();
		}
		return incidentDao;
	}
}
