package org.redquark.csfundamentals.designpatterns.behavioral.strategy;

/**
 * @Author Anirudh Sharma
 */
public class TextEditor {

	private TextFormatter textFormatter;

	public TextEditor(TextFormatter textFormatter) {
		this.textFormatter = textFormatter;
	}

	public void publishText(String text) {
		textFormatter.format(text);
	}
}
