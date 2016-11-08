package com.control;
import java.sql.ResultSet;

import com.dao.DaoFactory;
import com.dao.DbController;
import com.dao.DbFactory;
import com.dao.MySqlUserDao;
import com.dao.UserDao;


public class UserController{
public static final int PUBLIC_USER=0;
public static final int CALL_CENTER_OPERATOR=1;
	//used for login
	public boolean isAuthenticated(String username,String password){
		//execute SQL statement
		UserDao dao=DaoFactory.getUserDao();
		return dao.isAuthenticated(username, password);
	}
	
	public boolean usernameExists(String username){
		UserDao dao=DaoFactory.getUserDao();
		return dao.usernameExists(username);
	}
	//used for registration
	public void createUser(String username,String password,String name,int phoneNumber,int type){
		UserDao dao=DaoFactory.getUserDao();
		dao.createUser(username, password, name, phoneNumber, type);
	}
	
	//used for sending smsInfo
	public int getPhoneNumber(String username){
		UserDao dao=DaoFactory.getUserDao();
		return dao.getPhoneNumber(username);
	}
	public int getUserType(String username){
		UserDao dao=DaoFactory.getUserDao();
		return dao.getUserType(username);
	}
	public static void main(String[] args){
		UserController uc=new UserController();
		//uc.createPublicUser("user2", "password", "user2", 23214);
		System.out.println(uc.isAuthenticated("asf", "asf"));
	}
}
