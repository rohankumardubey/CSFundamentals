package org.redquark.csfundamentals.designpatterns.creational.factory;

/**
 * @Author Anirudh Sharma
 */
public abstract class DisplayService {

	/**
	 * This method returns the appropriate XMLParser instance.
	 * This method is the "factory" method
	 *
	 * @return XMLParser
	 */
	abstract XMLParser getParser();

	/**
	 * Displays the method fetched by the XML parser to the user
	 */
	public void display() {
		XMLParser xmlParser = getParser();
		String message = xmlParser.parse();
		System.out.println(message);
	}
}
