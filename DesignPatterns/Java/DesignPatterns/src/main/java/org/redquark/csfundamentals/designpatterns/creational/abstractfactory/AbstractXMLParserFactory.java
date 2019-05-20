package org.redquark.csfundamentals.designpatterns.creational.abstractfactory;

/**
 * @Author Anirudh Sharma
 */
public interface AbstractXMLParserFactory {

	/**
	 * This returns the appropriate XML parser type
	 *
	 * @param parserType - Type of the parser needed
	 * @return @{@link XMLParser}
	 */

	XMLParser getXMLParserInstance(String parserType);
}
