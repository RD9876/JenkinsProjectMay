package org.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReport {

	public static void generateJvmReport(String jsonPath) {
		// 1.Mention the target folder where you want to generate reports
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Reports\\JvmReport");

		// 2.Add details to the report
		Configuration con = new Configuration(f, "Facebook Application");
		con.addClassifications("platform1 name", "Windows");
		con.addClassifications("platform version", "10");
		con.addClassifications("Browser name", "Chrome");
		con.addClassifications("Browser version", "89.0");

		// 3.converting String into List<String>
		List<String> li = new ArrayList<String>();
		li.add(jsonPath);

		// 4.Create object for ReportBuilder-predefined class,using which we can call
		// generateReports method
		ReportBuilder r = new ReportBuilder(li, con);
		r.generateReports();

	}

}
