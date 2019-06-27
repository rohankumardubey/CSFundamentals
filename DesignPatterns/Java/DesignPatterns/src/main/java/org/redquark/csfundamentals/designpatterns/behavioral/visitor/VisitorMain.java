package org.redquark.csfundamentals.designpatterns.behavioral.visitor;

/**
 * @Author Anirudh Sharma
 */
public class VisitorMain {

	public static void main(String[] args) {

		System.out.println("Before visitor......... \\n");
		HTMLTag parentTag = new HTMLParentElement("<html>");
		parentTag.setStartTag("<html>");
		parentTag.setEndTag("</html>");
		HTMLTag p1 = new HTMLParentElement("<body>");
		p1.setStartTag("<body>");
		p1.setEndTag("</body>");
		parentTag.addChildTag(p1);
		HTMLTag child1 = new HTMLElement("<P>");
		child1.setStartTag("<P>");
		child1.setEndTag("</P>");
		child1.setTagBody("Testing html tag library");
		p1.addChildTag(child1);
		child1 = new HTMLElement("<P>");
		child1.setStartTag("<P>");
		child1.setEndTag("</P>");
		child1.setTagBody("Paragraph 2");
		p1.addChildTag(child1);
		parentTag.generateHtml();
		System.out.println("\\nAfter visitor....... \\n");
		Visitor cssClass = new CSSClassVisitor();
		Visitor style = new StyleVisitor();
		parentTag = new HTMLParentElement("<html>");
		parentTag.setStartTag("<html>");
		parentTag.setEndTag("</html>");
		parentTag.accept(style);
		parentTag.accept(cssClass);
		p1 = new HTMLParentElement("<body>");
		p1.setStartTag("<body>");
		p1.setEndTag("</body>");
		p1.accept(style);
		p1.accept(cssClass);
		parentTag.addChildTag(p1);
		child1 = new HTMLElement("<P>");
		child1.setStartTag("<P>");
		child1.setEndTag("</P>");
		child1.setTagBody("Testing html tag library");
		child1.accept(style);
		child1.accept(cssClass);
		p1.addChildTag(child1);
		child1 = new HTMLElement("<P>");
		child1.setStartTag("<P>");
		child1.setEndTag("</P>");
		child1.setTagBody("Paragraph 2");
		child1.accept(style);
		child1.accept(cssClass);
		p1.addChildTag(child1);
		parentTag.generateHtml();

	}
}
