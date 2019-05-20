package org.redquark.csfundamentals.designpatterns.creational.abstractfactory;

/**
 * @Author Anirudh Sharma
 */
public class MumbaiErrorXMLParser implements XMLParser {

	@Override
	public String parse() {
		System.out.println("Mumbai Error XML Parser...");
		return "Mumbai Error XML Message";
	}
}
