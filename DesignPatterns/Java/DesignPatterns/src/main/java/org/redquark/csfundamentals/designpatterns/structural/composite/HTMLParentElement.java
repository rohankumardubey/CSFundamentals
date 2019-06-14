package org.redquark.csfundamentals.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Anirudh Sharma
 */
public class HTMLParentElement extends HTMLTag {

	private String tagName;
	private String startTag;
	private String endTag;
	private List<HTMLTag> childrenTag;

	public HTMLParentElement(String tagName) {
		this.tagName = tagName;
		this.startTag = "";
		this.endTag = "";
		this.childrenTag = new ArrayList<>();
	}

	@Override
	public String getTagName() {
		return tagName;
	}

	@Override
	public void setStartTag(String startTag) {
		this.startTag = startTag;
	}

	@Override
	public void setEndTag(String endTag) {
		this.endTag = endTag;
	}

	@Override
	public void addChildTag(HTMLTag htmlTag) {
		childrenTag.add(htmlTag);
	}

	@Override
	public void removeChildTag(HTMLTag htmlTag) {
		childrenTag.remove(htmlTag);
	}

	@Override
	public List<HTMLTag> getChildren() {
		return childrenTag;
	}

	@Override
	public void generateHTML() {
		System.out.println(startTag);
		for (HTMLTag htmlTag : childrenTag) {
			htmlTag.generateHTML();
		}
		System.out.println(endTag);
	}
}
