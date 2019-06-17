package org.redquark.csfundamentals.designpatterns.behavioral.chainofresponsibility;

/**
 * @Author Anirudh Sharma
 */
public interface Handler {

	/**
	 * This method sets next handler in the chain
	 *
	 * @param handler - next handler object
	 */
	void setHandler(Handler handler);

	/**
	 * If the handler is able to process the request, this method will process it
	 *
	 * @param file - File that will be passed
	 */
	void processFile(File file);

	/**
	 * This method will return the name of the next handler in chain
	 *
	 * @return name of the next handler
	 */
	String getHandlerName();
}
