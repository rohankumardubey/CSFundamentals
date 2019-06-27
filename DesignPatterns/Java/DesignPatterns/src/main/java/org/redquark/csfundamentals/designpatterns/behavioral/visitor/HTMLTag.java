package org.redquark.csfundamentals.designpatterns.behavioral.visitor;

import java.util.List;

/**
 * @Author Anirudh Sharma
 */
public abstract class HTMLTag implements Element {

	public abstract String getTagName();

	public abstract String getStartTag();

	public abstract void setStartTag(String tag);

	public abstract String getEndTag();

	public abstract void setEndTag(String tag);

	public void setTagBody(String tagBody) {
		throw new UnsupportedOperationException("Current operation is not support for this object");
	}

	public void addChildTag(HTMLTag htmlTag) {
		throw new UnsupportedOperationException("Current operation is not support for this object");
	}

	public void removeChildTag(HTMLTag htmlTag) {
		throw new UnsupportedOperationException("Current operation is not support for this object");
	}

	public List<HTMLTag> getChildren() {
		throw new UnsupportedOperationException("Current operation is not support for this object");
	}

	public abstract void generateHtml();
}
