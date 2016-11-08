package com.control;

import java.io.BufferedReader;
import java.io.FileReader;

public class DbFactory{

	public static DbController getDbController(){
		DbController db=null;
		//String dbString=Config.getDbType();
		String dbString=Config.MY_SQL;
		System.out.println("The db string is "+dbString);
		switch(dbString){
		case (Config.MY_SQL):
			db=new MySqlController();
			break;
		default:
			db=new MySqlController();
		}
		
		return db;
	}
	


}