package org.redquark.csfundamentals.designpatterns.behavioral.visitor;

/**
 * @Author Anirudh Sharma
 */
public class StyleVisitor implements Visitor {

	@Override
	public void visit(HTMLElement element) {
		element.setStartTag(element.getStartTag().replace(">", " style=’width:46px;’>"));
	}

	@Override
	public void visit(HTMLParentElement parentElement) {
		parentElement.setStartTag(parentElement.getStartTag().replace(">", " style=’width:58px;’>"));
	}
}
