package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import extentReports.ExtentReportManager;

public class Listeners extends ExtentReportManager implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String testCaseName= result.getName();
		test=extent.createTest(testCaseName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
		test.log(Status.PASS, MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL,MarkupHelper.createLabel(result.getName() + "Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL,result.getThrowable());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.getStatus()==ITestResult.SKIP) {
		test.log(Status.SKIP,MarkupHelper.createLabel(result.getName() + "Test Case Skipped", ExtentColor.YELLOW));
		test.log(Status.SKIP,result.getThrowable());
	}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
