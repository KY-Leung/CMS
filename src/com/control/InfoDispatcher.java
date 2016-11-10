package com.control;

// TODO: Auto-generated Javadoc
/**
 * The Interface InfoDispatcher.
 */
public interface InfoDispatcher {
	
	/**
	 * Sets the message to be dispatched.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message);
	
	/**
	 * Sets the subject of the message.
	 *
	 * @param subject the new subject
	 */
	public void setSubject(String subject);
	
	/**
	 * Dispatch information.
	 */
	public void dispatchInformation();
}
