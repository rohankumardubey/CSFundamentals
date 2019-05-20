package org.redquark.csfundamentals.designpatterns.creational.abstractfactory;

/**
 * To avoid a dependency between the client code and the factories, optionally we implemented a factory-producer which has a
 * static method and is responsible to provide a desired factory object to the client object.
 *
 * @Author Anirudh Sharma
 */
public final class ParserFactoryProducer {

	private ParserFactoryProducer() {
		throw new AssertionError();
	}

	public static AbstractXMLParserFactory getFactory(String factoryType) {

		switch (factoryType) {
			case "DELHI_FACTORY":
				return new DelhiXMLParserFactory();
			case "MUMBAI_FACTORY":
				return new MumbaiXMLParserFactory();
		}
		return null;
	}
}
