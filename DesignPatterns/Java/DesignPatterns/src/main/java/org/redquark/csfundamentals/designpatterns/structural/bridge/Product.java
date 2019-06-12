package org.redquark.csfundamentals.designpatterns.structural.bridge;

/**
 * @Author Anirudh Sharma
 */
public interface Product {

	/**
	 * @return name of the product
	 */
	String productName();

	/**
	 * This will be used by the concrete implementers to provide concrete functionality to it.
	 * The method will produce the base model of the product which can be used with any car model after some
	 * modifications specific to that car model.
	 */
	void produce();
}
