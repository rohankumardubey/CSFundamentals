package org.redquark.csfundamentals.designpatterns.creational.factory;

/**
 * @Author Anirudh Sharma
 */
public class ErrorXMLDisplayService extends DisplayService {

	@Override
	XMLParser getParser() {
		return new ErrorXMLParser();
	}
}
