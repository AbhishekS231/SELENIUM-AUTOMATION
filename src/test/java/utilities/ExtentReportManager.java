package utilities;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    String repName;

   
    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "Test-Report-" + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName); // Report location
        sparkReporter.config().setDocumentTitle("ProsMarketplace Automation Report"); // Report title
        sparkReporter.config().setReportName("ProsMarketplace Functional Testing"); // Report name
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Adding system information to the report
        extent.setSystemInfo("Application", "ProsMarketplace");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
    }

  
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups()); // Group info in report
        test.log(Status.PASS, result.getName() + " got successfully executed");
    }

   
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, result.getName() + " got failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        String imgPath = new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgPath); // Add screenshot to report
    }

 
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName() + " got skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

   
    public void onFinish(ITestContext testContext) {
        extent.flush();

        String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
        File extentReport = new File(pathOfExtentReport);

        // Open the report in the default browser
        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add additional system info
        String os = testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os);

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);

        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includedGroups.toString());
        }

        // Email functionality
        try {
            // Create the URL for the generated extent report
            URL url = new URL("file:///" + pathOfExtentReport);

            // Create the email message
        /*   ImageHtmlEmail email = new ImageHtmlEmail();
            email.setDataSourceResolver(new DataSourceUrlResolver(url));
            email.setHostName("smtp.googlemail.com"); // SMTP server
            email.setSmtpPort(465); // SMTP port
            email.setAuthenticator(new DefaultAuthenticator("your_email@gmail.com", "your_password")); // Email credentials
            email.setSSLOnConnect(true); // Enable SSL for secure email sending
            email.setFrom("your_email@gmail.com"); // Sender's email
            email.setSubject("Test Results"); // Email subject
            email.setMsg("Please find the attached test report."); // Email message
            email.addTo("recipient_email@gmail.com"); // Receiver's email
            email.attach(url, "Extent Report", "Please check the attached report."); // Attach the report to the email
            email.send(); // Send the email */
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
    }
}

