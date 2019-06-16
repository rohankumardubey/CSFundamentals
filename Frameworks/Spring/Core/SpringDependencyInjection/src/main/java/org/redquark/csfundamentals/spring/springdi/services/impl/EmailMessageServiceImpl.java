package org.redquark.csfundamentals.spring.springdi.services.impl;

import org.redquark.csfundamentals.spring.springdi.services.MessageService;

/**
 * @author Anirudh Sharma
 *
 */
public class EmailMessageServiceImpl implements MessageService {

	/**
	 * This method sends specified message to the specified receiver via email
	 */
	@Override
	public void sendMessage(String message, String receiver) {
		System.out.println("Email sent to: " + receiver + " with message: " + message);
	}

}
