package com.control;
import java.util.ArrayList;

import com.entity.User;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

// TODO: Auto-generated Javadoc
/**
 * The Class SmsDispatcher.
 */
public class SmsDispatcher implements InfoDispatcher{
  
  /** The Constant ACCOUNT_SID. */
  public static final String ACCOUNT_SID = "ACedadb3d03d5744a48e9f9ad0adb36199";
  
  /** The Constant AUTH_TOKEN. */
  public static final String AUTH_TOKEN = "7aad75b32021de9bd9915f708c2ab10b";
  
  /** The subject. */
  private String phoneNumberFrom,phoneNumberTo,smsMessage,subject;
  
  /**
   * Instantiates a new sms dispatcher.
   *
   * @param phoneNumberFrom the phone number from
   * @param phoneNumberTo the phone number to
   */
  public SmsDispatcher(String phoneNumberFrom, String phoneNumberTo){
	  this.phoneNumberFrom=phoneNumberFrom;
	  this.phoneNumberTo=phoneNumberTo;
  }
  
  /**
   * Sets the sms message.
   *
   * @param message the sms message
   */
  public void setMessage(String message){
	  smsMessage=message;
  }
  
  /**
   * Sets the subject.
   *
   * @param subject the new subject
   */
  public void setSubject(String subject){
	  this.subject=subject;
  }
  
  /**
   * Dispatches sms
   */
  public void dispatchInformation(){
	  
	  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	  // Phone number to, phone number from, message
	  // Message message = Message.creator(new PhoneNumber(phoneNumberTo), new PhoneNumber(phoneNumberFrom), smsMessage).create();

	  // System.out.println(message.getSid());
	  System.out.println("\"" + smsMessage + " \"" + "sent to " + phoneNumberTo);
	  
  }
  
  /**
   * The main method.
   *
   * @param args the arguments
   */
  public static void main(String[] args) {
	  // cz3003softwareanalysis@gmail.com
	  // Backstreetboys1
	  System.out.println("In main"); 
	  SettingsManager sm = new SettingsManager(""); 
		ArrayList<User> users = sm.getFireInfoUsers(); 
		ArrayList<String> phone_numbers = new ArrayList<String>(); 
		
		for (User user : users) {
			phone_numbers.add(String.valueOf(user.getPhoneNumber())); 
		}
		
		if(!phone_numbers.isEmpty()) {
			broadcastAllMessages("test fire dispatch", phone_numbers);
		}
  }
  
  /**
   * Broadcast all messages.
   *
   * @param smsmessage the smsmessage
   * @param allPhoneNumbers the all phone numbers
   */
  public static void broadcastAllMessages(String smsmessage, ArrayList<String> allPhoneNumbers){

	  String phoneNumberFrom = "+6590093106";
	  
	  for(String phoneNumberTo : allPhoneNumbers){
		  // System.out.println("Sending text message to: " + phoneNumberTo);
		  InfoDispatcher sd = new SmsDispatcher(phoneNumberFrom, phoneNumberTo);
		  sd.setMessage(smsmessage);
		  sd.dispatchInformation();
	  }
	  
	}

  
  
}