
package utilities;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Allure;

public class AllureListener implements ITestListener {

    // Get WebDriver from the test class or its parent class
    private WebDriver getDriver(Object testInstance) throws Exception {

        Class<?> clazz = testInstance.getClass();

        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField("driver");
                field.setAccessible(true);

                Object value = field.get(testInstance);

                if (value instanceof WebDriver) {
                    return (WebDriver) value;
                }

            } catch (NoSuchFieldException e) {
                // Search parent class for the driver field
            }

            clazz = clazz.getSuperclass();
        }

        return null;
    }

    // Capture screenshot and attach it to Allure
    private void captureFailureScreenshot(ITestResult result) {

        try {
            WebDriver driver = getDriver(result.getInstance());

            if (driver != null) {
                byte[] screenshot =
                        ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);

                Allure.addAttachment(
                        "Failure Screenshot - " + result.getName(),
                        "image/png",
                        new ByteArrayInputStream(screenshot),
                        ".png"
                );

                System.out.println(
                        "Failure screenshot attached: " + result.getName());

            } else {
                System.err.println(
                        "WebDriver not found for: " + result.getName());
            }

        } catch (Exception e) {
            System.err.println(
                    "Screenshot capture failed: " + e.getMessage());
        }
    }

    // Called when a test starts
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TEST STARTED: " + result.getName());
    }

    // Called when a test passes — no screenshot
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TEST PASSED: " + result.getName());
    }

    // Called when a test fails — capture screenshot
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("TEST FAILED: " + result.getName());
        captureFailureScreenshot(result);
    }

    // Called when a test is skipped — no screenshot
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TEST SKIPPED: " + result.getName());
    }

    // Called when the suite starts
    @Override
    public void onStart(ITestContext context) {
        System.out.println("SUITE STARTED: " + context.getName());
    }

    // Called when the suite finishes
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("SUITE FINISHED: " + context.getName());
    }
}
