package org.redquark.csfundamentals.spring.springdi.services;

/**
 * @author Anirudh Sharma
 *
 */
public interface MessageService {

	/**
	 * This method sends specified message to the specified receiver
	 * 
	 * @param message
	 * @param receiver
	 */
	void sendMessage(String message, String receiver);
}
