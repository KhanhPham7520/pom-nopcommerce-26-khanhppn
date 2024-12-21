package reportConfig;

import commons.AbstractTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestListener extends AbstractTest implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("---------- " + context.getName() + " STARTED test ----------");
        context.setAttribute("WebDriver", this.getDriver());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("---------- " + context.getName() + " FINISHED test ----------");
        ExtentTestManager.endTest();
        ExtentReportManager.getExtentReports().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("---------- " + result.getName() + " STARTED test ----------");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("---------- " + result.getName() + " SUCCESS test ----------");
        ExtentTestManager.getTest().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("---------- " + result.getName() + " FAILED test ----------");

        Object testClass = result.getInstance();
        WebDriver webDriver = ((AbstractTest) testClass).getDriver();
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().fail("Test Failed").addScreenCaptureFromBase64String(base64Screenshot);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("---------- " + result.getName() + " SKIPPED test ----------");
        ExtentTestManager.getTest().skip("Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("---------- " + result.getName() + " FAILED WITH SUCCESS PERCENTAGE test ----------");
    }

}
