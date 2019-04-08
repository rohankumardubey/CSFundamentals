package org.redquark.csfundamentals.dswithjava.tests.linkedlists.applications;

import org.junit.Before;
import org.junit.Test;
import org.redquark.csfundamentals.dswithjava.linkedlists.applications.Polynomial;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PolynomialTest {

	private Polynomial first;
	private Polynomial second;

	@Before
	public void setUp() {
		// Creating the instances of Polynomial class
		first = new Polynomial();
		second = new Polynomial();

		first.addTerm(1, 2.1);
		first.addTerm(4, 3.3);
		first.addTerm(3, -4.5);
		first.addTerm(0, -5.4);
		first.addTerm(3, -2.8);

		second.addTerm(3, -2.9);
		second.addTerm(1, 5.9);
		second.addTerm(2, -9.5);
		second.addTerm(0, 4.3);
	}

	@Test
	public void testToString() {
		assertEquals(first.toString(), " - 5.4 + 2.1x - 7.3x^3 + 3.3x^4");
		assertEquals(second.toString(), "4.3 + 5.9x - 9.5x^2 - 2.9x^3");
	}

	@Test
	public void testEquals() {
		assertFalse(first.equals(second));
		assertFalse(second.equals(first));
		assertTrue(first.equals(first));
		assertTrue(second.equals(second));
	}

	@Test
	public void testAdd() {
		assertEquals(first.add(second).toString(), " - 1.1 + 8x - 9.5x^2 - 10.2x^3 + 3.3x^4");
	}

	@Test
	public void testMultiply() {
		assertEquals(first.multiply(3).toString(), " - 16.2 + 6.3x - 21.9x^3 + 9.9x^4");
		assertEquals(second.multiply(2.6).toString(), "11.18 + 15.34x - 24.7x^2 - 7.54x^3");
	}

	@Test
	public void testDifferentiation() {
		assertEquals(first.differentiation().toString(), "2.1 - 21.9x^2 + 13.2x^3");
		assertEquals(second.differentiation().toString(), "5.9 - 19x - 8.7x^2");
	}

	@Test
	public void testEvaluate() {
		assertEquals(first.evaluate(2), -6.8, 0.02);
		assertEquals(second.evaluate(2.76), -112.754, 0.02);
	}
}
