package org.redquark.csfundamentals.designpatterns.creational.factory;

/**
 * @Author Anirudh Sharma
 */
public class ResponseXMLDisplayService extends DisplayService {

	@Override
	XMLParser getParser() {
		return new ResponseXMLParser();
	}
}
