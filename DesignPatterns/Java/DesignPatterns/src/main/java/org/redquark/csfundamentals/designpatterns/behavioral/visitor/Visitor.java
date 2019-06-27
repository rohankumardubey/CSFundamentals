package org.redquark.csfundamentals.designpatterns.behavioral.visitor;

/**
 * @Author Anirudh Sharma
 */
public interface Visitor {

	void visit(HTMLElement htmlElement);

	void visit(HTMLParentElement htmlParentElement);
}
