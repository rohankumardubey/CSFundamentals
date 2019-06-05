package org.redquark.csfundamentals.designpatterns.structural.facade;

/**
 * @Author Anirudh Sharma
 */
public class ScheduleServerFacade {

	private final ScheduleServer scheduleServer;

	public ScheduleServerFacade(ScheduleServer scheduleServer) {
		this.scheduleServer = scheduleServer;
	}

	public void startServer() {

		System.out.println(scheduleServer.startBooting());
		System.out.println(scheduleServer.readSystemConfigFile());
		System.out.println(scheduleServer.init());
		System.out.println(scheduleServer.initializeContext());
		System.out.println(scheduleServer.initializeListeners());
		System.out.println(scheduleServer.createSystemObjects());
	}

	public void stopServer() {

		System.out.println(scheduleServer.releaseProcesses());
		System.out.println(scheduleServer.destroy());
		System.out.println(scheduleServer.destroySystemObjects());
		System.out.println(scheduleServer.destroyListeners());
		System.out.println(scheduleServer.destroyContext());
		System.out.println(scheduleServer.shutdown());
	}
}
