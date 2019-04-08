package org.redquark.csfundamentals.dswithjava.linkedlists.applications;

import java.text.DecimalFormat;

/**
 * @Author Anirudh Sharma
 * <p>
 * This class represents various operations on a Polynomial.
 * Here we are using Linked Lists to implement polynomials.
 */
public class Polynomial {

	// This number represents the number of decimal places (precision)
	private static final double TOLERANCE = 0.00000001;
	// This will be the head of the linked list - Since we are adjusting the polynomial in the increasing power of
	// variable, this will have the exponent 0 and thus constant. This will be the first node of our linked list.
	private Monomial head;

	/**
	 * Constructor
	 */
	public Polynomial() {
		head = null;
	}

	/**
	 * Adds a new term into the polynomial, assuming that the polynomial
	 * is sorted in order from smallest to largest exponent.
	 *
	 * @param exponent    - exponent of the term
	 * @param coefficient - coefficient of the term
	 */
	public void addTerm(int exponent, double coefficient) {
		if (Math.abs(coefficient) < TOLERANCE) {
			return;
		}
		if (head == null || head.exponent > exponent) {
			head = new Monomial(exponent, coefficient, head);
			return;
		}

		Monomial current = head;
		Monomial previous = null;

		while (current != null && exponent > current.exponent) {
			previous = current;
			current = current.next;
		}
		if (current == null || exponent != current.exponent) {
			if (previous != null) {
				previous.next = new Monomial(exponent, coefficient, current);
			}
		} else {
			current.coefficient += coefficient;
			if (Math.abs(current.coefficient) < TOLERANCE) {
				if (previous != null) {
					previous.next = current.next;
				} else {
					head = head.next;
				}
			}
		}
	}

	/**
	 * Overridden toString() method
	 *
	 * @return String
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Monomial monomial = head; monomial != null; monomial = monomial.next) {
			if (monomial.coefficient < 0) {
				builder.append(" - ").append(monomial.toString());
			} else if (monomial.coefficient > 0 && monomial.exponent == 0) {
				builder.append(monomial.toString());
			} else {
				builder.append(" + ").append(monomial.toString());
			}
		}
		return builder.toString();
	}

	/**
	 * This method adds two polynomials.
	 * This method does not change the original polynomial.
	 *
	 * @param polynomial - Polynomial expression to be added
	 * @return Polynomial
	 */
	public Polynomial add(Polynomial polynomial) {
		Polynomial newPolynomial = copy();
		for (Monomial monomial = polynomial.head; monomial != null; monomial = monomial.next) {
			newPolynomial.addTerm(monomial.exponent, monomial.coefficient);
		}
		return newPolynomial;
	}

	public boolean equals(Polynomial polynomial) {
		Monomial monomial1 = head;
		Monomial monomial2 = polynomial.head;
		while (monomial1 != null && monomial2 != null) {
			if (!monomial1.equals(monomial2)) {
				return false;
			}
			monomial1 = monomial1.next;
			monomial2 = monomial2.next;
		}
		return true;
	}

	/**
	 * This method multiplies the polynomial with a number.
	 * This method does not change the original polynomial
	 *
	 * @param number - the number to be multiplied to a polynomial
	 * @return Polynomial
	 */
	public Polynomial multiply(double number) {
		Polynomial polynomial = copy();
		for (Monomial monomial = polynomial.head; monomial != null; monomial = monomial.next) {
			monomial.coefficient *= number;
		}
		return polynomial;
	}

	/**
	 * This method finds the first order differentiation of a polynomial
	 *
	 * @return Polynomial
	 */
	public Polynomial differentiation() {
		Polynomial polynomial = new Polynomial();
		for (Monomial monomial = head; monomial != null; monomial = monomial.next) {
			if (monomial.exponent != 0) {
				polynomial.addTerm(monomial.exponent - 1, monomial.coefficient * monomial.exponent);
			}
		}
		return polynomial;
	}

	public double evaluate(double value) {
		double finalValue = 0;
		for (Monomial monomial = head; monomial != null; monomial = monomial.next) {
			finalValue += monomial.coefficient * Math.pow(value, monomial.exponent);
		}
		return finalValue;
	}

	private Polynomial copy() {
		Polynomial polynomial = new Polynomial();
		for (Monomial monomial = head; monomial != null; monomial = monomial.next) {
			polynomial.addTerm(monomial.exponent, monomial.coefficient);
		}
		return polynomial;
	}

	/**
	 * The monomial class represents a single term in the polynomial
	 * The exponent
	 * The coefficient
	 * The next pointer
	 * <p>
	 * Mathematically, monomial is the fundamental entity of a polynomial
	 */
	private static class Monomial {

		// Precision in the decimal format
		private DecimalFormat precision = new DecimalFormat("#.####");
		// Exponent of the term
		private int exponent;
		// Coefficient of the variable;
		private double coefficient;
		// The next pointer
		private Monomial next;

		/**
		 * Constructor to initialize the monomial
		 *
		 * @param exponent    - exponent of the term
		 * @param coefficient - coefficient of the term
		 * @param next        - next pointer of the term
		 */
		Monomial(int exponent, double coefficient, Monomial next) {
			this.exponent = exponent;
			this.coefficient = coefficient;
			this.next = next;
		}

		/**
		 * Overridden toString() method
		 *
		 * @return String
		 */
		public String toString() {
			String form = precision.format(Math.abs(coefficient));
			if (exponent == 0) { // For constant term
				return form;
			} else if (exponent == 1) { // For linear term
				return form + "x";
			} else { // For higher power term
				return form + "x^" + exponent;
			}
		}

		/**
		 * Compares the monomial term to check if they are equal
		 *
		 * @param monomial - Monomial term
		 * @return boolean
		 */
		boolean equals(Monomial monomial) {
			return exponent == monomial.exponent && coefficient == monomial.coefficient;
		}
	}
}
