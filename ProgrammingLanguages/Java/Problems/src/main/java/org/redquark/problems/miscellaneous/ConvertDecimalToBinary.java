package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * @author Anirudh Sharma
 *
 */
public class ConvertDecimalToBinary {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int decimal = in.nextInt();
		in.close();
		convert(decimal);
	}

	/**
	 * This method converts the given decimal number into binary
	 */
	private static void convert(int decimal) {

		if (decimal > 1) {
			convert(decimal >> 1);
		}

		System.out.printf("%d", decimal & 1);
	}
}
