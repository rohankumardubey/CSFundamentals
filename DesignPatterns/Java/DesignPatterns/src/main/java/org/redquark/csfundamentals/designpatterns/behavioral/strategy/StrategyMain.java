package org.redquark.csfundamentals.designpatterns.behavioral.strategy;

/**
 * @Author Anirudh Sharma
 */
public class StrategyMain {

	public static void main(String[] args) {

		TextFormatter textFormatter = new UppercaseTextFormatter();
		TextEditor textEditor = new TextEditor(textFormatter);
		textEditor.publishText("Testing text in uppercase formatter");

		textFormatter = new LowercaseTextFormatter();
		textEditor = new TextEditor(textFormatter);
		textEditor.publishText("Testing text in lowercase formatter");
	}
}
