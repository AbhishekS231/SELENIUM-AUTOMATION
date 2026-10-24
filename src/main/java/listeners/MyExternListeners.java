package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyExternListeners implements ITestListener {
    // Extent report related variables
    public ExtentSparkReporter sparkReporter; // for UI
    public ExtentReports extent; // populate common info
    public ExtentTest test; // update test case

    // Method executed at the start of the test suite
    public void onStart(ITestContext context) {
        // Initialize ExtentReports and configure the reporter
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/MyReport.html");
        sparkReporter.config().setDocumentTitle("Automation Reports");
        sparkReporter.config().setReportName("Functional Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports(); // Initialize ExtentReports once
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("ComputerInfo", "Local");
        extent.setSystemInfo("QA Name", "Abhishek");
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("Browser", "Chrome");
    }

    // Method executed when a test starts
    public void onTestStart(ITestResult result) {
        // Create a new test entry for each test case
        test = extent.createTest(result.getName());
    }

    // Method executed when a test is successful
    public void onTestSuccess(ITestResult result) {
        // Log success status for the test
        test.log(Status.PASS, "Test Case Passed: " + result.getName());
    }

    // Method executed when a test fails
    public void onTestFailure(ITestResult result) {
        // Log failure status for the test
        test.log(Status.FAIL, "Test Case Failed: " + result.getName());
        test.log(Status.FAIL, "Failure Cause: " + result.getThrowable());
    }

    // Method executed when a test is skipped
    public void onTestSkipped(ITestResult result) {
        // Log skipped status for the test
        test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
    }

    // Method executed at the end of the test suite
    public void onFinish(ITestContext context) {
        // Flush the report after all tests have completed
        extent.flush();
    }
}

