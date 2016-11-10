package com.dao;

import java.io.BufferedReader;
import java.io.FileReader;

// TODO: Auto-generated Javadoc
/**
 * The Class Config.
 */
public class Config {
	
	/** The config filepath. */
	private static String configFilepath="config.ini";
	
	/** The Constant DB_TAG. */
	final static String DB_TAG="dbtype-";
	
	/** The Constant MY_SQL. */
	final static String MY_SQL="mysql";
	
	/**
	 * Gets the db type from config file.
	 *
	 * @return the db type
	 */
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
