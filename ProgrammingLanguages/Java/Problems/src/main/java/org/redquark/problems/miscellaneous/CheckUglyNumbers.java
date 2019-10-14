package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By
 * convention, 1 is included.
 * 
 * @author Anirudh Sharma
 *
 */
public class CheckUglyNumbers {

	public static void main(String[] args) {

		// Scanner object to read input from the user
		Scanner in = new Scanner(System.in);
		// Number to be checked
		int n = in.nextInt();
		// Closing scanner to avoid memory leaks
		in.close();

		// Divide the number until it is divisible by 2
		while (n % 2 == 0) {
			n = n / 2;
		}

		// Divide the number until it is divisible by 3
		while (n % 3 == 0) {
			n = n / 3;
		}

		// Divide the number until it is divisible by 5
		while (n % 5 == 0) {
			n = n / 5;
		}

		System.out.println(n == 1 ? "Ugly" : "Not ugly");
	}

}
