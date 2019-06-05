package org.redquark.csfundamentals.designpatterns.structural.facade;

/**
 * @Author Anirudh Sharma
 */
public class FacadeMain {

	public static void main(String[] args) {

		// Creating the instance of ScheduleServer
		ScheduleServer scheduleServer = new SchedulerServerImpl();

		// Creating the instance of the Facade class
		ScheduleServerFacade facade = new ScheduleServerFacade(scheduleServer);

		System.out.println("Starting the server...\n");
		facade.startServer();

		System.out.println("Sever has started!\n");

		System.out.println("Stopping the server...\n");
		facade.stopServer();

		System.out.println("Server has stopped!");
	}
}
