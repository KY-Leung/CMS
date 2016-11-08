package com.dao;

import java.io.BufferedReader;
import java.io.FileReader;

public class Config {
	private static String configFilepath="config.ini";
	final static String DB_TAG="dbtype-";
	final static String MY_SQL="mysql";
	
	public static String getDbType(){
		//read from file
		try{
			BufferedReader br=new BufferedReader(new FileReader(configFilepath));
			String l=br.readLine();
			while(l!=null){
				if(l.indexOf(DB_TAG,0)==0){
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
