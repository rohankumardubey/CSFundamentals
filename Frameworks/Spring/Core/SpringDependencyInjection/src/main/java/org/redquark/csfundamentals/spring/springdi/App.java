package org.redquark.csfundamentals.spring.springdi;

import org.redquark.csfundamentals.spring.springdi.components.AnnotationBasedComponent;
import org.redquark.csfundamentals.spring.springdi.components.XMLBasedComponent;
import org.redquark.csfundamentals.spring.springdi.config.DIConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Anirudh Sharma
 *
 */
public class App {

	public static void main(String[] args) {

		String message = "Spring is a lightweight container";
		String receiver = "anirudh03sharma@gmail.com";

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);

		AnnotationBasedComponent annotationBasedComponent = context.getBean(AnnotationBasedComponent.class);

		annotationBasedComponent.processMessage(message, receiver);

		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"BeanConfiguration.xml");

		XMLBasedComponent xmlBasedComponent = (XMLBasedComponent) context.getBean("xmlComponent");

		xmlBasedComponent.processMessage(message, receiver);
		
		// Closing the context
		context.close();

		// Closing the context
		classPathXmlApplicationContext.close();
	}

}
