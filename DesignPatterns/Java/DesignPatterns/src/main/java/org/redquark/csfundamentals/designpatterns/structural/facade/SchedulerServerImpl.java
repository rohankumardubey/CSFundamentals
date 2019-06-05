package org.redquark.csfundamentals.designpatterns.structural.facade;

/**
 * @Author Anirudh Sharma
 */
public class SchedulerServerImpl implements ScheduleServer {

	@Override
	public String startBooting() {
		return "Start booting";
	}

	@Override
	public String readSystemConfigFile() {
		return "Reading system config file";
	}

	@Override
	public String init() {
		return "Initializing stuff...";
	}

	@Override
	public String initializeContext() {
		return "Initializing context...";
	}

	@Override
	public String initializeListeners() {
		return "Initializing listeners...";
	}

	@Override
	public String createSystemObjects() {
		return "Creating system objects";
	}

	@Override
	public String releaseProcesses() {
		return "Releasing proecesses";
	}

	@Override
	public String destroy() {
		return "Destroying...";
	}

	@Override
	public String destroySystemObjects() {
		return "Destroying system objects";
	}

	@Override
	public String destroyListeners() {
		return "Destroying listeners...";
	}

	@Override
	public String destroyContext() {
		return "Destroying context...";
	}

	@Override
	public String shutdown() {
		return "Shutting down";
	}
}
