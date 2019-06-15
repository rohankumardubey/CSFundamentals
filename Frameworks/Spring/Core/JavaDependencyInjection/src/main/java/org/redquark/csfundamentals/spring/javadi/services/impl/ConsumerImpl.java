package org.redquark.csfundamentals.spring.javadi.services.impl;

import org.redquark.csfundamentals.spring.javadi.services.Consumer;
import org.redquark.csfundamentals.spring.javadi.services.MessageService;

/**
 * @author Anirudh Sharma
 *
 */
public class ConsumerImpl implements Consumer {

	// Instance of MessageService
	private MessageService messageService;
	
	/**
	 * @param messageService
	 */
	public ConsumerImpl(MessageService messageService) {
		super();
		this.messageService = messageService;
	}
	

	@Override
	public void processMessages(String message, String receiver) {
		// Do some processing logic
		this.messageService.sendMessage(message, receiver);
	}

}
