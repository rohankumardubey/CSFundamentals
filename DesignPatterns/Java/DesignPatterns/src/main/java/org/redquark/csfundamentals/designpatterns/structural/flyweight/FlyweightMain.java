package org.redquark.csfundamentals.designpatterns.structural.flyweight;

/**
 * @Author Anirudh Sharma
 */
public class FlyweightMain {

	public static void main(String[] args) {

		// Getting instance of the Code class - it is a light weight object
		Code code = new Code();

		// Setting the code type
		code.setCode("C code...");
		// Getting the platform instance for the C language
		Platform platform = PlatformFactory.getPlatformInstance("C");
		// Executing the code
		platform.execute(code);
		System.out.println("********************");

		// Setting the code type
		code.setCode("Java code...");
		// Getting the platform instance for the Jsva language
		platform = PlatformFactory.getPlatformInstance("Java");
		// Executing the code
		platform.execute(code);
		System.out.println("********************");

		// Setting the code type
		code.setCode("Python code...");
		// Getting the platform instance for the Python language
		platform = PlatformFactory.getPlatformInstance("Python");
		// Executing the code
		platform.execute(code);
		System.out.println("********************");

		// Setting the code type
		code.setCode("CPP code...");
		// Getting the platform instance for the CPP language
		platform = PlatformFactory.getPlatformInstance("CPP");
		// Executing the code
		platform.execute(code);
		System.out.println("********************");


	}
}
