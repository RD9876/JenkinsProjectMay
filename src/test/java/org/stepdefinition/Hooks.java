package org.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.utilities.BaseClass;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {

	@Before
	public void beforeScenario() {

		System.out.println("Scenario starts...");
		launchBrowser();
		maxWindow();
		applyWaitTimeForAllLocs();
		removeAllCookies();

	}

	// To take screenshot only for failed Scenarios
	@After
	public void afterScenario(Scenario s) throws IOException {

		if (s.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			
			//automatically screenshot will get embedded(inserted) into embeddings folder of jvm report
			//automatically everytime it takes unique filename
			s.embed(screenshot, "image/png");
			
			
			

			// String name = s.getName();
			// String filename = name.replace(" ", "_");
			// takeSnap(filename);

		}
		closeBrowser();

		System.out.println("Scenario ends....");
	}

}
