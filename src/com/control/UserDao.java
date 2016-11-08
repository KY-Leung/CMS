package com.control;

import java.sql.ResultSet;

public interface UserDao {
	public boolean isAuthenticated(String username,String password);
	
	public boolean usernameExists(String username);
	//used for registration
	public void createUser(String username,String password,String name,int phoneNumber,int type);
	//used for sending smsInfo
	public int getPhoneNumber(String username);
	public int getUserType(String username);
}
