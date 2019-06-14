package org.redquark.csfundamentals.designpatterns.structural.proxy.protection;

/**
 * @Author Anirudh Sharma
 */
public interface Staff {

	boolean isOwner();

	void setReportGenerator(ReportGeneratorProxy reportGenerator);
}
