package org.redquark.csfundamentals.designpatterns.behavioral.visitor;

/**
 * @Author Anirudh Sharma
 */
public class CSSClassVisitor implements Visitor {

	@Override
	public void visit(HTMLElement element) {
		element.setStartTag(element.getStartTag().replace(">", " class=’visitor’>"));
	}

	@Override
	public void visit(HTMLParentElement parentElement) {
		parentElement.setStartTag(parentElement.getStartTag().replace(">", " class  =’visitor’>"));
	}
}
