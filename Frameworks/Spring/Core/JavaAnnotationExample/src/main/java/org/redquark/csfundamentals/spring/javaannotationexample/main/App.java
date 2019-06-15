package org.redquark.csfundamentals.spring.javaannotationexample.main;

import org.redquark.csfundamentals.spring.javaannotationexample.beans.UserAccountBean;
import org.redquark.csfundamentals.spring.javaannotationexample.config.BeansConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Anirudh Sharma
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Create a spring context container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		// Register the spring bean definition java class to load spring beans
		context.register(BeansConfiguration.class);

		/*
		 * Refresh context to avoid error java.lang.IllegalStateException:
		 * org.springframework.context.annotation.AnnotationConfigApplicationContext@
		 * 5b37e0d2 has not been refreshed yet.
		 */
		context.refresh();

		// Get the first bean
		UserAccountBean beanOne = (UserAccountBean) context.getBean("firstBean");

		// Call the method
		System.out.println(beanOne.sayHello());

		// Get the second bean
		UserAccountBean beanTwo = (UserAccountBean) context.getBean("secondBean");

		// Call the method
		System.out.println(beanTwo.sayHello());

		// Tell JVM when JVM shuts down then close this spring context and destroy all
		// context managed beans. This is different from context.close()
		context.registerShutdownHook();

		((ConfigurableApplicationContext) context).close();
	}

}
