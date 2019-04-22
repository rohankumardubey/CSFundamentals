package org.redquark.csfundamentals.dswithjava.stacks.problems;

import org.redquark.csfundamentals.dswithjava.stacks.Stack;

/**
 * This class converts an infix expression to postfix notation
 *
 * @Author Anirudh Sharma
 */
public class InfixToPostfix {

	/**
	 * This method determines the precedence of the operator
	 *
	 * @param c - character encountered in the expression
	 * @return @{@link Integer}
	 */
	private int precedence(char c) {
		switch (c) {
			case '+':
			case '-':
				return 1;

			case '*':
			case '/':
				return 2;

			case '^':
				return 3;
		}
		return -1;
	}

	public String infixToPostfix(String infix) {

		// StringBuilder to hold the result
		StringBuilder stringBuilder = new StringBuilder();

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);

			// If scanned character is an operand, add it to the result string
			if (Character.isLetterOrDigit(c)) {
				stringBuilder.append(c);
			}
			// If the scanned character is an '(', push it to the stack
			else if (c == '(') {
				stack.push(c);
			}
			// If the scanned character is an ')', pop and output from the stack until an '(' is encountered.
			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					stringBuilder.append(stack.pop());
				}
				if (!stack.isEmpty() && stack.peek() != '(') {
					throw new RuntimeException("Invalid expression");
				} else {
					stack.pop();
				}
			}
			// If an operator is encountered
			else {
				while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
					stringBuilder.append(stack.pop());
				}
				stack.push(c);
			}
		}
		while (!stack.isEmpty()) {
			stringBuilder.append(stack.pop());
		}
		return stringBuilder.toString();
	}
}
