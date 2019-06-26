package org.redquark.csfundamentals.designpatterns.behavioral.strategy;

/**
 * @Author Anirudh Sharma
 */
public class LowercaseTextFormatter implements TextFormatter {

	@Override
	public void format(String text) {
		System.out.println("[Lowercase text formatter]: " + text.toLowerCase());
	}
}
