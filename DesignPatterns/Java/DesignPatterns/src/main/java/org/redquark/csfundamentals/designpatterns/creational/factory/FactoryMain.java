package org.redquark.csfundamentals.designpatterns.creational.factory;

public class FactoryMain {

	public static void main(String[] args) {

		// Getting the instance of PC computer
		Computer pc = ComputerFactory.createComputer(ComputerType.PC, "8 GB", "500 GB", "2.4 GHz");

		// Getting the instance of Server computer
		Computer server = ComputerFactory.createComputer(ComputerType.SERVER, "64 GB", "2 TB", "3.1 GHz");

		// Getting the instance of Super Computer
		Computer superComputer = ComputerFactory.createComputer(ComputerType.SUPERCOMPUTER, "1 TB", " 256 TB", "20.1 GHz");

		if (pc != null) {
			System.out.println("Computer Config: " + pc.getRAM() + ", " + pc.getHDD() + ", " + pc.getCPU());
		}

		if (server != null) {
			System.out.println("Server Config: " + server.getRAM() + ", " + server.getHDD() + ", " + server.getCPU());
		}

		if (superComputer != null) {
			System.out.println("Super Computer Config: " + superComputer.getRAM() + ", " + superComputer.getHDD() +
					", " + superComputer.getCPU());
		}
	}
}
