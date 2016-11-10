package com.control;
import java.sql.ResultSet;

import com.dao.DaoFactory;
import com.dao.DbController;
import com.dao.DbFactory;
import com.dao.MySqlUserDao;
import com.dao.UserDao;


// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
public class UserController{

/** The Constant PUBLIC_USER. */
public static final int PUBLIC_USER=0;

/** The Constant CALL_CENTER_OPERATOR. */
public static final int CALL_CENTER_OPERATOR=1;
	
	/**
	 * Checks if user is authenticated to login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return true, if user is authenticated
	 */
	//used for login
	public boolean isAuthenticated(String username,String password){
		//execute SQL statement
		UserDao dao=DaoFactory.getUserDao();
		return dao.isAuthenticated(username, password);
	}
	
	/**
	 * Check if username already exists
	 *
	 * @param username the username
	 * @return true, if username already exists
	 */
	public boolean usernameExists(String username){
		UserDao dao=DaoFactory.getUserDao();
		return dao.usernameExists(username);
	}
	
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
	public void createUser(String username,String password,String name,int phoneNumber,int type){
		UserDao dao=DaoFactory.getUserDao();
		dao.createUser(username, password, name, phoneNumber, type);
	}
	
	/**
	 * Gets the phone number of user
	 *
	 * @param username the username
	 * @return the phone number
	 */
	//used for sending smsInfo
	public int getPhoneNumber(String username){
		UserDao dao=DaoFactory.getUserDao();
		return dao.getPhoneNumber(username);
	}
	
	/**
	 * Gets the user type.Whether user is public user or call center operator
	 *
	 * @param username the username
	 * @return the user type
	 */
	public int getUserType(String username){
		UserDao dao=DaoFactory.getUserDao();
		return dao.getUserType(username);
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		UserController uc=new UserController();
		//uc.createPublicUser("user2", "password", "user2", 23214);
		System.out.println(uc.isAuthenticated("asf", "asf"));
	}
}
