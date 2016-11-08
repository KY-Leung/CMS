package com.dao;
import java.sql.ResultSet;

import com.dao.DbController;
import com.dao.DbFactory;
import com.dao.UserDao;


public class MySqlUserDao implements UserDao{
public static final int PUBLIC_USER=0;
public static final int CALL_CENTER_OPERATOR=1;
	//used for login
	public boolean isAuthenticated(String username,String password){
		boolean isAuthenticated=false;
		//execute SQL statement
		DbController db=DbFactory.getDbController();
		db.connect();
		String query="select password from users where username='"+username+"'";
		ResultSet rs=db.executeQuery(query);
		try{
			if(rs.next()){
				if(rs.getString("password").equals(password)){
					System.out.println("entered");
					isAuthenticated=true;
				}
			}
		}
		catch(Exception e){
			
		}
		db.close();
		return isAuthenticated;
	}
	
	public boolean usernameExists(String username){
		boolean userExists=false;
		DbController db=DbFactory.getDbController();
		db.connect();
		String query="select username from users where username='"+username+"'";
		ResultSet rs=db.executeQuery(query);
		try{
			if(rs.next()){
				userExists=true;
			}
		}catch(Exception e){
			
		}
		db.close();
		return userExists;
	}
	//used for registration
	public void createUser(String username,String password,String name,int phoneNumber,int type){
		DbController db=DbFactory.getDbController();
		db.connect();
		String query="insert into users values('"+username+"','"+password+"','"+name+"','"+phoneNumber+"','"+type+"')";
		db.updateQuery(query);
		db.close();
	}
	
	//used for sending smsInfo
	public int getPhoneNumber(String username){
		int phoneNumber=0;
		DbController db=DbFactory.getDbController();
		db.connect();
		ResultSet rs=db.executeQuery("select phoneNumber from users where username='"+username+"'");
		try{
			if(rs.next()){
				phoneNumber=rs.getInt("phoneNumber");
			}
		}
		catch(Exception e){
			
		}
		db.close();
		return phoneNumber;
	}
	public int getUserType(String username){
		int userType=0;
		DbController db=DbFactory.getDbController();
		db.connect();
		ResultSet rs=db.executeQuery("select type from users where username='"+username+"'");
		try{
			if(rs.next()){
				userType=rs.getInt("type");
			}
		}
		catch(Exception e){
			
		}
		db.close();
		return userType;
	}

}
