package org.redquark.csfundamentals.designpatterns.structural.facade;

/**
 * @Author Anirudh Sharma
 */
public interface ScheduleServer {

	// Starting the server
	String startBooting();

	String readSystemConfigFile();

	String init();

	String initializeContext();

	String initializeListeners();

	String createSystemObjects();


	// Stopping the server
	String releaseProcesses();

	String destroy();

	String destroySystemObjects();

	String destroyListeners();

	String destroyContext();

	String shutdown();
}
