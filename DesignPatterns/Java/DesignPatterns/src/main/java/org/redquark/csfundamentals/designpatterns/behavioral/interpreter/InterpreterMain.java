package org.redquark.csfundamentals.designpatterns.behavioral.interpreter;

import java.util.Objects;
import java.util.Stack;

/**
 * @Author Anirudh Sharma
 */
public class InterpreterMain {

	public static void main(String[] args) {

		String tokenString = "7 3 - 2 1 + *";
		Stack<Expression> stack = new Stack<>();
		String[] tokens = tokenString.split(" ");
		for (String s : tokens) {
			if (ExpressionUtil.isOperator(s)) {
				Expression rightExpression = stack.pop();
				Expression leftExpression = stack.pop();
				Expression operator = ExpressionUtil.getOperator(s, leftExpression, rightExpression);
				int result = Objects.requireNonNull(operator).interpret();
				stack.push(new Number(result));
			} else {
				Expression i = new Number(Integer.parseInt(s));
				stack.push(i);
			}
		}

		System.out.println("( " + tokenString + " ): " + stack.pop().interpret());
	}
}
