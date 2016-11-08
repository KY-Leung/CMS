package com.control;
import java.sql.*;
public class MySqlController implements DbController{
	private Connection c;
	private Statement s;

	public void connect(){
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		try{
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms?useSSL=false","root","password");
			s=c.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String query){
		ResultSet rs=null;
		try{
			rs=s.executeQuery(query);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return rs;
	}
	public int updateQuery(String query){
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
