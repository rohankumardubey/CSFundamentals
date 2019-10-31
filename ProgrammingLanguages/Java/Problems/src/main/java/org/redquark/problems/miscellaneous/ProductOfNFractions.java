package org.redquark.problems.miscellaneous;

/**
 * Given the Numerator and Denominator of N fractions. The task is to find the
 * product of N fraction and output the answer in reduced form.
 * 
 * @author Anirudh Sharma
 *
 */
public class ProductOfNFractions {

	public static void main(String[] args) {

		int[] numerators = { 1, 2, 5 };
		int[] denominators = { 2, 1, 6 };

		System.out.println("Product: " + getProduct(numerators, denominators));
	}

	/**
	 * This method returns the product of n fractions
	 */
	private static String getProduct(int[] numerators, int[] denominators) {

		// Intermediate numerator and denominator
		int intermediateNumerator = 1;
		int intermediateDenominator = 1;

		// Find the product of numerators and denominators
		for (int i = 0; i < numerators.length; i++) {
			intermediateNumerator *= numerators[i];
			intermediateDenominator *= denominators[i];
		}

		// Find the GCD of two numbers
		int gcd = gcd(intermediateNumerator, intermediateDenominator);

		// Reduced numerators and denominators
		intermediateNumerator /= gcd;
		intermediateDenominator /= gcd;

		return intermediateNumerator + "/" + intermediateDenominator;
	}

	private static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}
}
