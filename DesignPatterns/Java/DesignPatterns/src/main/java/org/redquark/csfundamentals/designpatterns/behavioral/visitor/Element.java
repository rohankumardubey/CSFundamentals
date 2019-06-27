package org.redquark.csfundamentals.designpatterns.behavioral.visitor;

/**
 * @Author Anirudh Sharma
 */
public interface Element {

	void accept(Visitor visitor);
}
