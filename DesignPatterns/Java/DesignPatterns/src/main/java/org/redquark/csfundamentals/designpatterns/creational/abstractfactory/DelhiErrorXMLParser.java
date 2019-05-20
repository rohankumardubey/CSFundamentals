package org.redquark.csfundamentals.designpatterns.creational.abstractfactory;

/**
 * @Author Anirudh Sharma
 */
public class DelhiErrorXMLParser implements XMLParser {

	@Override
	public String parse() {
		System.out.println("Delhi Error XML Parser...");
		return "Delhi Error XML Message";
	}
}
