package org.redquark.csfundamentals.dswithjava.tests.stacks.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.redquark.csfundamentals.dswithjava.stacks.problems.InfixToPostfix;

/**
 * @Author Anirudh Sharma
 * <p>
 * This class tests the class responsible for converting infix to postfix expression
 */
public class InfixToPostfixTest {

	// Instance
	private InfixToPostfix infixToPostfix;

	// Expression
	private String infix;

	@Before
	public void setUp() {
		// Initialization
		infixToPostfix = new InfixToPostfix();

		infix = "a+b*(c^d-e)^(f+g*h)-i";
	}

	@Test
	public void testInfixToPostfix() {
		Assert.assertEquals(infixToPostfix.infixToPostfix(infix), "abcd^e-fgh*+^*+i-");
	}
}
