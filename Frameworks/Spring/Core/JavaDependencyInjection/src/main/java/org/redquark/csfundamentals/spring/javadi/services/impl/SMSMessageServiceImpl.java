package org.redquark.csfundamentals.spring.javadi.services.impl;

import org.redquark.csfundamentals.spring.javadi.services.MessageService;

/**
 * @author Anirudh Sharma
 *
 */
public class SMSMessageServiceImpl implements MessageService {

	@Override
	public void sendMessage(String message, String receiver) {
		System.out.println("SMS sent to: " + receiver + " with message: " + message);
	}

}
