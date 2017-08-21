package com.williamHill.listeners;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

import com.williamHill.Testcases.TestBase;
import com.williamHill.util.ErrorUtil;

public class TestsListenerAdapter implements IInvokedMethodListener {

	public void afterInvocation(IInvokedMethod method, ITestResult result) {
		Reporter.setCurrentTestResult(result);
		System.out.println("*************TestsListenerAdapter******************");

		if (method.isTestMethod()) {
			List<Throwable> verificationFailures = ErrorUtil.getVerificationFailures();
			// if there are verification failures...
			if (verificationFailures.size() != 0) {
				// set the test to failed
				result.setStatus(ITestResult.FAILURE);

				// if there is an assertion failure add it to
				// verificationFailures
				if (result.getThrowable() != null) {
					verificationFailures.add(result.getThrowable());
				}

				int size = verificationFailures.size();
				// if there's only one failure just set that
				if (size == 1) {
					result.setThrowable(verificationFailures.get(0));
				} else {
					// create a failure message with all failures and stack
					// traces (except last failure)
					StringBuffer failureMessage = new StringBuffer("Multiple failures (").append(size).append("):nn");
					for (int i = 0; i < size - 1; i++) {
						failureMessage.append("Failure ").append(i + 1).append(" of ").append(size).append(":n");
						Throwable t = verificationFailures.get(i);
						String fullStackTrace = Utils.stackTrace(t, false)[1];
						failureMessage.append(fullStackTrace).append("nn");
					}

					// final failure
					Throwable last = verificationFailures.get(size - 1);
					failureMessage.append("Failure ").append(size).append(" of ").append(size).append(":n");
					failureMessage.append(last.toString());

					// set merged throwable
					Throwable merged = new Throwable(failureMessage.toString());
					merged.setStackTrace(last.getStackTrace());

					result.setThrowable(merged);

				}
			}
		}

	}

	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
	}

	/**
	 * @Method: onTestFailure
	 * @param: result
	 * @Description:This method take screenshot if any of the testcases will
	 *                   fail
	 * @author :swathi Gunuputi
	 */
	public void onTestFailure(ITestResult result) {

		File scrFile = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ssaa");
		String destDir = "target/surefire-reports/screenshots";
		new File(destDir).mkdirs();
		String destFile = dateFormat.format(new Date()) + ".png";
		File outputFile = new File(destDir + "/" + destFile);
		try {

			FileUtils.copyFile(scrFile, outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Reporter.log("Saved <a href=../screenshots/" + outputFile.getName() + ">Screenshot</a>");

	}

}
