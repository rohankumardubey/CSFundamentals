package org.redquark.java.fundamentals.introduction;

/**
 * @Author Anirudh Sharma
 * <p>
 * This class shows the usage of constructor in Java
 */
public class _03Constructor {

	// Class variable
	private String name;

	/*
	 * There are three types of constructor in java.
	 * 1. Default Constructor
	 * 2. No-Args constructor
	 * 3. Parameterized constructor
	 */

	/*
	 * 1. Default constructor
	 * -----------------------
	 * It’s not required to always provide a constructor implementation in the class code.
	 * If we don’t provide a constructor, then java provides default constructor implementation for us to use.
	 *
	 * Default constructor only role is to initialize the object and return it to the calling code.
	 *
	 * Default constructor is always without argument and provided by java compiler only when there is no existing
	 * constructor defined.
	 *
	 * Most of the time we are fine with default constructor itself as other properties can be accessed and initialized
	 * through getter setter methods.
	 * */

	/*
	 * 2. No argument constructor
	 * ---------------------------
	 * Constructor without any argument is called no-args constructor. It’s like overriding the default constructor and
	 * used to do some pre-initialization stuffs such as checking resources, network connections, logging etc.
	 */

	/**
	 * No argument constructor - This will be called when we create a new instance of the class using the new keyword.
	 */
	private _03Constructor() {
		System.out.println("This is no argument constructor");
	}

	/*
	 * 3. Parameterized constructor
	 * -----------------------------
	 * Constructor with arguments is called parameterized constructor.
	 */
	private _03Constructor(String name) {
		System.out.println("This is parameterized constructor");
		// Initialize the name parameter. It will take the value of passed parameter.
		this.name = name;
		System.out.println("The name passsed as a parameter in the constructor is: " + name);
	}

	private void sampleMethod() {
		System.out.println("This is the method that will be called by the instances of this class");
		System.out.println("name: " + name);
	}

	public static void main(String[] args) {

		// Creating an instance of the class using no-argument constructor
		_03Constructor obj1 = new _03Constructor();

		// Creating an instance of the class using parameterized constructor
		_03Constructor obj2 = new _03Constructor("Anirudh Sharma");

		// Calling the class method using the instances created above
		obj1.sampleMethod();
		obj2.sampleMethod();
	}
}
