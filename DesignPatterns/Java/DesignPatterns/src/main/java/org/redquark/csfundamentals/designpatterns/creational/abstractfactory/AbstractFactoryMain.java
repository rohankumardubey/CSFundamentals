package org.redquark.csfundamentals.designpatterns.creational.abstractfactory;

import java.util.Objects;

public class AbstractFactoryMain {

	public static void main(String[] args) {

		AbstractXMLParserFactory parserFactory = ParserFactoryProducer.getFactory("DELHI_FACTORY");
		XMLParser xmlParser = Objects.requireNonNull(parserFactory).getXMLParserInstance("DELHI_ORDER");
		System.out.println(xmlParser.parse());

		parserFactory = ParserFactoryProducer.getFactory("MUMBAI_FACTORY");
		xmlParser = Objects.requireNonNull(parserFactory).getXMLParserInstance("MUMBAI_RESPONSE");
		System.out.println(xmlParser.parse());
	}
}
