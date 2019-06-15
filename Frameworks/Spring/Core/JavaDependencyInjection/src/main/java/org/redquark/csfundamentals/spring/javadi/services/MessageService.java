package org.redquark.csfundamentals.spring.javadi.services;

/**
 * This interface declares the contract for message services that we want to use
 * in our application
 * 
 * @author Anirudh Sharma
 */
public interface MessageService {

	/**
	 * This method will send the specified message to the specified receiver
	 * 
	 * @param message
	 * @param receiver
	 */
	void sendMessage(String message, String receiver);

}
