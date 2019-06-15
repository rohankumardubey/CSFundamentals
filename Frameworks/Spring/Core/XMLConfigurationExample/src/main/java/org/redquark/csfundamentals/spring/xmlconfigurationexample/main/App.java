package org.redquark.csfundamentals.spring.xmlconfigurationexample.main;

import org.redquark.csfundamentals.spring.xmlconfigurationexample.beans.UserAccountBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Anirudh Sharma
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Initialize Spring beans from bean configuration XML file
		ApplicationContext context = new ClassPathXmlApplicationContext("BeansConfiguration.xml");

		// Get user account bean
		UserAccountBean userAccountBean = (UserAccountBean) context.getBean("UserAccountBean");

		// Invoke spring managed bean method
		String message = userAccountBean.sayHello();

		System.out.println(message);

		// Change spring bean property value
		userAccountBean.setUserName("Batman");
		userAccountBean.setEmail("bruce.wayne@gotham.city");
		userAccountBean.setPassword("jokerisfinished");

		// Invoke spring managed bean method with updated value
		String updatedMessage = userAccountBean.sayHello();

		System.out.println(updatedMessage);

		// Closing the application context
		((ConfigurableApplicationContext) context).close();
	}

}
