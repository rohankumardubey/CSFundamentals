package org.redquark.java.fundamentals.introduction;

import java.util.Scanner;

/**
 * @Author Anirudh Sharma
 * <p>
 * This class shows the usage of methods in java. A java method is a collection of statements to process some
 * specific task and return the response to the caller. Methods allow us to write reusable code and dividing our
 * program into several small units of work. Java Method promotes clean and more readable code.
 */
public class _02Methods {

	public static void main(String[] args) {

		// Scanner class to read inputs
		Scanner in = new Scanner(System.in);

		System.out.println("Enter two floating point numbers for mathematical operations");

		// Reading inputs from the user
		double x = in.nextDouble();
		double y = in.nextDouble();

		// Creating an instance of the class to call methods
		_02Methods obj = new _02Methods();

		// Performing mathematical operations via methods
		System.out.println("Mathematical operations >>>");

		// Each of the below four methods perform specific tasks of addition, subtraction, multiplication and division.
		System.out.println(x + " + " + y + " = " + obj.addition(x, y));
		System.out.println(x + " - " + y + " = " + obj.subtraction(x, y));
		System.out.println(x + " * " + y + " = " + obj.multiplication(x, y));
		System.out.println(x + " / " + y + " = " + obj.division(x, y));

	}

	/**
	 * @param x - first input
	 * @param y - second input
	 * @return addition of two inputs
	 */
	private double addition(double x, double y) {
		return x + y;
	}

	/**
	 * @param x - first input
	 * @param y - second input
	 * @return subtraction of two inputs
	 */
	private double subtraction(double x, double y) {
		return x - y;
	}

	/**
	 * @param x - first input
	 * @param y - second input
	 * @return multiplication of two inputs
	 */
	private double multiplication(double x, double y) {
		return x * y;
	}

	/**
	 * @param x - first input
	 * @param y - second input
	 * @return division of two inputs
	 */
	private double division(double x, double y) {
		return x / y;
	}
}
