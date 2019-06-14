package org.redquark.csfundamentals.designpatterns.structural.proxy.protection;


/**
 * @Author Anirudh Sharma
 */
public class Owner implements Staff {

	private ReportGeneratorProxy reportGenerator;

	@Override
	public boolean isOwner() {
		return true;
	}

	@Override
	public void setReportGenerator(ReportGeneratorProxy reportGenerator) {
		this.reportGenerator = reportGenerator;
	}

	public String generateDailyReport() {
		try {
			return reportGenerator.generateDailyReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
