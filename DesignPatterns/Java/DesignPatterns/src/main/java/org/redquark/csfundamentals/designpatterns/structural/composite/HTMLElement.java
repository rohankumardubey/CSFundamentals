package org.redquark.csfundamentals.designpatterns.structural.composite;

/**
 * @Author Anirudh Sharma
 */
public class HTMLElement extends HTMLTag {

	private String tagName;
	private String startTag;
	private String endTag;
	private String tagBody;

	public HTMLElement(String tagName) {
		this.tagName = tagName;
		this.startTag = "";
		this.endTag = "";
		this.tagBody = "";
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
	public void setTagBody(String tagBody) {
		this.tagBody = tagBody;
	}

	@Override
	public void generateHTML() {
		System.out.println(startTag + "" + tagBody + "" + endTag);
	}
}
