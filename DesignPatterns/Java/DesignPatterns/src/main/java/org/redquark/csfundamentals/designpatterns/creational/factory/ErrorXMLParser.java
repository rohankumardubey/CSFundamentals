package org.redquark.csfundamentals.designpatterns.creational.factory;

/**
 * @Author Anirudh Sharma
 */
public class ErrorXMLParser implements XMLParser {

	@Override
	public String parse() {
		System.out.println("Parsing error XML...");
		return "Error XML Message";
	}
}
