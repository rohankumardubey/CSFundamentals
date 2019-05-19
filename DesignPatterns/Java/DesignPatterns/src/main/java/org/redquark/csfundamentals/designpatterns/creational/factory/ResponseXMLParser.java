package org.redquark.csfundamentals.designpatterns.creational.factory;

/**
 * @Author Anirudh Sharma
 */
public class ResponseXMLParser implements XMLParser {

	@Override
	public String parse() {
		System.out.println("Parsing order XML...");
		return "Order XML Message";
	}
}
