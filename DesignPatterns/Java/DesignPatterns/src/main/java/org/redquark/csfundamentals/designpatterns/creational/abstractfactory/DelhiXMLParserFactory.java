package org.redquark.csfundamentals.designpatterns.creational.abstractfactory;

/**
 * @Author Anirudh Sharma
 */
public class DelhiXMLParserFactory implements AbstractXMLParserFactory {

	@Override
	public XMLParser getXMLParserInstance(String parserType) {

		switch (parserType) {
			case "DELHI_ORDER":
				return new DelhiOrderXMLParser();
			case "DELHI_FEEDBACK":
				return new DelhiFeedbackXMLParser();
			case "DELHI_RESPONSE":
				return new DelhiResponseXMLParser();
			case "DELHI_ERROR":
				return new DelhiErrorXMLParser();
		}
		return null;
	}
}
