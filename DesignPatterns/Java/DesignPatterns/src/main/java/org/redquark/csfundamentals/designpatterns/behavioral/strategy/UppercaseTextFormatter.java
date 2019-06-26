package org.redquark.csfundamentals.designpatterns.behavioral.strategy;

/**
 * @Author Anirudh Sharma
 */
public class UppercaseTextFormatter implements TextFormatter {

	@Override
	public void format(String text) {
		System.out.println("[Uppercase text formatter]: " + text.toUpperCase());
	}
}
