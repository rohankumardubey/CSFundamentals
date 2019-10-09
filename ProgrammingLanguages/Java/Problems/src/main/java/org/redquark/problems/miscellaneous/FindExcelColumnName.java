package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * @author Anirudh Sharma
 *
 */
public class FindExcelColumnName {

	public static void main(String[] args) {

		// Scanner instance to get the column number from the user
		Scanner in = new Scanner(System.in);
		// Column number
		int columnNumber = in.nextInt();
		// Closing the scanner to avoid memory leak
		in.close();
		
		// Variable to store the column name
		StringBuffer result = new StringBuffer();
		
		// Loop until we have value of columnNumber is greater than 0
		while(columnNumber > 0) {
			
			// Find the remainder after dividing by 26
			int remainder = columnNumber % 26;
			
			// If the number is divisible by 26 then append 'Z'
			if(remainder == 0) {
				result.append("Z");
				columnNumber = columnNumber / 26 - 1;
			} else {
				result.append((char)((remainder - 1) + 'A'));
				columnNumber = columnNumber / 26;
			}
		}
		
		System.out.println(result.reverse());
	}

}
