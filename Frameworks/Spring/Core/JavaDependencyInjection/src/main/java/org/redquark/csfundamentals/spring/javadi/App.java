package org.redquark.csfundamentals.spring.javadi;

import org.redquark.csfundamentals.spring.javadi.services.Consumer;
import org.redquark.csfundamentals.spring.javadi.services.MessageServiceInjector;
import org.redquark.csfundamentals.spring.javadi.services.impl.EmailServiceInjector;
import org.redquark.csfundamentals.spring.javadi.services.impl.SMSServiceInjector;

/**
 * @author Anirudh Sharma
 *
 */
public class App {
	
	public static void main(String[] args) {
		
		String message = "Spring framework makes your work easy";
		String email = "anirudh03sharma@gmail.com";
		
		MessageServiceInjector injector = null;
		Consumer app = null;
		
		// Send email
		injector = new EmailServiceInjector();
		app = injector.getConsumer();
		app.processMessages(message, email);
		
		// Send email
		injector = new SMSServiceInjector();
		app = injector.getConsumer();
		app.processMessages(message, email);
	}
}
