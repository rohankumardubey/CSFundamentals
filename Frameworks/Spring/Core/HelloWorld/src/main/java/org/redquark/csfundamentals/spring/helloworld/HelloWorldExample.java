package org.redquark.csfundamentals.spring.helloworld;

/**
 * @author Anirudh Sharma
 *
 */
public class HelloWorldExample {

	// Name of the user
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void printHello() {
		System.out.println("Hello " + this.getName() + ", welcome to the Spring World");
	}

}
