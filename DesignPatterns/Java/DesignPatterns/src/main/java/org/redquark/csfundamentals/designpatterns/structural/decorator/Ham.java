package org.redquark.csfundamentals.designpatterns.structural.decorator;

/**
 * @Author Anirudh Sharma
 */
public class Ham extends PizzaDecorator {

	// Instance of the pizza
	private Pizza pizza;

	public Ham(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ", Ham (18.21)";
	}

	@Override
	public double getPrice() {
		return pizza.getPrice() + 18.21;
	}
}
