package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * Write code to convert a given number into words. For example, if “1234” is
 * given as input, output should be “one thousand two hundred thirty four”.
 * 
 * @author Anirudh Sharma
 *
 */
public class ConvertNumberToWords {

	// Array for the bigger units of numbers
	private static final String[] biggerUnits = { "", " thousand", " million", " billion", " trillion", " quadrillion",
			" quintillion" };

	// Array for tens position
	private static final String[] tens = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy",
			" eighty", " ninety" };

	// Array for one position and from 10 to 19
	private static final String[] ones = { "", " one", " two", " three", " four", " five", " six", " seven", " eight",
			" nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen",
			" eighteen", " nineteen" };

	/**
	 * This method is used to convert the numbers which are less than 1000
	 */
	private static String convertLessThanOneThousand(int number) {
		String current;

		if (number % 100 < 20) {
			current = ones[number % 100];
			number /= 100;
		} else {
			current = ones[number % 10];
			number /= 10;

			current = tens[number % 10] + current;
			number /= 10;
		}
		if (number == 0)
			return current;
		return ones[number] + " hundred" + current;
	}

	/**
	 * This method converts the entered number into the words
	 */
	public static String convert(long number) {

		if (number == 0) {
			return "zero";
		}

		String prefix = "";

		if (number < 0) {
			number = -number;
			prefix = "minus";
		}

		String current = "";
		int place = 0;

		do {
			long n = number % 1000;
			if (n != 0) {
				String s = convertLessThanOneThousand((int) n);
				current = s + biggerUnits[place] + current;
			}
			place++;
			number /= 1000;
		} while (number > 0);

		return (prefix + current).trim();
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		in.close();

		System.out.println(n + " in words: " + convert(n));
	}

}
