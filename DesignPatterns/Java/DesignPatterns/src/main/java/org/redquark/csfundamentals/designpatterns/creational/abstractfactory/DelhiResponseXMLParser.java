package org.redquark.csfundamentals.designpatterns.creational.abstractfactory;

/**
 * @Author Anirudh Sharma
 */
public class DelhiResponseXMLParser implements XMLParser {

	@Override
	public String parse() {
		System.out.println("Delhi Response XML Parser...");
		return "Delhi Response XML Message";
	}
}
