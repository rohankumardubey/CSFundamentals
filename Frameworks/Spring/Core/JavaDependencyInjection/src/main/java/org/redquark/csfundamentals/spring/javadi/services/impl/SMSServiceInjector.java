package org.redquark.csfundamentals.spring.javadi.services.impl;

import org.redquark.csfundamentals.spring.javadi.services.Consumer;
import org.redquark.csfundamentals.spring.javadi.services.MessageServiceInjector;

/**
 * @author Anirudh Sharma
 *
 */
public class SMSServiceInjector implements MessageServiceInjector {

	/**
	 * This method returns the instance of Consumer with specific message service
	 * type
	 */
	@Override
	public Consumer getConsumer() {
		return new ConsumerImpl(new SMSMessageServiceImpl());
	}

}
