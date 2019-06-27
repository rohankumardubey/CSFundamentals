package org.redquark.csfundamentals.designpatterns.behavioral.visitor;

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
		this.tagBody = "";
		this.startTag = "";
		this.endTag = "";
	}

	@Override
	public String getTagName() {
		return tagName;
	}

	@Override
	public String getStartTag() {
		return startTag;
	}

	@Override
	public void setStartTag(String tag) {
		this.startTag = tag;
	}

	@Override
	public String getEndTag() {
		return endTag;
	}

	@Override
	public void setEndTag(String tag) {
		this.endTag = tag;
	}

	@Override
	public void setTagBody(String tagBody) {
		this.tagBody = tagBody;
	}

	@Override
	public void generateHtml() {
		System.out.println(startTag + "" + tagBody + "" + endTag);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
