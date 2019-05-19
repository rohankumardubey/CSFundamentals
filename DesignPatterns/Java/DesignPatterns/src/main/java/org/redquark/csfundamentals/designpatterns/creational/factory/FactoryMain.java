package org.redquark.csfundamentals.designpatterns.creational.factory;

/**
 * @Author Anirudh Sharma
 */
public class FactoryMain {

	public static void main(String[] args) {

		// Getting feedback message
		DisplayService displayService = new FeedbackXMLDisplayService();
		displayService.display();

		// Getting error message
		displayService = new ErrorXMLDisplayService();
		displayService.display();

		// Getting order message
		displayService = new OrderXMLDisplayService();
		displayService.display();

		// Getting response message
		displayService = new ResponseXMLDisplayService();
		displayService.display();
	}
}
