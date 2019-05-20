package org.redquark.csfundamentals.designpatterns.creational.abstractfactory;

/**
 * @Author Anirudh Sharma
 */
public class MumbaiResponseXMLParser implements XMLParser {

	@Override
	public String parse() {
		System.out.println("Mumbai Response XML Parser...");
		return "Mumbai Response XML Message";
	}
}
