package org.redquark.csfundamentals.designpatterns.structural.composite;

import java.util.List;

/**
 * @Author Anirudh Sharma
 */
public abstract class HTMLTag {

	public abstract String getTagName();

	public abstract void setStartTag(String startTag);

	public abstract void setEndTag(String endTag);

	public void setTagBody(String tagBody) {
		throw new UnsupportedOperationException("Current operation is not supported for this object");
	}

	public void addChildTag(HTMLTag htmlTag) {
		throw new UnsupportedOperationException("Current operation is not supported for this object");
	}

	public void removeChildTag(HTMLTag htmlTag) {
		throw new UnsupportedOperationException("Current operation is not supported for this object");
	}

	public List<HTMLTag> getChildren() {
		throw new UnsupportedOperationException("Current operation is not supported for this object");
	}

	public abstract void generateHTML();
}
