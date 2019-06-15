package org.redquark.csfundamentals.spring.javaannotationexample.config;

import org.redquark.csfundamentals.spring.javaannotationexample.beans.UserAccountBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Anirudh Sharma
 */
@Configuration
public class BeansConfiguration {

	@Bean(name = "firstBean")
	public UserAccountBean getUserAccountOne() {

		UserAccountBean userAccountBean = new UserAccountBean("Anirudh");
		userAccountBean.setUserName("Anirudh");
		userAccountBean.setEmail("anirudh03sharma@gmail.com");
		userAccountBean.setPassword("123456");

		return userAccountBean;
	}

	@Bean(name = "secondBean")
	public UserAccountBean getUserAccountTwo() {

		UserAccountBean userAccountBean = new UserAccountBean("Batman");
		userAccountBean.setUserName("Batman");
		userAccountBean.setEmail("bruce.wayne@gotham.city");
		userAccountBean.setPassword("jokerisfinished");

		return userAccountBean;
	}
}
