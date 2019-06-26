package org.redquark.csfundamentals.designpatterns.behavioral.interpreter;

/**
 * @Author Anirudh Sharma
 */
public class ExpressionUtil {

	public static boolean isOperator(String s) {
		return s.equals("+") || s.equals("-") || s.equals("*");
	}

	public static Expression getOperator(String s, Expression left, Expression right) {
		switch (s) {
			case "+":
				return new Add(left, right);

			case "-":
				return new Subtract(left, right);

			case "*":
				return new Product(left, right);
		}
		return null;
	}
}
