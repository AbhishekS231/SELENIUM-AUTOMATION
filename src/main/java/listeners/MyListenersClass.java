package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListenersClass implements ITestListener {
	public void onStart(ITestContext context) {
		// not implemented
		System.out.println("Test execution is start....");
	}

	public void onTestStart(ITestResult result) {
		// not implemented
		System.out.println("Test  start....");
	}

	public void onTestSuccess(ITestResult result) {
		// not implemented
		System.out.println("Test is passed....");
	}

	public void onTestFailure(ITestResult result) {
		// not implemented
		System.out.println("Test is faliled..");
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
		System.out.println("Test is skipp..");
	}

	public void onFinish(ITestContext context) {
		// not implemented
		System.out.println("Test execution is finished..");
	}
}
