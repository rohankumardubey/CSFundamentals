package org.redquark.csfundamentals.designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * This class will return the ype of the pltform object based on the language type selected by the user
 *
 * @Author Anirudh Sharma
 */
public final class PlatformFactory {

	private static Map<String, Platform> platformMap = new HashMap<>();

	private PlatformFactory() {
		throw new AssertionError("Cannot instantiate the class");
	}

	public static synchronized Platform getPlatformInstance(String platformType) {

		// Getting the platform implementation object based on the specified platform type
		Platform platform = platformMap.get(platformType);

		// This will execute only if the platform object of the specified type is not already present
		if (platform == null) {
			switch (platformType) {
				case "Java":
					platform = new JavaPlatform();
					break;

				case "CPP":
					platform = new CPPPlatform();
					break;

				case "C":
					platform = new CPlatform();
					break;

				case "Python":
					platform = new PythonPlatform();
					break;
			}
			platformMap.put(platformType, platform);
		}
		return platform;
	}
}
