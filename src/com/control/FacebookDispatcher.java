package com.control;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.exception.FacebookException;
import com.restfb.types.FacebookType;
import com.restfb.types.Page;
import com.restfb.types.User;

public class FacebookDispatcher implements InfoDispatcher{
	// Gmail Login
	// User: cz3003facebook@gmail.com
	// Pw : kohkianboon
	
	// Facebook Login
	// User : cz3003facebook@gmail.com
	// Pw : kohkianboon1! 
	
	// Using Facebook Graph Api v2.8
	// Account ID : 109205302895608 (cz3003facebook@gmail.com facebook account)
	// Application ID : 1425253490836045 (Crisis Management System Application)
	// Application Secret : 7efd0178e84e5d5553ef1b31df8cd2b4 
	
	// Access token will last till Jan 2017
	// To check access token expiry date: https://developers.facebook.com/tools/debug/accesstoken/
	private String pageAccessToken = "EAAUQQrAJQk0BAJNaMsPIbtBi3jUaJyejPpNQd6LRcR7Kf35ZBVtGK7I46CUZBg56XrY2rOtY8pwPI4oZBA4AntZCCS8lWVMGK7oPeDTh3O1QZAGgo27Ox6EI46jkXG0Pzgfr9OyRojuAIZCcs8NKZCJBPChYM8ZCmHn1YHD2l81sNQZDZD";
    private String pageID = "1821163491495078";
    private FacebookClient fbClient;
    
	private User user = null;
	private Page page = null;
	private String message;
	private String subject;
	
	public FacebookDispatcher(){
	}
	public void setMessage(String message){
		this.message=message;
	}
	public void setSubject(String subject){
		this.subject=subject;
	}
	public void dispatchInformation(){
    	try {
        	
            fbClient = new DefaultFacebookClient(pageAccessToken, Version.VERSION_2_8);
            user = fbClient.fetchObject("me", User.class);
            page = fbClient.fetchObject(pageID, Page.class);
            fbClient.publish(pageID + "/feed", FacebookType.class, Parameter.with("message", message));
            System.out.println("Message posted: " + message);
            
        } catch (FacebookException ex) {
            ex.printStackTrace(System.err);
        }
    	
	}
	public static void main(String[] args){
		FacebookDispatcher fd=new FacebookDispatcher();
		fd.setMessage("Testing FB dispatcher");
		fd.setSubject("Testing");
		fd.dispatchInformation();
	}
	
}
	

// Using RestFb Version 1.33.0



