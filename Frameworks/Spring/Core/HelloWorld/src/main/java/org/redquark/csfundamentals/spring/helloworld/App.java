package org.redquark.csfundamentals.spring.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Anirudh Sharma
 *
 */
public class App {

	public static void main(String[] args) {

		// Get Spring context
		ApplicationContext springContext = new ClassPathXmlApplicationContext("beans.xml");

		// Get HelloWorldEcample bean by its id
		HelloWorldExample helloWorldExample = (HelloWorldExample) springContext.getBean("helloWorldBean");

		// Invoke the bean's print method
		helloWorldExample.printHello();
		
		// Closing the resource
		((ConfigurableApplicationContext)springContext).close();
	}
}
