package com.dao;
import java.sql.*;
// TODO: Auto-generated Javadoc

/**
 * The Class MySqlController is mysql implementation of db controller interface.
 */
public class MySqlController implements DbController{
	
	/** The c. */
	private Connection c;
	
	/** The s. */
	private Statement s;

	/**
	 * Connect to mysql db.
	 */
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
	
	/**
	 * Execute query.
	 *
	 * @param query the query
	 * @return the result set
	 */
	public ResultSet executeQuery(String query){
		ResultSet rs=null;
		try{
			rs=s.executeQuery(query);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return rs;
	}
	
	/**
	 * Update query.
	 *
	 * @param query the query
	 * @return the int
	 */
	public int updateQuery(String query){
		int x=0;
		try{
			x=s.executeUpdate(query);
		}catch(Exception e){
			e.printStackTrace();
		}
		return x;
	}
	
	/**
	 * Close db connection.
	 */
	public void close(){
		try{
			c.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
