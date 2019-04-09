package org.redquark.csfundamentals.dswithjava.tests.linkedlists.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.redquark.csfundamentals.dswithjava.linkedlists.problems.Palindrome;

public class PalindromeTest<T> {

	// Instance of the palindrome class
	private Palindrome<Character> palindrome;

	@Before
	public void setUp() {
		// Initializing the instance
		palindrome = new Palindrome<>();

		// Add some data
		palindrome.add('R');
		palindrome.add('A');
		palindrome.add('D');
		palindrome.add('A');
		palindrome.add('R');
	}

	@Test
	public void testCheckPalindrome() {
		Assert.assertTrue(palindrome.checkPalindrome());
	}
}
