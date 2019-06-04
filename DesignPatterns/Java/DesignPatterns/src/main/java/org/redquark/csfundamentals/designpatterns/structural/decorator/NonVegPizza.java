package org.redquark.csfundamentals.designpatterns.structural.decorator;

/**
 * @Author Anirudh Sharma
 */
public class NonVegPizza implements Pizza {
	@Override
	public String getDescription() {
		return "Simple non veg pizza (350)";
	}

	@Override
	public double getPrice() {
		return 350;
	}
}
