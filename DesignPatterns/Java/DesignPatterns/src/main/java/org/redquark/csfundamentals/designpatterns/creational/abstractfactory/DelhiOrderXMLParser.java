package org.redquark.csfundamentals.designpatterns.creational.abstractfactory;

/**
 * @Author Anirudh Sharma
 */
public class DelhiOrderXMLParser implements XMLParser {

	@Override
	public String parse() {
		System.out.println("Delhi Order XML Parser...");
		return "Delhi Order XML Message";
	}
}
