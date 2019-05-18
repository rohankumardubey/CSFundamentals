package org.redquark.csfundamentals.designpatterns.creational.factory;

class ComputerFactory {

	static Computer createComputer(ComputerType type, String ram, String hdd, String cpu) {

		switch (type) {
			case PC:
				return new PC(ram, hdd, cpu);
			case SERVER:
				return new Server(ram, hdd, cpu);
			case SUPERCOMPUTER:
				return new SuperComputer(ram, hdd, cpu);
			default:
				return null;
		}
	}
}
