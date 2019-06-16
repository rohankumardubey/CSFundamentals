package org.redquark.csfundamentals.spring.springdi.components;

import org.redquark.csfundamentals.spring.springdi.services.MessageService;

/**
 * @author Anirudh Sharma
 *
 */
public class XMLBasedComponent {

	// Instance of Message Service
	private MessageService messageService;

	// Setter based dependency injection
	public void setService(MessageService messageService) {
		this.messageService = messageService;
	}

	public void processMessage(String message, String receiver) {
		// Do some magic processing
		this.messageService.sendMessage(message, receiver);
	}
}
