package org.redquark.csfundamentals.spring.springdi.config;

import org.redquark.csfundamentals.spring.springdi.services.MessageService;
import org.redquark.csfundamentals.spring.springdi.services.impl.EmailMessageServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Anirudh Sharma
 *
 */
@Configuration
@ComponentScan(value = {"org.redquark.csfundamentals.spring.springdi.components"})
public class DIConfiguration {

	@Bean
	public MessageService getService() {
		return new EmailMessageServiceImpl();
	}
}
