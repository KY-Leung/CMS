package com.control;
import java.sql.*;
public class DbController {
	private Connection c;
	private Statement s;
	
	public DbController(){
		connect();
	}
	private void connect(){
		try{
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/3003_db?useSSL=false","root","password");
			s=c.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public ResultSet executeSql(String query){
		ResultSet rs=null;
		try{
			rs=s.executeQuery(query);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return rs;
	}
	public int updateSql(String query){
		int x=0;
		try{
			x=s.executeUpdate(query);
		}catch(Exception e){
			e.printStackTrace();
		}
		return x;
	}
	public void close(){
		try{
			c.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
