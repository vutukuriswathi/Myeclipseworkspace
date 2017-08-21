package com.abc.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import net.masterthought.cucumber.ReportBuilder;

public class GenerateTestReport {

	List<String> jsonReport = new ArrayList<String>();
	File reportDirectory;
	String pluginUrlPath;
	String buildNumber;
	String buildProject;
	boolean skippedFails;
	boolean undefinedFails;
	boolean flashCharts;
	boolean runWithJenkins;

	@Test
	public void generateCustomReport() throws Exception {
		String jsonFilePath = System.getProperty("user.dir") + "/target/cucumber.json";
		jsonReport.add(jsonFilePath);
		reportDirectory = new File(System.getProperty("user.dir") + "/target/cucumber-html-Reports");
		pluginUrlPath = "";
		buildNumber = "1";
		buildProject = "ABCNews";
		skippedFails = true;
		undefinedFails = true;
		flashCharts = true;
		runWithJenkins = false;
		boolean artificatsEnabled = false;
		String artifactsConfig = "";
		boolean highCharts = true;
		ReportBuilder reportBuilder = new ReportBuilder(jsonReport, reportDirectory, pluginUrlPath, buildNumber,
				buildProject, skippedFails, undefinedFails, flashCharts, runWithJenkins, artificatsEnabled,
				artifactsConfig, highCharts);
		reportBuilder.generateReports();

	}
}
