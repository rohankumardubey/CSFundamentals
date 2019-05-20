package org.redquark.csfundamentals.designpatterns.creational.abstractfactory;

/**
 * @Author Anirudh Sharma
 */
public class MumbaiOrderXMLParser implements XMLParser {

	@Override
	public String parse() {
		System.out.println("Mumbai Order XML Parser...");
		return "Mumbai Order XML Message";
	}
}
