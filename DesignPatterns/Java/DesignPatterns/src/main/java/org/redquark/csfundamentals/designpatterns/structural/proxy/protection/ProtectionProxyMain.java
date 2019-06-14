package org.redquark.csfundamentals.designpatterns.structural.proxy.protection;

/**
 * @Author Anirudh Sharma
 */
public class ProtectionProxyMain {

	public static void main(String[] args) {

		Owner owner = new Owner();

		ReportGeneratorProxy reportGeneratorProxy = new ReportGeneratorProtectionProxy(owner);
		owner.setReportGenerator(reportGeneratorProxy);

		Employee employee = new Employee();
		reportGeneratorProxy = new ReportGeneratorProtectionProxy(employee);
		employee.setReportGenerator(reportGeneratorProxy);

		System.out.println("For owner:");
		System.out.println(owner.generateDailyReport());
		System.out.println("For employee:");
		System.out.println(employee.generateDailyReport());
	}
}
