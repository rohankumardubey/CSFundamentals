package org.redquark.csfundamentals.designpatterns.creational.factory;

/**
 * @Author Anirudh
 */
public class OrderXMLDisplayService extends DisplayService {

	@Override
	XMLParser getParser() {
		return new OrderXMLParser();
	}
}
