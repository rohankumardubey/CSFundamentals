package org.redquark.csfundamentals.designpatterns.structural.decorator;

/**
 * @Author Anirudh Sharma
 */
public abstract class PizzaDecorator implements Pizza {

	@Override
	public String getDescription() {
		return "Toppings";
	}
}
