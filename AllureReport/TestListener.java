import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class TestListener implements ITestListener {

	private static String getTestMehodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String strMessages) {
		return strMessages;
	}

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess " + getTestMehodName(result) + " Passed");
		saveTextLog(getTestMehodName(result) + "Passed and screenshot taken");
	}

	@Override
	public void onTestFailure(ITestResult result) {
			System.out.println("onTestFailureMethod " + getTestMehodName(result) + " Failed");
			saveTextLog(getTestMehodName(result) + "failed and screenshot taken");
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}
}
