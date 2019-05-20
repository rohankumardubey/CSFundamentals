package org.redquark.csfundamentals.designpatterns.creational.abstractfactory;

/**
 * @Author Anirudh Sharma
 */
public class MumbaiXMLParserFactory implements AbstractXMLParserFactory {

	@Override
	public XMLParser getXMLParserInstance(String parserType) {

		switch (parserType) {
			case "MUMBAI_ORDER":
				return new MumbaiOrderXMLParser();
			case "MUMBAI_RESPONSE":
				return new MumbaiResponseXMLParser();
			case "MUMBAI_FEEDBACK":
				return new MumbaiFeedbackXMLParser();
			case "MUMBAI_ERROR":
				return new MumbaiErrorXMLParser();
		}
		return null;
	}
}
