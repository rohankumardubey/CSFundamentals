package org.redquark.csfundamentals.designpatterns.behavioral.template;

/**
 * @Author Anirudh Sharma
 */
public class TemplateMain {

	public static void main(String[] args) {

		System.out.println("For MYSQL....");
		DBConnectionTemplate template = new MySQLConnection();
		template.run();

		System.out.println("For Oracle...");
		template = new OracleConnection();
		template.run();
	}
}
