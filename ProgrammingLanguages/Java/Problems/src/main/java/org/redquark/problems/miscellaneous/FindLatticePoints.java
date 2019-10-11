package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * This class determines the number of lattice points for a given radius.
 * Lattice Points are points with coordinates as integers in 2-D space. We need
 * to find these points on the circumference of the circle.
 * 
 * @author Anirudh Sharma
 *
 */
public class FindLatticePoints {

	public static void main(String[] args) {

		// Scanner instance to read the value of radius from the user
		Scanner in = new Scanner(System.in);
		int r = in.nextInt();
		// Close the Scanner instance to avoid memory leaks
		in.close();

		// Count number of lattice points
		int count = 4; // (0, -r), (0, r), (r, 0), (-r,0)

		// Iterate for each integral value of abscissa - x coordinate
		for (int x = 1; x < r; x++) {
			// Find the value of square of ordinate - y coordinate
			int ySquare = r * r - x * x;
			// Get the square root of y - only integral value
			int y = (int) Math.sqrt(ySquare);

			// Compare ySquare with y*y. If equal, means square root of y is an integer thus
			// making it eligible for a lattice point
			if (ySquare == y * y) {
				// Four points will be there - (x, y), (x, -y), (-x, y), (-x, -y)
				count += 4;
			}
		}

		System.out.println("Lattice points: " + count);
	}

}
