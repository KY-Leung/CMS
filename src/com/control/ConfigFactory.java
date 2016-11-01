package com.control;

import java.io.BufferedReader;
import java.io.FileReader;

public class ConfigFactory{
	private static String configFilepath="config.ini";
	final static String DB_TAG="dbtype-";
	final static String MY_SQL="mysql";
	public static DbController getDbController(){
		DbController db=null;
		//String dbString=getDbType();
		String dbString=MY_SQL;
		System.out.println("The db string is "+dbString);
		switch(dbString){
		case (MY_SQL):
			db=new MySqlController();
			break;
		default:
			db=new MySqlController();
		}
		
		return db;
	}
	
	public static String getDbType(){
		//read from file
		try{
			BufferedReader br=new BufferedReader(new FileReader(configFilepath));
			String l=br.readLine();
			while(l!=null){
				if(l.indexOf(ConfigFactory.DB_TAG,0)==0){
					String[] list=l.split("-");
					return list[1];
				} 
					
				l=br.readLine();
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}