package org.redquark.csfundamentals.designpatterns.creational.abstractfactory;

/**
 * @Author Anirudh Sharma
 */
public class MumbaiFeedbackXMLParser implements XMLParser {

	@Override
	public String parse() {
		System.out.println("Mumbai Feedback XML Parser...");
		return "Mumbai Feedback XML Message";
	}
}
