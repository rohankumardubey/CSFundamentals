package org.redquark.csfundamentals.designpatterns.structural.composite;

/**
 * @Author Anirudh Sharma
 */
public class CompositeMain {

	public static void main(String[] args) {

		HTMLTag parentTag = new HTMLParentElement("<html>");
		parentTag.setStartTag("<html>");
		parentTag.setEndTag("</html>");

		HTMLTag p1 = new HTMLParentElement("<body>");
		p1.setStartTag("<body>");
		p1.setEndTag("</body");

		parentTag.addChildTag(p1);

		HTMLTag child1 = new HTMLElement("<p>");
		child1.setStartTag("<p>");
		child1.setEndTag("</p>");
		child1.setTagBody("Testing HTML tag library");
		p1.addChildTag(child1);

		child1 = new HTMLElement("<p>");
		child1.setStartTag("<p>");
		child1.setEndTag("</p>");
		child1.setTagBody("Paragraph 2");
		p1.addChildTag(child1);

		parentTag.generateHTML();
	}
}
