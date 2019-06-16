package org.redquark.csfundamentals.spring.springdi.components;

import org.redquark.csfundamentals.spring.springdi.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Anirudh Sharma
 *
 */
@Component
public class AnnotationBasedComponent {

	// Field based dependency injection
	@Autowired
	private MessageService messageService;

	public void processMessage(String message, String receiver) {
		// Do some magic processing
		this.messageService.sendMessage(message, receiver);
	}
}
