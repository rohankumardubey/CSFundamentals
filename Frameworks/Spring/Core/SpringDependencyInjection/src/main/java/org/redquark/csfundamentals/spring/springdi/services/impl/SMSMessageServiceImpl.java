package org.redquark.csfundamentals.spring.springdi.services.impl;

import org.redquark.csfundamentals.spring.springdi.services.MessageService;

/**
 * @author Anirudh Sharma
 *
 */
public class SMSMessageServiceImpl implements MessageService {

	/**
	 * This method sends specified message to the specified receiver via SMS
	 */
	@Override
	public void sendMessage(String message, String receiver) {
		System.out.println("SMS sent to: " + receiver + " with message: " + message);
	}

}
