package org.redquark.csfundamentals.designpatterns.creational.abstractfactory;

/**
 * @Author Anirudh Sharma
 */
public class DelhiFeedbackXMLParser implements XMLParser {

	@Override
	public String parse() {
		System.out.println("Delhi Feedback XML Parser...");
		return "Delhi Feedback XML Message";
	}
}
