package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * Given a robot which can only move in four directions, UP(U), DOWN(D),
 * LEFT(L), RIGHT(R). Given a string consisting of instructions to move. Output
 * the coordinates of a robot after executing the instructions. Initial position
 * of robot is at origin(0, 0).
 * 
 * @author Anirudh Sharma
 *
 */
public class RobotPosition {

	public static void main(String[] args) {

		// Scanner instance to get the input from the user
		Scanner in = new Scanner(System.in);
		// Move string
		String move = in.next();
		// Closing the Scanner instance to avoid memory leaks
		in.close();

		// Converting the string to the lower case
		move = move.toLowerCase();

		// Variables for up, down, left and right
		int countUp = 0;
		int countDown = 0;
		int countLeft = 0;
		int countRight = 0;

		// Check for the entire string character by character
		for (int i = 0; i < move.length(); i++) {
			// Current character
			char c = move.charAt(i);
			// Check where the Robot moved
			switch (c) {
			case 'u':
				countUp++;
				break;
			case 'd':
				countDown++;
				break;
			case 'l':
				countLeft++;
				break;
			case 'r':
				countRight++;
				break;
			}
		}

		System.out.println("Final position: (" + (countRight - countLeft) + ", " + (countUp - countDown) + ")");
	}

}
