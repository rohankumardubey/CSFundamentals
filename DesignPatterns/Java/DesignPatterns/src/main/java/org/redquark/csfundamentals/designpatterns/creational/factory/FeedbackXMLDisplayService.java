package org.redquark.csfundamentals.designpatterns.creational.factory;

/**
 * @Author Anirudh Sharma
 */
public class FeedbackXMLDisplayService extends DisplayService {

	@Override
	XMLParser getParser() {
		return new FeedbackXMLParser();
	}
}
