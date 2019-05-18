package org.redquark.csfundamentals.designpatterns.creational.factory;

public class SuperComputer implements Computer {

	private String ram;
	private String hdd;
	private String cpu;

	SuperComputer(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public String getRAM() {
		return this.ram;
	}

	@Override
	public String getHDD() {
		return this.hdd;
	}

	@Override
	public String getCPU() {
		return this.cpu;
	}

	@Override
	public String toString() {
		return "SuperComputer {ram= " + ram + ", hdd=" + hdd + ", cpu='" + cpu + "}";
	}
}
