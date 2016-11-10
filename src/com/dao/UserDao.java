package com.dao;

import java.sql.ResultSet;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDao.
 */
public interface UserDao {
	
	/**
	 * Checks if user is authenticated to login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return true, if is authenticated
	 */
	public boolean isAuthenticated(String username,String password);
	
	/**
	 * Check if username already exists
	 *
	 * @param username the username
	 * @return true, if successful
	 */
	public boolean usernameExists(String username);
	
	/**
	 * Creates a new user.
	 *
	 * @param username the username
	 * @param password the password
	 * @param name the name
	 * @param phoneNumber the phone number
	 * @param type the type
	 */
	//used for registration
	public void createUser(String username,String password,String name,int phoneNumber,int type);
	
	/**
	 * Gets the phone number of user
	 *
	 * @param username the username
	 * @return the phone number
	 */
	//used for sending smsInfo
	public int getPhoneNumber(String username);
	
	/**
	 * Gets the user type.Whether user is public user or call center operator
	 *
	 * @param username the username
	 * @return the user type
	 */
	public int getUserType(String username);
}
