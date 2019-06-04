package org.redquark.csfundamentals.designpatterns.structural.decorator;

/**
 * @Author Anirudh Sharma
 */
public class VegPizza implements Pizza {

	@Override
	public String getDescription() {
		return "Simple veg pizza (250)";
	}

	@Override
	public double getPrice() {
		return 250;
	}
}
