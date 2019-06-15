package org.redquark.csfundamentals.spring.javadi.services;

/**
 * @author Anirudh Sharma
 *
 */
public interface Consumer {

	/**
	 * This method will process the message
	 * 
	 * @param message
	 * @param receiver
	 */
	void processMessages(String message, String receiver);
}
