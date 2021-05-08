package org.testrunner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.utilities.JvmReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources", glue = "org.stepdefinition", snippets = SnippetType.UNDERSCORE, dryRun = false,
monochrome = true, strict = false, plugin = {
		"pretty", "html:src\\test\\resources\\Reports", "json:src\\test\\resources\\Reports\\output.json",
		"junit:src\\test\\resources\\Reports\\fb.xml","rerun:src\\test\\resources\\rerun\\failedscenarios.txt" })

public class TestRunner {

	@AfterClass
	public static void jvmReportGeneration() {

		JvmReport.generateJvmReport(System.getProperty("user.dir") + "\\src\\test\\resources\\Reports\\output.json");

	}

}



/*Run TestRunner class----When scenarios gets failed ,recorded in failedscenarios.txt 
 * 
 * In TestReRunner class---mention the txt file location in features option and then run the ReRunner class
 * */
 